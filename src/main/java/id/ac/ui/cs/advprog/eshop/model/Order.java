package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter @Setter
public class Order {
    private String id;
    private List<Product> products;
    private Long orderTime;
    private String author;
    private String status = "WAITING_PAYMENT";

    public Order(String id, List<Product> products, long orderTime, String safiraSudrajat) {
    }

    public Order(String id, List<Product> products, long orderTime, String safiraSudrajat, String status) {
    }
}
