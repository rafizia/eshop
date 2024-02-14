package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sanpo Cap Usep");
        product2.setProductQuantity(50);
        productService.create(product2);

        List<Product> allProduct = new ArrayList<>();
        allProduct.add(product);
        allProduct.add(product2);

        when(productRepository.getById(product.getProductId()))
                .thenReturn(product);

        when(productRepository.deleteById(product.getProductId()))
                .thenReturn(true);

        when(productRepository.edit(product2, "eb558e9f-1c39-460e-8860-71af6af63bd6"))
                .thenReturn(product2);

        when(productRepository.findAll())
                .thenReturn(allProduct.iterator());
    }

    @Test
    public void testCreateProduct() {
        Product product2 = new Product();
        product2.setProductId("eb558e9f-1c39-460e-8860");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(60);

        assertThat(product2).isNotNull();
    }

    @Test
    public void testGetProduct() {
        String name = "eb558e9f-1c39-460e-8860-71af6af63bd6";
        Product found = productService.getById(name);

        assertThat(found.getProductId())
                .isEqualTo(name);
    }

    @Test
    public void testEditProduct() {
        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sanpo Cap Usep");
        product2.setProductQuantity(50);

        Product result = productService.edit(product2, "eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertThat(result.getProductName()).isEqualTo("Sanpo Cap Usep");
        assertThat(result.getProductQuantity() == 50);
    }

    @Test
    public void testProductFindAll() {
        productRepository.findAll();
        List<Product> allProduct = productService.findAll();
        assertThat(allProduct.get(0).getProductName()).isEqualTo("Sampo Cap Bambang");
        assertThat(allProduct.get(0).getProductQuantity() == 100);
        assertThat(allProduct.get(1).getProductName()).isEqualTo("Sanpo Cap Usep");
        assertThat(allProduct.get(1).getProductQuantity() == 50);
    }

    @Test
    public void testDeleteProduct() {
        boolean result = productService.deleteById("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertTrue(result);
    }
}
