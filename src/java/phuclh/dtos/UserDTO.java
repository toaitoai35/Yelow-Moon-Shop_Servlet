/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.dtos;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class UserDTO implements Serializable{
    
    private String userid;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String userid, String username, String password, String address, String phoneNumber, String role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
