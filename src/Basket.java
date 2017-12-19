import io.Reader;
import io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 18.12.17 with love.
 */
@WebServlet("/basket")
public class Basket extends HttpServlet {
    private ArrayList<Staff> staff =  new ArrayList<Staff>();
    private HashMap<String, String> allEmails;
    private HashMap<String, ArrayList<String>> basket = new HashMap<String, ArrayList<String>>();
    private String pathEmails = "/root/IdeaProjects/Marketplace/mails.txt";
    private String pathBasket = "/root/IdeaProjects/Marketplace/basket.txt";


    public Basket(){
        allEmails = new Reader(pathEmails).read();
        try {
            basket = new Reader(pathBasket).readBasket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("allStaff") != null) {
            staff = (ArrayList<Staff>) session.getAttribute("allStaff");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("allStaff") != null) {
            staff = (ArrayList<Staff>) session.getAttribute("allStaff");
        }
        if(request.getParameter("staffNameForAdd") != null) {
            ArrayList<String> inBasket;
            if(session.getAttribute("inBasket") != null) {
                inBasket = (ArrayList<String>) session.getAttribute("inBasket");
            } else {
                inBasket = new ArrayList<String>();
            }
            Staff stf = new Staff("notFound","notFound","notFound",0,0, "notFound");
            for(int i = 0; i < staff.size(); i++) {
                Staff tmpS = staff.get(i);
                String tmp = tmpS.getName();
                String forAdd = request.getParameter("staffNameForAdd");
                if(tmp.equals(forAdd)) {
                    stf = staff.get(i);
                    if(session.getAttribute("username") != null) {
                        rememberBasketAfterAdd((String) session.getAttribute("username"), forAdd);
                    }
                    break;
                }
            }
            inBasket.add(stf.toString());
            session.setAttribute("inBasket", inBasket);
        } else {
            if(request.getParameter("staffNameForRemove") != null) {
                ArrayList<String> inBasket;
                if(session.getAttribute("inBasket") != null) {
                    inBasket = (ArrayList<String>) session.getAttribute("inBasket");
                    for(int i = 0; i < inBasket.size(); i++) {
                        if(inBasket.get(i).contains(request.getParameter("staffNameForRemove"))) {
                            inBasket.remove(i);
                            if(session.getAttribute("username") != null) {
                                rememberBasketAfterDelete((String) session.getAttribute("username"),
                                        request.getParameter("staffNameForRemove"));
                            }
                            break;
                        }
                    }
                    session.setAttribute("inBasket", inBasket);
                }
            } else {
                request.getRequestDispatcher("basket.jsp").forward(request, response);
            }
        }
    }

    private void rememberBasketAfterAdd(String username, String itemName) {
        if(basket.get(username) != null) {
            ArrayList<String> list = basket.get(username);
            list.add(itemName);
            basket.remove(username);
            basket.put(username, list);
            Writer thread = new Writer(basket);
            thread.start();
        } else {
            ArrayList<String> list = new ArrayList<String>();
            list.add(itemName);
            basket.remove(username);
            basket.put(username, list);
            Writer thread = new Writer(basket);
            thread.start();
        }
    }

    private void rememberBasketAfterDelete(String username, String itemName) {
        if(basket.get(username) != null) {
            ArrayList<String> list = basket.get(username);
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).equals(itemName)) {
                    list.remove(i);
                    break;
                }
            }
            basket.remove(username);
            basket.put(username, list);
            Writer thread = new Writer(basket);
            thread.start();
        }
    }
}
