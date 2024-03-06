package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();

        Map<String, String> paymentMap1 = new HashMap<>();
        paymentMap1.put("voucherCode", "ESHOP1234ABC5678");

        Map<String, String> paymentMap2 = new HashMap<>();
        paymentMap2.put("address", "Depok");
        paymentMap2.put("deliveryFee", "10000");

        Map<String, String> paymentMap3 = new HashMap<>();
        paymentMap3.put("bankName", "BNI");
        paymentMap3.put("referenceCode", "123459273748");

        Map<String, String> paymentMap4 = new HashMap<>();
        paymentMap4.put("voucherCode", "ESHOP1234ABC9999");

        payments = new ArrayList<>();

        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Voucher Code", paymentMap1);
        payments.add(payment1);
        Payment payment2 = new Payment("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                "Cash On Delivery", paymentMap2);
        payments.add(payment2);
        Payment payment3 = new Payment("e334ef40-9eff-4da8-9487-8eeb97ecbfle",
                "Payment by Bank Transfer", paymentMap3);
        payments.add(payment3);
        Payment payment4 = new Payment("e334ef40-9eff-4da8-9487-83rehr83r3h8",
                "Voucher Code", paymentMap4);
        payments.add(payment4);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.get(1);
        Payment result = paymentRepository.save(payment);
        Payment findResult = paymentRepository.findById(payments.get(1).getId());

        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
    }

    @Test
    void testSaveUpdate() {
        Payment payment = payments.get(1);
        paymentRepository.save(payment);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getPayment(),
                PaymentStatus.SUCCESS.getValue());
        Payment result = paymentRepository.save(newPayment);

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById(payments.get(1).getId());
        assertEquals(payments.get(1).getId(), findResult.getId());
        assertEquals(payments.get(1).getMethod(), findResult.getMethod());
        assertEquals(payments.get(1).getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test
    void testFindAllByMethodIfMethodCorrect() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }
        List<Payment> paymentList = paymentRepository.findAllByMethod(
                payments.get(0).getMethod());
        assertEquals(2, paymentList.size());
    }

    @Test
    void testFindAllByMethodIfAllLowercase() {
        paymentRepository.save(payments.get(1));
        List<Payment> paymentList = paymentRepository.findAllByMethod(
                payments.get(1).getMethod().toLowerCase());
        assertTrue(paymentList.isEmpty());
    }
}
