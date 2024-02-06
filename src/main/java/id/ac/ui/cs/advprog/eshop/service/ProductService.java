package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public Product edit(Product product, int id);
    public Product getById(int id);
    public List<Product> findAll();
    public void deleteById(int id);
}