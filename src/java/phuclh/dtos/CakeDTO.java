/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Acer
 */
public class CakeDTO implements Serializable{
    
    private String cakeID;
    private String cakeName;
    private String cakeImg;
    private String cakeDescription;
    private float cakePrice;
    private Date cakeCreateDate;
    private Date cakeExpirationDate;
    private String cakeCategory;
    private int cakeQuantity;
    private boolean cakeStatus;
    private Date cakeLastUpdateDate;
    private String cakeLastUpdateUser;

    public CakeDTO() {
    }

    public CakeDTO(String cakeID, String cakeName, String cakeImg, float cakePrice, int cakeQuantity) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.cakeImg = cakeImg;
        this.cakePrice = cakePrice;
        this.cakeQuantity = cakeQuantity;
    }

    public CakeDTO(String cakeID, String cakeName, String cakeImg, String cakeDescription, float cakePrice, Date cakeCreateDate, Date cakeExpirationDate, String cakeCategory, int cakeQuantity, boolean cakeStatus, Date cakeLastUpdateDate, String cakeLastUpdateUser) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.cakeImg = cakeImg;
        this.cakeDescription = cakeDescription;
        this.cakePrice = cakePrice;
        this.cakeCreateDate = cakeCreateDate;
        this.cakeExpirationDate = cakeExpirationDate;
        this.cakeCategory = cakeCategory;
        this.cakeQuantity = cakeQuantity;
        this.cakeStatus = cakeStatus;
        this.cakeLastUpdateDate = cakeLastUpdateDate;
        this.cakeLastUpdateUser = cakeLastUpdateUser;
    }

    public CakeDTO(String cakeID, String cakeName, String cakeImg, String cakeDescription, float cakePrice, Date cakeCreateDate, Date cakeExpirationDate, String cakeCategory, int cakeQuantity) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.cakeImg = cakeImg;
        this.cakeDescription = cakeDescription;
        this.cakePrice = cakePrice;
        this.cakeCreateDate = cakeCreateDate;
        this.cakeExpirationDate = cakeExpirationDate;
        this.cakeCategory = cakeCategory;
        this.cakeQuantity = cakeQuantity;
    }

    public CakeDTO(String cakeID, String cakeName, String cakeImg, String cakeDescription, float cakePrice, Date cakeCreateDate, Date cakeExpirationDate, String cakeCategory, int cakeQuantity, boolean cakeStatus) {
        this.cakeID = cakeID;
        this.cakeName = cakeName;
        this.cakeImg = cakeImg;
        this.cakeDescription = cakeDescription;
        this.cakePrice = cakePrice;
        this.cakeCreateDate = cakeCreateDate;
        this.cakeExpirationDate = cakeExpirationDate;
        this.cakeCategory = cakeCategory;
        this.cakeQuantity = cakeQuantity;
        this.cakeStatus = cakeStatus;
    }

    public CakeDTO(String cakeImg, String cakeName, float cakePrice, int cakeQuantity) {
        this.cakeImg = cakeImg;
        this.cakeName = cakeName;
        this.cakePrice = cakePrice;
        this.cakeQuantity = cakeQuantity;
    }
    
    public String getCakeID() {
        return cakeID;
    }

    public void setCakeID(String cakeID) {
        this.cakeID = cakeID;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getCakeImg() {
        return cakeImg;
    }

    public void setCakeImg(String cakeImg) {
        this.cakeImg = cakeImg;
    }

    public String getCakeDescription() {
        return cakeDescription;
    }

    public void setCakeDesciption(String cakeDescription) {
        this.cakeDescription = cakeDescription;
    }

    public float getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(float cakePrice) {
        this.cakePrice = cakePrice;
    }

    public Date getCakeCreateDate() {
        return cakeCreateDate;
    }

    public void setCakeCreateDate(Date cakeCreateDate) {
        this.cakeCreateDate = cakeCreateDate;
    }

    public Date getCakeExpirationDate() {
        return cakeExpirationDate;
    }

    public void setCakeExpirationDate(Date cakeExpirationDate) {
        this.cakeExpirationDate = cakeExpirationDate;
    }

    public String getCakeCategory() {
        return cakeCategory;
    }

    public void setCakeCategory(String cakeCategory) {
        this.cakeCategory = cakeCategory;
    }

    public int getCakeQuantity() {
        return cakeQuantity;
    }

    public void setCakeQuantity(int cakeQuantity) {
        this.cakeQuantity = cakeQuantity;
    }

    public boolean isCakeStatus() {
        return cakeStatus;
    }

    public void setCakeStatus(boolean cakeStatus) {
        this.cakeStatus = cakeStatus;
    }

    public Date getCakeLastUpdateDate() {
        return cakeLastUpdateDate;
    }

    public void setCakeLastUpdateDate(Date cakeLastUpdateDate) {
        this.cakeLastUpdateDate = cakeLastUpdateDate;
    }

    public String getCakeLastUpdateUser() {
        return cakeLastUpdateUser;
    }

    public void setCakeLastUpdateUser(String cakeLastUpdateUser) {
        this.cakeLastUpdateUser = cakeLastUpdateUser;
    }
    
    
}
