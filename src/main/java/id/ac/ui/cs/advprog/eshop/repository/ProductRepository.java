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
        product.SetId();
        productData.add(product);
        return product;
    }

    public Product edit(Product product, int id) {
        for (Product productDatum : productData) {
            if (productDatum.getProductId() == id) {
                productDatum.setProductQuantity(product.getProductQuantity());
                productDatum.setProductName(product.getProductName());
            }
        }
        return product;
    }

    public Product getById(int id) {
        for (Product productDatum : productData) {
            if (productDatum.getProductId() == id) {
                return productDatum;
            }
        }
        return null;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}