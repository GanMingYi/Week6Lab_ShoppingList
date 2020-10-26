package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ming
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String action = (String)request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        }
        
        String username = (String)session.getAttribute("username");
        
        if (username == null || username.isEmpty()) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        ArrayList<String> shoppingList = (ArrayList)session.getAttribute("shoppingList");
        if (shoppingList == null) {
            shoppingList = new ArrayList<>();
        }
        
        switch (action) {
            case "register":
                String username = request.getParameter("username");
                if (username == "" || username == null) {
                    request.setAttribute("username", username);
                    request.setAttribute("message", "Enter a valid name");

                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    break;
                }
                else {
                    session.setAttribute("username", username);
                    break;
//                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
                 
                
            case "add":
                String item = request.getParameter("item");
                if (!item.isEmpty()) {
                    shoppingList.add(item);
                    session.setAttribute("shoppingList", shoppingList);
                    session.setAttribute("message", "");
                    break;
//                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                } else {
                    session.setAttribute("message", "Enter a valid item");
                    break;
//                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
                
            case "delete":
                try {
                String deleteItem = request.getParameter("items");
                if (!deleteItem.isEmpty()) {
                    shoppingList.remove(deleteItem);
                    session.setAttribute("message", "");
//                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break;
                }
                else {
                    session.setAttribute("message", "Nothing to delete");
                    break;
                }
                    }
                catch (Exception e){
                    session.setAttribute("message", "Nothing to delete");
                    break;
                }
        }
        
//        session.setAttribute("shoppingList", shoppingList);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
