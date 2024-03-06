package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    List<Payment> payments;
    List<Order> orders;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product productl = new Product();
        productl.setProductId("eb558e9f-1c39-460e-8860-71afbaf63bd6");
        productl.setProductName("Sampo Cap Bambang");
        productl.setProductQuantity(2);
        products.add(productl);

        orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078",
                products, 1708570000L, "Safira Sudrajat");
        orders.add(order2);

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
    void testCreatePayment() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.addPayment(orders.get(1), "Cash On Delivery", payments.get(1).getPayment());
        verify(paymentRepository, times(1)).save(payment);
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testCreatePaymentIfAlreadyExists() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertNull(paymentService.addPayment(orders.get(1), "Cash On Delivery", payments.get(1).getPayment()));
        verify(paymentRepository, times(0)).save(payment);
    }

    @Test
    void testUpdateStatus() {
        Payment payment = payments.get(1);
        Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getPayment(),
                PaymentStatus.SUCCESS.getValue());
        doReturn(payment).when (paymentRepository).findById(payment.getId());
        doReturn(newPayment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.setStatus(payment, PaymentStatus.SUCCESS.getValue());

        assertEquals(payment.getId(), result.getId());
        assertEquals (PaymentStatus.SUCCESS.getValue(), result.getStatus());
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testUpdateStatusInvalidStatus() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertThrows(IllegalArgumentException. class,
                () -> paymentService.setStatus(payment,"MEOW"));

        verify(paymentRepository, times( 0)).save(any(Payment.class));
    }

    @Test
    void testFindByIdIfIdFound() {
        Payment payment = payments.get(1);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Payment result = paymentService.getPayment(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        doReturn(null).when(paymentRepository).findById("zczc");
        assertNull(paymentService.getPayment("zczc"));
    }

    @Test
    void testGetAllPayments() {
        Payment payment = payments.get(1);
        doReturn(payments).when(paymentRepository).findAll();
        List<Payment> results = paymentService.getAllPayments();
        for (Payment result : results) {
            assertEquals(payment.getId(), result.getId());
        }
        assertEquals(4, results.size());
    }
}
