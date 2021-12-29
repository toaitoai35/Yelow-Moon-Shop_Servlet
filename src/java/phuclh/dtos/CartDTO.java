/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Acer
 */
public class CartDTO implements Serializable {

    private Map<String, CakeDTO> cart;

    public CartDTO() {
    }

    public Map<String, CakeDTO> getCart() {
        return cart;
    }
    
    public void setCart(Map<String, CakeDTO> cart) {
        this.cart = cart;
    }
    
    public void add(CakeDTO dto) {
        if (this.cart == null){
            cart = new HashMap<>();
        }
        
        if (this.cart.containsKey(dto.getCakeID())){
            int quantity = cart.get(dto.getCakeID()).getCakeQuantity();
            dto.setCakeQuantity(quantity + 1);
        }
        
        cart.put(dto.getCakeID(), dto);
    }
    
    public void delete(String id) {
        if (this.cart == null) {
            return;
        }

        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(String id, CakeDTO dto) {
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.replace(id, dto);
            }
        }
    }
}
