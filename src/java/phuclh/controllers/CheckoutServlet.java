/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phuclh.daos.CakeDAO;
import phuclh.daos.OrderDAO;
import phuclh.daos.UserDAO;
import phuclh.dtos.CakeDTO;
import phuclh.dtos.CartDTO;
import phuclh.dtos.OrderDTO;
import phuclh.dtos.UserDTO;
import phuclh.utils.HelpUtils;

/**
 *
 * @author Acer
 */
public class CheckoutServlet extends HttpServlet {

    private static final String SUCCESS = "bill.jsp";
    private static final String ERROR = "cardDetail.jsp";

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
        String userID, userName, userPhone, userAddress;
        String errorMessage = null;
        boolean checkUserID = true;
        UserDTO addUser = null;
        try {
            /* TODO output your page here. You may use following sample code. */
            String total = request.getParameter("txtTotal");
            String orderID = HelpUtils.randomAlphaNumeric(5);
            Date orderCreateDate = new Date(System.currentTimeMillis());

            UserDAO userDAO = new UserDAO();
            HttpSession session = request.getSession();
            UserDTO userDTO = (UserDTO) session.getAttribute("LOGIN");
            CartDTO cartDTO = (CartDTO) session.getAttribute("CART");

            if (userDTO != null) {
                userID = userDTO.getUserid();
                userName = userDTO.getUsername();
                userPhone = userDTO.getPhoneNumber();
                userAddress = userDTO.getAddress();
            } else {
                userID = request.getParameter("txtPhone");
                userPhone = request.getParameter("txtPhone");
                userName = request.getParameter("txtName");
                userAddress = request.getParameter("txtAddress");
                String password = HelpUtils.randomNumeric(7);
                addUser = new UserDTO(userID, userName, password, userAddress, userPhone, "US");
            }

            OrderDTO orderDTO = new OrderDTO(orderID, userID, userName, userPhone, userAddress, "Cash", orderCreateDate, false, Float.parseFloat(total));
            Map<String, CakeDTO> items = cartDTO.getCart();
            CakeDAO cakeDAO = new CakeDAO();
            OrderDAO orderDAO = new OrderDAO();

            for (CakeDTO cakeDTO : items.values()) {
                int getQuantity = cakeDAO.getQuantity(cakeDTO.getCakeID());
                if (getQuantity < cakeDTO.getCakeQuantity()) {
                    errorMessage = "Quantity of " + cakeDTO.getCakeName() + " is too much, please choose quantity base on our's product quantity: " + getQuantity;
                }
                request.setAttribute("MESSAGE", errorMessage);
            }

            String msg = (String) request.getAttribute("MESSAGE");

            if (msg == null || msg.isEmpty()) {
                checkUserID = userDAO.checkUserID(userID);
                if (checkUserID == false) {
                    userDAO.insertUser(addUser);
                }
                boolean checkInsert = orderDAO.insertOrder(orderDTO);
                if (checkInsert) {
                    boolean checkOrder = orderDAO.insertOrderDetails(orderID, items);
                    if (checkOrder) {
                        for (CakeDTO cakeDTO : items.values()) {
                            int getQuantity = cakeDAO.getQuantity(cakeDTO.getCakeID());
                            boolean checkUpdate = cakeDAO.updateQuantity(getQuantity - cakeDTO.getCakeQuantity(), cakeDTO.getCakeID());
                            if (checkUpdate) {
                                if (checkUserID == false) {
                                    UserDTO userDetail = userDAO.getUser(userID);
                                    System.out.println(userDetail.getUserid() + userDetail.getPassword());
                                    request.setAttribute("USER_DETAIL", userDetail);
                                }
                                url = SUCCESS;
                                request.setAttribute("ORDERID", orderID);
                                session.removeAttribute("CART");
                            }
                        }
                    }
                }
            }

        } catch (NumberFormatException | SQLException | NamingException e) {
            System.out.println("Error at CheckoutServlet: " + e.toString());
//            e.printStackTrace();
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
