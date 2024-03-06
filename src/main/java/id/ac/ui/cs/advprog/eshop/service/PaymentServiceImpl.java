package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = new Payment(order.getId(), method, paymentData);
        if (paymentRepository.findById(payment.getId()) == null) {
            paymentRepository.save(payment);
            return payment;
        }
        return null;
    }
    @Override
    public Payment setStatus(Payment payment2, String status) {
        Payment payment = paymentRepository.findById(payment2.getId());
        if (payment != null) {
            Payment newPayment = new Payment(payment.getId(), payment.getMethod(),
                    payment.getPaymentData(), status);
            paymentRepository.save(newPayment);
            return newPayment;
        } else {
            throw new NoSuchElementException();
        }
    }
    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
