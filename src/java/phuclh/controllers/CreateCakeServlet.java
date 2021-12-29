/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuclh.daos.CakeDAO;
import phuclh.daos.CategoryDAO;
import phuclh.dtos.CakeDTO;
import phuclh.dtos.CakeErrorDTO;
import phuclh.utils.HelpUtils;

/**
 *
 * @author Acer
 */
public class CreateCakeServlet extends HttpServlet {

    private static final String SUCCESS = "SearchCakeServlet";
    private static final String ERROR = "createNewCake.jsp";
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
        try {
            /* TODO output your page here. You may use following sample code. */
            String cakeName = request.getParameter("txtCakeName");
            String cakeImg = request.getParameter("txtCakeImg");
            String cakeDecription = request.getParameter("txtCakeDescription");
            String cakePrice = request.getParameter("txtCakePrice");
            Date cakeCreateDate = Date.valueOf(request.getParameter("txtCakeCreateDate"));
            Date cakeExprirationDate = Date.valueOf(request.getParameter("txtCakeExpirationDate"));
            String cakeCategory = request.getParameter("cbxCategoryCreate");
            String cakeQuantity = request.getParameter("txtCakeQuantity");
            String cakeStatus = request.getParameter("cbxCakeStatus");
            boolean check = false;
            
            CakeErrorDTO cakeError = new CakeErrorDTO();
            
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
            if (cakeCreateDate.after(cakeExprirationDate)) {
                check = true;
                cakeError.setCakeExpirationDateError("Expiration date is after create date");
            }
            
            if (check) {
                request.setAttribute("ERROR_CAKE", cakeError);
            } else {
                CategoryDAO cateDAO = new CategoryDAO();
                String cakeCategoryID = cateDAO.getCategoryID(cakeCategory);
                String cakeID = cateDAO.getCategoryID(cakeCategory) + HelpUtils.randomNumeric(2);
                boolean checkCategoryID = cateDAO.checkIDExist(cakeID);
                
                while (checkCategoryID) {
                    cakeID = HelpUtils.subStringCategoryID(cakeID);
                    checkCategoryID = cateDAO.checkIDExist(cakeID);
                }
                
                CakeDTO cakeDTO = new CakeDTO(cakeID, cakeName, cakeImg, cakeDecription, Float.parseFloat(cakePrice), cakeCreateDate, cakeExprirationDate, cakeCategoryID, Integer.parseInt(cakeQuantity), Boolean.parseBoolean(cakeStatus));
                CakeDAO cakeDAO = new CakeDAO();
                boolean result = cakeDAO.insertCake(cakeDTO);
                
                if (result) {
                    url = SUCCESS;
                }
            }
            
        } catch (Exception e){
            System.out.println("Error at CreateCakeSerlvet" + e.toString());
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
