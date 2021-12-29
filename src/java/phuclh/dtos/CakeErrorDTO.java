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
public class CakeErrorDTO implements Serializable{
    
    private String cakeNameError;
    private String cakeDescriptionError;
    private String cakePriceError;
    private String cakeCreateDateError;
    private String cakeExpirationDateError;
    private String cakeQuantityError;

    public CakeErrorDTO() {
    }

    public CakeErrorDTO(String cakeNameError, String cakeDescriptionError, String cakePriceError, String cakeCreateDateError, String cakeExpirationDateError, String cakeQuantityError) {
        this.cakeNameError = cakeNameError;
        this.cakeDescriptionError = cakeDescriptionError;
        this.cakePriceError = cakePriceError;
        this.cakeCreateDateError = cakeCreateDateError;
        this.cakeExpirationDateError = cakeExpirationDateError;
        this.cakeQuantityError = cakeQuantityError;
    }

    public String getCakeNameError() {
        return cakeNameError;
    }

    public void setCakeNameError(String cakeNameError) {
        this.cakeNameError = cakeNameError;
    }

    public String getCakeDescriptionError() {
        return cakeDescriptionError;
    }

    public void setCakeDescriptionError(String cakeDescriptionError) {
        this.cakeDescriptionError = cakeDescriptionError;
    }

    public String getCakePriceError() {
        return cakePriceError;
    }

    public void setCakePriceError(String cakePriceError) {
        this.cakePriceError = cakePriceError;
    }

    public String getCakeCreateDateError() {
        return cakeCreateDateError;
    }

    public void setCakeCreateDateError(String cakeCreateDateError) {
        this.cakeCreateDateError = cakeCreateDateError;
    }

    public String getCakeExpirationDateError() {
        return cakeExpirationDateError;
    }

    public void setCakeExpirationDateError(String cakeExpirationDateError) {
        this.cakeExpirationDateError = cakeExpirationDateError;
    }

    public String getCakeQuantityError() {
        return cakeQuantityError;
    }

    public void setCakeQuantityError(String cakeQuantityError) {
        this.cakeQuantityError = cakeQuantityError;
    }
}
