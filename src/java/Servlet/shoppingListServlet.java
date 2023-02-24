/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

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
 * @author dhruv
 */
public class shoppingListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet shoppingListServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet shoppingListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");


        if (action.equals("register")) {
            String nome_usuario = request.getParameter("username");
            if (nome_usuario.equals("")) {
                String message = "Empty username";
                request.setAttribute("empty_username", message);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                        .forward(request, response);
                return;
            } 
        } else if (action.equals("add")) {
            String get_item = request.getParameter("item");

            if (!get_item.equals("")) {
                ArrayList<String> list_items = (ArrayList<String>) session.getAttribute("items");
                Object items = null;

                if (items == null) {
                    items = new ArrayList<>();
                }

                list_items.add(get_item);
                session.setAttribute("items", items);

                ArrayList<String> list_page = (ArrayList<String>) session.getAttribute("list_page");
                if (list_page == null) {
                    list_page = new ArrayList<>();
                }

              

            }
        } else if (action.equals("delete")) {
            String selected_item = request.getParameter("item");
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");
            ArrayList<String> list_items = (ArrayList<String>) session.getAttribute("items");
            list_items.remove(selected_item);
            session.setAttribute("items", list_items);
            ArrayList<String> items = null;

            list = popArrayList(items, list);
            session.setAttribute("list", list);

        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ArrayList<String> popArrayList(ArrayList<String> list_items, ArrayList<String> list_page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
