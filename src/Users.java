import io.Reader;
import io.SendEmail;
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
import java.util.Map;

/**
 * Created by root on 17.12.17 with love.
 */
@WebServlet("/reg")
public class Users extends HttpServlet {

    private HashMap<String, String> allUsers;
    private HashMap<String, String> allEmails;
    private String pathUsers = "/root/IdeaProjects/Marketplace/users.txt";
    private String pathEmails = "/root/IdeaProjects/Marketplace/mails.txt";

    public Users() {
        allUsers = new Reader(pathUsers).read();
        allEmails = new Reader(pathEmails).read();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("/market").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String newEmail = request.getParameter("newEmail");
        if(newPassword != null && newUsername != null && newEmail != null) {
            if(!checkExistEmail(newEmail)) {
                if (!checkExist(newUsername)) {
                    String passcode = new SendEmail().send(newEmail);
                    allUsers.put(newUsername, passcode);
                    allEmails.put(newUsername, newEmail);
                    Writer thread = new Writer(allUsers, pathUsers);
                    Writer thread1 = new Writer(allEmails, pathEmails);
                    thread.start();
                    thread1.start();
                    request.getRequestDispatcher("/market").forward(request, response);
                } else {
                    request.setAttribute("whatDo", "Username or Password already use!");
                    request.getRequestDispatcher("somethingWrong.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("whatDo", "Email already use!");
                request.getRequestDispatcher("somethingWrong.jsp").forward(request, response);
            }
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(username != null && password != null) {
                if (checkUser(username, password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    try {
                        addInBasketInSession(session);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    request.getRequestDispatcher("/market").forward(request, response);
                } else {
                    request.setAttribute("whatDo", "Invalid Username or Password!");
                    request.getRequestDispatcher("somethingWrong.jsp").forward(request, response);
                }
            } else {
                HttpSession session = request.getSession();
                session.invalidate();
            }
        }
    }

    private void addInBasketInSession(HttpSession session) throws IOException {
        ArrayList<Staff> staff = (ArrayList<Staff>) session.getAttribute("allStaff");
        String pathBasket = "/root/IdeaProjects/Marketplace/basket.txt";
        HashMap<String, ArrayList<String>> basket = new Reader(pathBasket).readBasket();
        String username = (String) session.getAttribute("username");
        ArrayList<String> inBasket = new ArrayList<String>();
        if(basket.get(username) != null) {
            ArrayList<String> inBasketOnlyName = basket.get(username);
            for(int i = 0; i < inBasketOnlyName.size(); i++) {
                Staff stf = new Staff("notFoundUser","notFoundUser","notFoundUser",0,0, "notFoundUser");
                String forAdd = inBasketOnlyName.get(i);
                for(int j = 0; j < staff.size(); j++) {
                    Staff tmpS = staff.get(j);
                    String tmp = tmpS.getName();
                    if(tmp.equals(forAdd)) {
                        stf = staff.get(j);
                        break;
                    }
                }
                inBasket.add(stf.toString());
            }
        }
        session.setAttribute("inBasket", inBasket);
    }

    private boolean checkUser(String username, String password) {
        String pass = allUsers.get(username);
        if(pass != null) {
            if (pass.equals(password)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean checkExist(String username) {
        if(allUsers.get(username) != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkExistEmail(String email) {
        for(Map.Entry<String, String> entry : allEmails.entrySet()) {
            if(entry.getValue().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
