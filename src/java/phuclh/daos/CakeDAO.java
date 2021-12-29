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
import javax.naming.NamingException;
import phuclh.dtos.CakeDTO;
import phuclh.utils.DBUtils;

/**
 *
 * @author Acer
 */
public class CakeDAO implements Serializable {

    private List<CakeDTO> cakeList;

    public List<CakeDTO> getCakeList() {
        return cakeList;
    }

    public void searchCakeByName(String searchValue, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cakeName like ? and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cakeName like ?\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + searchValue + "%");
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void searchCakeByPrice(String priceFrom, String priceTo, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where (cakePrice between ? and ?) and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where (cakePrice between ? and ?)\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setFloat(1, Float.parseFloat(priceFrom));
                pst.setFloat(2, Float.parseFloat(priceTo));
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void searchCakeByCategory(String cbxCategory, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ?\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setString(1, cbxCategory);
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void searchCakeByCategoryAndPrice(String cbxCategory, String priceFrom, String priceTo, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and (cakePrice between ? and ?) and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and (cakePrice between ? and ?)\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setString(1, cbxCategory);
                pst.setFloat(2, Float.parseFloat(priceFrom));
                pst.setFloat(3, Float.parseFloat(priceTo));
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void searchCakeByCategoryAndName(String cbxCategory, String searchValue, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and cakeName like ? and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and cakeName like ?\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setString(1, cbxCategory);
                pst.setString(2, "%" + searchValue + "%");
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void searchCakeByPriceAndName(String priceFrom, String priceTo, String searchValue, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where (cakePrice between ? and ?) and cakeName like ? and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where (cakePrice between ? and ?) and cakeName like ?\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setFloat(1, Float.parseFloat(priceFrom));
                pst.setFloat(2, Float.parseFloat(priceTo));
                pst.setString(3, "%" + searchValue + "%");
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void searchCakeByCategoryAndPriceAndName(String cbxCategory, String priceFrom, String priceTo, String searchValue, String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and (cakePrice between ? and ?) and cakeName like ? and cakeStatus = 1 and cakeQuantity > 0";
                }
                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cate.categoryName = ? and (cakePrice between ? and ?) and cakeName like ?\n"
                            + "order by cakeCreateDate";
                }

                pst = con.prepareStatement(sql);
                pst.setString(1, cbxCategory);
                pst.setFloat(2, Float.parseFloat(priceFrom));
                pst.setFloat(3, Float.parseFloat(priceTo));
                pst.setString(4, "%" + searchValue + "%");
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public void loadCake(String role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "";

                if (role.equals("Admin")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "order by cakeCreateDate";
                }
                if (role.equals("User") || role.equals("")) {
                    sql = "select cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeQuantity, categoryName, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser\n"
                            + "from tblCake cake join tblCategory cate on cake.cakeCategoryID = cate.categoryID\n"
                            + "where cakeStatus = 1 and cakeQuantity > 0";
                }

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    String cakeID = rs.getString("cakeID");
                    String cakeName = rs.getString("cakeName");
                    String cakeImg = rs.getString("cakeImg");
                    String cakeDescription = rs.getString("cakeDescription");
                    float cakePrice = rs.getFloat("cakePrice");
                    Date cakeCreateDate = rs.getDate("cakeCreateDate");
                    Date cakeExpirationDate = rs.getDate("cakeExpirationDate");
                    int cakeQuantity = rs.getInt("cakeQuantity");
                    String cakeCategory = rs.getString("categoryName");
                    Date cakeLastUpdateDate = rs.getDate("cakeLastUpdateDate");
                    String cakeLastUpdateUser = rs.getString("cakeLastUpdateUser");
                    boolean cakeStatus = rs.getBoolean("cakeStatus");

                    CakeDTO dto = new CakeDTO(cakeID, cakeName, cakeImg, cakeDescription, cakePrice, cakeCreateDate, cakeExpirationDate, cakeCategory, cakeQuantity, cakeStatus, cakeLastUpdateDate, cakeLastUpdateUser);
                    if (this.cakeList == null) {
                        this.cakeList = new ArrayList<>();
                    }
                    this.cakeList.add(dto);
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

    public boolean updateCake(CakeDTO cakeDTO) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "update tblCake set cakeName = ?, cakeImg = ?, cakeDescription = ?, cakePrice = ?, cakeCreateDate = ?, "
                        + "cakeExpirationDate = ?, cakeCategoryID = ?, cakeQuantity = ?, cakeStatus = ?, cakeLastUpdateDate = ?, cakeLastUpdateUser = ? where cakeID = ?";
//                String sql = "update tblCake set cakeLastUpdateUser = ? where cakeID = ?";

                pst = con.prepareStatement(sql);
                pst.setString(1, cakeDTO.getCakeName());
                pst.setString(2, cakeDTO.getCakeImg());
                pst.setString(3, cakeDTO.getCakeDescription());
                pst.setFloat(4, cakeDTO.getCakePrice());
                pst.setDate(5, cakeDTO.getCakeCreateDate());
                pst.setDate(6, cakeDTO.getCakeExpirationDate());
                pst.setString(7, cakeDTO.getCakeCategory());
                pst.setInt(8, cakeDTO.getCakeQuantity());
                pst.setBoolean(9, cakeDTO.isCakeStatus());
                pst.setDate(10, cakeDTO.getCakeLastUpdateDate());
                pst.setString(11, cakeDTO.getCakeLastUpdateUser());
                pst.setString(12, cakeDTO.getCakeID());
                int row = pst.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean insertCake(CakeDTO cakeDTO) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "insert tblCake(cakeID,cakeName,cakeImg,cakeDescription,cakePrice,cakeCreateDate,cakeExpirationDate,cakeCategoryID,cakeQuantity,cakeStatus) values(?,?,?,?,?,?,?,?,?,?)";

                pst = con.prepareStatement(sql);
                pst.setString(2, cakeDTO.getCakeName());
                pst.setString(3, cakeDTO.getCakeImg());
                pst.setString(4, cakeDTO.getCakeDescription());
                pst.setFloat(5, cakeDTO.getCakePrice());
                pst.setDate(6, cakeDTO.getCakeCreateDate());
                pst.setDate(7, cakeDTO.getCakeExpirationDate());
                pst.setString(8, cakeDTO.getCakeCategory());
                pst.setInt(9, cakeDTO.getCakeQuantity());
                pst.setBoolean(10, cakeDTO.isCakeStatus());
                pst.setString(1, cakeDTO.getCakeID());
                int row = pst.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public int getQuantity(String cakeID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int quantity = -1;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select cakeQuantity from tblCake where cakeID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, cakeID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("cakeQuantity");
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return quantity;
    }

    public boolean updateQuantity(int quantity, String cakeID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "update tblCake set cakeQuantity = ? where cakeID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, quantity);
                pst.setString(2, cakeID);
                int row = pst.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public String getCakeImg(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String cakeImg = "";
        
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "select cakeImg\n"
                        + "from tblCake\n"
                        + "where cakeID = ?";

                pst = con.prepareStatement(sql);
                pst.setString(1, searchValue);
                rs = pst.executeQuery();

                if (rs.next()) {
                    cakeImg = rs.getString("cakeImg");
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
        return cakeImg;
    }
}
