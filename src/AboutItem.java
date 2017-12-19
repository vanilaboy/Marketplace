import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by root on 19.12.17 with love.
 */
@WebServlet("/aboutItem")
public class AboutItem extends HttpServlet {
    private ArrayList<Staff> staff = new ArrayList<Staff>();

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
        if(request.getParameter("itemName") != null) {
            String itemName = request.getParameter("itemName");
            for(int i = 0; i < staff.size(); i++) {
                if(staff.get(i).getName().equals(itemName)) {
                    request.setAttribute("aboutThisItem", staff.get(i).toString());
                    break;
                }
            }
            request.getRequestDispatcher("aboutItem.jsp").forward(request, response);
        } else {
            request.setAttribute("whatDo", "Something Went Wrong");
            request.getRequestDispatcher("somethingWrong.jsp").forward(request, response);
        }
    }
}
