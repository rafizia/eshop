package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private static int Id;
    private int productId;
    private String productName;
    private int productQuantity;

    public void SetId(){
        this.productId = ++Id;
    }
}