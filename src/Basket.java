import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by root on 18.12.17 with love.
 */
@WebServlet("/basket")
public class Basket extends HttpServlet {
    private ArrayList<Staff> staff =  new ArrayList<Staff>();


    public Basket() {

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
                    break;
                }
            }
            inBasket.add(stf.toString());
            session.setAttribute("inBasket", inBasket);
        } else {
            request.getRequestDispatcher("basket.jsp").forward(request, response);
        }
    }
}
