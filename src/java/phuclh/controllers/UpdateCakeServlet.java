/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.controllers;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phuclh.daos.CakeDAO;
import phuclh.daos.CategoryDAO;
import phuclh.dtos.CakeDTO;
import phuclh.dtos.CakeErrorDTO;
import phuclh.dtos.UserDTO;

/**
 *
 * @author Acer
 */
public class UpdateCakeServlet extends HttpServlet {

    private static final String SUCCESS = "SearchCakeServlet";

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
        CakeErrorDTO cakeError = new CakeErrorDTO();
        HttpSession session = request.getSession();
        String url = SUCCESS;

        try {
            /* TODO output your page here. You may use following sample code. */
            String cakeID = request.getParameter("txtCakeID").trim();
            String cakeName = request.getParameter("txtCakeName").trim();
            String cakeImg = request.getParameter("txtCakeImg").trim();
            String cakeDescription = request.getParameter("txtCakeDescription").trim();
            String cakeCategory = request.getParameter("cbxCakeCategory").trim();
            String cakePrice = request.getParameter("txtCakePrice").trim();
            Date cakeCreateDate = Date.valueOf(request.getParameter("txtCakeCreateDate"));
            Date cakeExpirationDate = Date.valueOf(request.getParameter("txtCakeExpirationDate"));
            String cakeQuantity = request.getParameter("txtCakeQuantity").trim();
            String cakeStatus = request.getParameter("cbxCakeStatus").trim();
            UserDTO userDTO = (UserDTO) session.getAttribute("LOGIN");

            Date currentDate = new Date(System.currentTimeMillis());

            CakeDAO dao = new CakeDAO();
            boolean check = false;

            if (cakeName.isEmpty()) {
                check = true;
                cakeError.setCakeNameError("Name cant be blank");
            }
            if (cakePrice.isEmpty()) {
                check = true;
                cakeError.setCakePriceError("Price cant be blank");
            }
            if (cakeQuantity.isEmpty()) {
                check = true;
                cakeError.setCakeQuantityError("Quantity cant be blank");
            }
            if (cakeCreateDate.after(cakeExpirationDate)) {
                check = true;
                cakeError.setCakeExpirationDateError("Expiration date is after create date");
            }

            if (check) {
                request.setAttribute("ERROR_CAKE", cakeError);
            } else {
                CategoryDAO cateDAO = new CategoryDAO();
                String cakeCategoryID = cateDAO.getCategoryID(cakeCategory);

                if (cakeImg.equals("")) {
                    cakeImg = dao.getCakeImg(cakeID);
                }

                CakeDTO cakeDTO = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, Float.parseFloat(cakePrice), cakeCreateDate, cakeExpirationDate, cakeCategoryID, Integer.parseInt(cakeQuantity), Boolean.parseBoolean(cakeStatus), currentDate, userDTO.getUsername());
                boolean result = dao.updateCake(cakeDTO);

                if (result) {
                    url = SUCCESS;
                    cakeError.setCakeNameError("Update successfully");
                    request.setAttribute("ERROR_CAKE", cakeError);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at UpdateCakeServlet: " + e.toString());
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
