package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
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
                    "Voucher Code", this.paymentMap);
        });
    }

    @Test
    void testCreatePaymentDefaultStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Voucher Code", this.paymentMap);

        assertSame(this.paymentMap, payment.getPaymentData());
        assertEquals("13652556-012a-4c07-b546-54eb1396d79b", payment.getId());
        assertEquals("Voucher Code", payment.getMethod());
        assertEquals("ESHOP1234ABC5678", paymentMap.get("voucherCode"));
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Voucher Code", this.paymentMap, "SUCCESS");
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                    "Voucher Code", this.paymentMap, "MEOW");
        });
    }

    @Test
    void testSetStatusToRejected() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Voucher Code", this.paymentMap);
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Voucher Code", this.paymentMap);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}
