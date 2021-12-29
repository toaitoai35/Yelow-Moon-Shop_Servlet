/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "index.html";
    private static final String LOGIN = "LoginServlet";
    private static final String LOGOUT = "LogoutServlet";
    private static final String SEARCH_CAKE_SERVLET = "SearchCakeServlet";
    private static final String UPDATE_CAKE_SERVLET = "UpdateCakeServlet";
    private static final String CREATE_CAKE_SERVLET = "CreateCakeServlet";
//    private static final String CREATE_CAKE_PAGE = "createNewCake.jsp";
    private static final String SEARCH_ORDER_SERVLET = "SearchOrderServlet";
    private static final String ADD_CAKE_TO_CART = "BuyCakeServlet";
    private static final String VIEW = "cardDetail.jsp";
    private static final String DELETE_ORDER_SERVLET = "DeleteOrderServlet";
    private static final String UPDATE_ORDER_SERVLET = "UpdateOrderServlet";
    private static final String CHECKOUT_SERVLET = "CheckoutServlet";
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
        
        String btn = request.getParameter("btnAction");
        String url = ERROR;
        
        try {
            /* TODO output your page here. You may use following sample code. */
            if (btn.equals("Login")) {
                url = LOGIN;
            }
            if (btn.equals("Logout")) {
                url = LOGOUT;
            }
            if (btn.equals("Search")) {
                url = SEARCH_CAKE_SERVLET;
            }
            if (btn.equals("Update")) {
                url = UPDATE_CAKE_SERVLET;
            }
//            if (btn.equals("Create New Cake")) {
//                url = CREATE_CAKE_PAGE;
//            }
            if (btn.equals("Create")) {
                url = CREATE_CAKE_SERVLET;
            }
            if (btn.equals("SearchOrder")) {
                url = SEARCH_ORDER_SERVLET;
            }
            if (btn.equals("Add to Cart")) {
                url = ADD_CAKE_TO_CART;
            }
            if (btn.equals("View")) {
                url = VIEW;
            }
            if (btn.equals("Delete Order")) {
                url = DELETE_ORDER_SERVLET;
            }
            if (btn.equals("Update Order")) {
                url = UPDATE_ORDER_SERVLET;
            }
            if (btn.equals("Checkout")) {
                url = CHECKOUT_SERVLET;
            }
            if (btn.equals("Checkout")) {
                url = CHECKOUT_SERVLET;
            }
        } catch (Exception e){
            System.out.println("Error at MC:" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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

}
