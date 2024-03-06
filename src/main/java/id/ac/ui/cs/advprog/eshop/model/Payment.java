package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter @Setter
public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String,String> paymentData;

    public Payment(String id, String method, Map<String,String> paymentData) {
        this.id = id;
        this.method = method;
        this.status = PaymentStatus.SUCCESS.getValue();

        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, String method, Map<String,String> paymentData, String status) {
        this(id, method, paymentData);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
