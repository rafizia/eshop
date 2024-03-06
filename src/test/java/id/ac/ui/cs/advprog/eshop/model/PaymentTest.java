package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Map<String, String> paymentMap;
    @BeforeEach
    void setUp() {
        this.paymentMap = new HashMap<>();
        this.paymentMap.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreatePaymentEmptyOrder() {
        this.paymentMap.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                    "Cash on Delivery", this.paymentMap);
        });
    }

    @Test
    void testCreatePaymentDefaultStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Cash on Delivery", this.paymentMap);

        assertSame(this.paymentMap, payment.getPayment());
        assertEquals("13652556-012a-4c07-b546-54eb1396d79b", payment.getId());
        assertEquals("Cash on Delivery", payment.getMethod());
        assertEquals("ESHOP1234ABC5678", paymentMap.get("voucherCode"));
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Cash on Delivery", this.paymentMap, "SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                    "Cash on Delivery", this.paymentMap, "MEOW");
        });
    }

    @Test
    void testSetStatusToFailed() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Cash on Delivery", this.paymentMap);
        payment.setStatus("FAILED");
        assertEquals("FAILED", payment.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Cash on Delivery", this.paymentMap);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}
