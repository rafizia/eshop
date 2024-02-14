package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if (product.getProductId() == null)
            product.generateId();
        productData.add(product);
        return product;
    }

    public boolean deleteById(String id) {
        for (Product productDatum : productData) {
            if (productDatum.getProductId().equals(id)) {
                productData.remove(productDatum);
                return true;
            }
        }
        return false;
    }

    public Product edit(Product product, String id) {
        for (Product productDatum : productData) {
            if (productDatum.getProductId().equals(id)) {
                productDatum.setProductQuantity(product.getProductQuantity());
                productDatum.setProductName(product.getProductName());
            }
        }
        return product;
    }

    public Product getById(String id) {
        for (Product productDatum : productData) {
            if (productDatum.getProductId().equals(id)) {
                return productDatum;
            }
        }
        return null;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}