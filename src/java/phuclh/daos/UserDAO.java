/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import phuclh.dtos.UserDTO;
import phuclh.utils.DBUtils;

/**
 *
 * @author Acer
 */
public class UserDAO implements Serializable{
    
    public UserDTO checkLogin (String userID, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UserDTO dto = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select userID, password, username, address, phoneNumber, roleName\n" +
                              "from tblUser u join tblRole r on u.roleID = r.roleID\n" +
                               "where userID = ? and password = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, password);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    String username = rs.getString("username");
                    String address = rs.getString("address");
                    String phoneNumber = rs.getString("phoneNumber");
                    String role = rs.getString("roleName");
                    
                    dto = new UserDTO(userID, username, password, address, phoneNumber, role);
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
        return dto;
    }
    
    public boolean checkUserID (String userID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select userID from tblUser where userID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    result = true;
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
       return result;
    }
    
    public boolean insertUser(UserDTO dto) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement pst = null;
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null){
                String sql = "insert tblUser(userID, password, username, address, phoneNumber, roleID) values(?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getUserid());
                pst.setString(2, dto.getPassword());
                pst.setString(3, dto.getUsername());
                pst.setString(4, dto.getAddress());
                pst.setString(5, dto.getPhoneNumber());
                pst.setString(6, dto.getRole());
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
    
    public UserDTO getUser (String userID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        UserDTO dto = null;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select userID, password, username, address, phoneNumber, roleName\n" +
                              "from tblUser u join tblRole r on u.roleID = r.roleID\n" +
                               "where userID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    String password = rs.getString("password");
                    String username = rs.getString("username");
                    String address = rs.getString("address");
                    String phoneNumber = rs.getString("phoneNumber");
                    String role = rs.getString("roleName");
                    
                    dto = new UserDTO(userID, username, password, address, phoneNumber, role);
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
        return dto;
    }
}
