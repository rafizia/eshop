package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot. test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("dsds");
        product.setProductName("Sanpo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAULIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("ds");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("d");
        product2.setProductName("Sanpo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    public void testEditProduct() {
        Product product = new Product();
        product.setProductId("ds");
        product.setProductName("Sanpo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product product2 = new Product();
        product2.setProductId("d");
        product2.setProductName("Sanpo Cap Usep");
        product2.setProductQuantity(50);

        productRepository.edit(product2, "d");
        assertEquals("Sanpo Cap Usep", productRepository.getById("d").getProductName());
        assertEquals(50, productRepository.getById("dd").getProductQuantity());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("d");
        product.setProductName("Sanpo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        productRepository.deleteById("d");
        assertNull(productRepository.getById("d"));
    }
}