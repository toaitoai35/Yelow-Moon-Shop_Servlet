package phuclh.dtos;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import phuclh.dtos.CakeDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class OrderDTO implements Serializable{
    
    private String orderID;
    private String userID;
    private String orderUserName;
    private String phone;
    private String address;
    private String orderPayment;
    private Date orderCreateDate;
    private boolean orderStatus;
    private float orderTotal;
    private List<CakeDTO> orderListCake;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, String orderUserName, String phone, String address, String orderPayment, Date orderCreateDate, boolean orderStatus, float orderTotal, List<CakeDTO> orderListCake) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderUserName = orderUserName;
        this.phone = phone;
        this.address = address;
        this.orderPayment = orderPayment;
        this.orderCreateDate = orderCreateDate;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.orderListCake = orderListCake;
    }

    public OrderDTO(String orderID, String userID, String orderUserName, String phone, String address, String orderPayment, Date orderCreateDate, boolean orderStatus, float orderTotal) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderUserName = orderUserName;
        this.phone = phone;
        this.address = address;
        this.orderPayment = orderPayment;
        this.orderCreateDate = orderCreateDate;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(String orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<CakeDTO> getOrderListCake() {
        return orderListCake;
    }

    public void setOrderListCake(List<CakeDTO> orderListCake) {
        this.orderListCake = orderListCake;
    }
}
