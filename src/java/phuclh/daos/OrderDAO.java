/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import phuclh.dtos.CakeDTO;
import phuclh.dtos.OrderDTO;
import phuclh.utils.DBUtils;

/**
 *
 * @author Acer
 */
public class OrderDAO implements Serializable {

    public OrderDTO getOrder(String searchValue, String userID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<CakeDTO> cakeList = new ArrayList<>();
        OrderDTO orderDTO = null;
                
        try {
            con = DBUtils.getConnection();
            
            if (con != null) {
                String sql = "select orderTotalPrice, orderUserName, orderNumberPhone, orderAddress, orderCreateDate, orderStatus, orderPayment, cakeName, cakeImg, quantity, price\n" +
                                "from tblOrder ord join tblOrderDetail detail on ord.orderID = detail.orderID join tblCake cake on detail.cakeID = cake.cakeID\n" +
                                "where ord.orderID = ? and ord.userID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, searchValue);
                pst.setString(2, userID);
                rs = pst.executeQuery();
                
                while (rs.next()) {
                    float orderTotalPrice = rs.getFloat("orderTotalPrice");
                    String orderUserName = rs.getString("orderUserName");
                    String orderNumberPhone = rs.getString("orderNumberPhone");
                    String orderAddress = rs.getString("orderAddress");
                    Date orderCreateDate = rs.getDate("orderCreateDate");
                    boolean orderStatus = rs.getBoolean("orderStatus");
                    String orderPayment = rs.getString("orderPayment");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    
                    CakeDTO cakeDTO = new CakeDTO(cakeImg, cakeName, price, quantity);
                    cakeList.add(cakeDTO);
                    
                    orderDTO = new OrderDTO(searchValue, userID, orderUserName, orderNumberPhone, orderAddress, orderPayment, orderCreateDate, orderStatus, orderTotalPrice, cakeList);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return orderDTO;
    }
    
    public boolean insertOrder(OrderDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "insert tblOrder(OrderID, orderTotalPrice, orderUserName, orderNumberPhone, orderAddress, userID, orderCreateDate, orderStatus, orderPayment) values(?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getOrderID());
                pst.setFloat(2, dto.getOrderTotal());
                pst.setString(3, dto.getOrderUserName());
                pst.setString(4, dto.getPhone());
                pst.setString(5, dto.getAddress());
                pst.setString(6, dto.getUserID());
                pst.setDate(7, dto.getOrderCreateDate());
                pst.setBoolean(8, dto.isOrderStatus());
                pst.setString(9, dto.getOrderPayment());
                int row = pst.executeUpdate();
                if (row > 0){
                    result = true;
                }
            }
        } finally {
            
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
    
    public boolean insertOrderDetails(String id, Map<String, CakeDTO> cart) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null){
                int row = 0;
                String sql = "insert tblOrderDetail(OrderID, cakeID, quantity, price) values(?,?,?,?)";
                for (String items : cart.keySet()) {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, id);
                    pst.setString(2, items);
                    pst.setInt(3, cart.get(items).getCakeQuantity());
                    pst.setDouble(4, cart.get(items).getCakePrice());
                    row = pst.executeUpdate();
                }
                if (row > 0){
                    result = true;
                }
            }
        } finally {
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        }
        return result;
    }
}
