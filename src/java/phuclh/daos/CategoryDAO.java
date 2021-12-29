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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phuclh.dtos.CategoryDTO;
import phuclh.utils.DBUtils;

/**
 *
 * @author Acer
 */
public class CategoryDAO implements Serializable {

    private List<CategoryDTO> categoryList;

    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public void loadCategory() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "select categoryID, categoryName from tblCategory";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    CategoryDTO dto = new CategoryDTO(categoryID, categoryName);

                    if (this.categoryList == null) {
                        this.categoryList = new ArrayList<>();
                    }
                    this.categoryList.add(dto);
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
    }

    public String getCategoryID(String categoryName) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "select categoryID from tblCategory where categoryName = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, categoryName);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    String cakeCategoryID = rs.getString("categoryID");
                    return cakeCategoryID;
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
        return null;
    }
    
    public boolean checkIDExist(String categoryID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "select categoryID from tblCategory where categoryID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, categoryID);
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
}
