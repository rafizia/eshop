package id.ac.ui.cs.advprog.eshop;

import id.ac.ui.cs.advprog.eshop.controller.ProductController;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EshopApplicationTests {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(productController).isNotNull();
        assertThat(productService).isNotNull();
    }

}
