/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phuclh.daos.CakeDAO;
import phuclh.dtos.CakeDTO;
import phuclh.dtos.UserDTO;

/**
 *
 * @author Acer
 */
public class SearchCakeServlet extends HttpServlet {

    private static final String SEARCH_RESULT = "home.jsp";
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
        
        String url = SEARCH_RESULT;
        
        try {
            /* TODO output your page here. You may use following sample code. */
            String searchValue = request.getParameter("txtSearch").trim();
            String priceFrom = request.getParameter("txtPriceFrom").trim();
            String priceTo = request.getParameter("txtPriceTo").trim();
            String cbxCategory = request.getParameter("cbxCategory").trim();
            String role;
                    
            HttpSession session = request.getSession();
            UserDTO dto = (UserDTO) session.getAttribute("LOGIN");
            
            if (dto == null) {
                role = "";
            } else {
                role = dto.getRole();
            }
            
            if (!searchValue.equals("") && priceFrom.equals("") && priceTo.equals("") && cbxCategory.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByName(searchValue, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (!priceFrom.equals("") && !priceTo.equals("") && searchValue.equals("") && cbxCategory.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByPrice(priceFrom, priceTo, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (!cbxCategory.equals("") && priceFrom.equals("") && priceTo.equals("") && searchValue.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByCategory(cbxCategory, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (!cbxCategory.equals("") && !priceFrom.equals("") && !priceTo.equals("") && searchValue.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByCategoryAndPrice(cbxCategory, priceFrom, priceTo, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (!cbxCategory.equals("") && priceFrom.equals("") && priceTo.equals("") && !searchValue.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByCategoryAndName(cbxCategory, searchValue, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (cbxCategory.equals("") && !priceFrom.equals("") && !priceTo.equals("") && !searchValue.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByPriceAndName(priceFrom, priceTo, searchValue, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (!cbxCategory.equals("") && !priceFrom.equals("") && !priceTo.equals("") && !searchValue.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.searchCakeByCategoryAndPriceAndName(cbxCategory, priceFrom, priceTo, searchValue, role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
            if (cbxCategory.equals("") && priceFrom.equals("") && priceTo.equals("") && searchValue.equals("")) {
                CakeDAO dao = new CakeDAO();
                dao.loadCake(role);
                
                List<CakeDTO> cakeList = dao.getCakeList();
                request.setAttribute("CAKE_LIST", cakeList);
                
                if (role.equals("Admin")) {
                    url = ADMIN_PAGE;
                }
                if (role.equals("User") || role.equals("")) {
                    url = SEARCH_RESULT;
                }
            }
        
        } catch (Exception e) {
            System.out.println("Error at SearchCakeServlet:" + e.toString());
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
