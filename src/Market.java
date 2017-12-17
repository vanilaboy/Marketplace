import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by root on 16.12.17 with love.
 */
@WebServlet("/market")
public class Market extends HttpServlet {

    private ArrayList<Staff> staff = new ArrayList<Staff>();

    public Market() {
        collectStaff("/root/IdeaProjects/Marketplace/staff");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<String> cards = new ArrayList<String>();
        for(int i = 0; i < staff.size(); i++) {
            Staff currentStaff = staff.get(i);
            BufferedReader in = new BufferedReader(new FileReader(new File("/root/IdeaProjects/Marketplace/web/card.html")));
            StringBuilder cardString = new StringBuilder();
            cardString.append("<li id=\"item" + i + "\">");
            boolean sale = false;
            String tmp = in.readLine();
            while(tmp != null) {
                if((tmp.contains("div class=\"product-item\"")) && currentStaff.getNewCost() != 0) {
                    tmp = tmp.replace("div class=\"product-item\"", "div class=\"product-item-sale\"");
                    sale = true;
                }
                if(tmp.contains("imageimageimage")) {
                    tmp = tmp.replace("imageimageimage", currentStaff.getPathToImage());
                }
                if(tmp.contains("headheadhead")) {
                    tmp = tmp.replace("headheadhead", currentStaff.getName());
                }
                if(tmp.contains("pricepriceprice")) {
                    if(currentStaff.getNewCost() != 0) {
                        tmp = tmp.replaceAll("pricepriceprice", "<strike>" + Double.toString(currentStaff.getCost()) + "</strike>");
                    } else {
                        tmp = tmp.replaceAll("pricepriceprice", Double.toString(currentStaff.getCost()));
                    }
                }
                if(tmp.contains("lowlowlow")) {
                    if(currentStaff.getNewCost() == 0) {
                        tmp = tmp.replaceAll("lowlowlow", "");
                    } else {
                        tmp = tmp.replaceAll("lowlowlow", Double.toString(currentStaff.getNewCost()));
                    }
                }
                cardString.append(tmp);
                tmp = in.readLine();

            }
            if(sale) {
                cardString.append("</li><div class=\"plusWidthSale\"></div>");
            } else {
                cardString.append("</li><div class=\"plusWidth\"></div>");
            }
            cards.add(cardString.toString());
        }
        session.setAttribute("cards", cards);
        request.getRequestDispatcher("market.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    private void collectStaff(String pathToFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(pathToFile)));
            String str = in.readLine();
            String name = null;
            String pathToImage = null;
            String about = null;
            String shortAbout = null;
            double cost = 0;
            double newCost;
            while(str != null) {
                if(str.contains("##########")) {
                    name = str.replaceAll("##########", "");
                } else {
                    if(str.contains("#########%")) {
                        pathToImage = str.replaceAll("#########%", "");
                    } else {
                        if(str.contains("########%%")) {
                            about = str.replaceAll("########%%", "");
                        } else {
                            if(str.contains("#######%%%")) {
                                shortAbout = str.replaceAll("#######%%%", "");
                            }
                            else {
                                if(str.contains("######%%%%")) {
                                    String strCost = str.replaceAll("######%%%%", "");
                                    cost = Double.parseDouble(strCost);
                                } else {
                                    if(str.contains("#####%%%%%")) {
                                        String strNewCost = str.replaceAll("#####%%%%%", "");
                                        newCost = Double.parseDouble(strNewCost);
                                        staff.add(new Staff(name, pathToImage, about, cost, newCost, shortAbout));
                                    }
                                }
                            }
                        }
                    }
                }
                str = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}