/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phuclh.daos.CakeDAO;
import phuclh.daos.UserDAO;
import phuclh.dtos.CakeDTO;
import phuclh.dtos.UserDTO;

/**
 *
 * @author Acer
 */
public class LoginServlet extends HttpServlet {

    private static final String ERROR = "loginpage.jsp";
    private static final String USER_PAGE = "home.jsp";
    private static final String ADMIN_PAGE = "adminpage.jsp";

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

        String url = ERROR;
        String msg = "";
        
        try {
            /* TODO output your page here. You may use following sample code. */
            String userID = request.getParameter("txtUserID").trim();
            String password = request.getParameter("txtPassword").trim();
            
            if (!userID.equals("") && !password.equals("")) {
                CakeDAO cakeDAO = new CakeDAO();
                UserDAO dao = new UserDAO();
                UserDTO dto = dao.checkLogin(userID, password);

                if (dto != null) {
                    if (dto.getRole().equals("Admin")) {
                        url = ADMIN_PAGE;
                    } else {
                        url = USER_PAGE;
                    }

                    cakeDAO.loadCake(dto.getRole());
                    List<CakeDTO> cakeList = cakeDAO.getCakeList();
                    request.setAttribute("CAKE_LIST", cakeList);
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN", dto);
                }
                else {
                    msg = "Your id and password is wrong! Try again";
                    request.setAttribute("LOGIN_ERROR", msg);
                }
            } else {
                msg = "Your id and password cant be blank";
                request.setAttribute("LOGIN_ERROR", msg);
            }

        } catch (Exception e) {
            System.out.println("Error at LoginServlet: " + e.toString());
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
