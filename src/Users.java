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
 * Created by root on 17.12.17 with love.
 */
@WebServlet("/reg")
public class Users extends HttpServlet {

    private HashMap<String, String> allUsers;
    private ArrayList<String> emails = new ArrayList<String>();

    public Users() {
        allUsers = new Reader().read();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("market.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String newEmail = request.getParameter("newEmail");
        if(newPassword != null && newUsername != null && newEmail != null) {
            if(!checkExistEmail(newEmail)) {
                if (!checkExist(newUsername)) {
                    allUsers.put(newUsername, newPassword);
                    Writer thread = new Writer(allUsers);
                    thread.start();
                    HttpSession session = request.getSession();
                    session.setAttribute("username", newUsername);
                    request.getRequestDispatcher("market.jsp").forward(request, response);
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
                    request.getRequestDispatcher("market.jsp").forward(request, response);
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
        for(int i = 0 ; i < emails.size(); i++) {
            if(email.equals(emails.get(i))) {
                return true;
            }
        }
        return false;
    }
}
