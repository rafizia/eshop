package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product edit(Product product, String id);
    Product getById(String id);
    List<Product> findAll();
    boolean deleteById(String id);
}