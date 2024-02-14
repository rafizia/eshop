package id.ac.ui.cs.advprog.eshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    private Product product = new Product();
    Product product2 = new Product();
    List<Product> allProduct = new ArrayList<>();

    @BeforeEach
    void setUp() {
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);


        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sanpo Cap Usep");
        product2.setProductQuantity(50);
        productService.create(product2);

        allProduct.add(product);
        allProduct.add(product2);

        Mockito.when(productService.getById(product.getProductId()))
                .thenReturn(product);
    }

    @Test
    public void testCreateProductController() throws Exception {
        given(productService.create(product)).willReturn(product);

        mockMvc.perform(post("/product/create")
                .param("productName", product.getProductName())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("list"));
    }

    @Test
    public void testGetCreateProductController() throws Exception {
        given(productService.create(product)).willReturn(product);
        mockMvc.perform(get("/product/create"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetListProductController() throws Exception {
        given(productService.findAll()).willReturn(allProduct);
        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProduct() throws Exception {
        given(productService.getById("eb558e9f-1c39-460e-8860-71af6af63bd6")).willReturn(product);
        mockMvc.perform(get("/product/home")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testEditProduct() throws Exception {
        given(productService.edit(product2, "eb558e9f-1c39-460e-8860-71af6af63bd6")).willReturn(product);
        mockMvc.perform(get("/product/edit/{id}", "eb558e9f-1c39-460e-8860-71af6af63bd6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testPostEditProduct() throws Exception {
        given(productService.edit(product2, "eb558e9f-1c39-460e-8860-71af6af63bd6")).willReturn(product);
        mockMvc.perform(post("/product/edit/{id}", "eb558e9f-1c39-460e-8860-71af6af63bd6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("/product/list"));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        given(productService.deleteById("eb558e9f-1c39-460e-8860-71af6af63bd6")).willReturn(true);
        mockMvc.perform(get("/product/delete/{id}", "eb558e9f-1c39-460e-8860-71af6af63bd6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("/product/list"));
    }
}
