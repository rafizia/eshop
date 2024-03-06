package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.Map;

@Getter @Setter
public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String,String> payment;

    public Payment(String id, String method, Map<String,String> payment) {
        this.id = id;
        this.method = method;
        this.status = "SUCCESS";

        if (payment.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.payment = payment;
        }
    }

    public Payment(String id, String method, Map<String,String> payment, String status) {
        this(id, method, payment);

        String[] statusList = {"SUCCESS", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }

    public void setStatus(String status) {
        String[] statusList = {"SUCCESS", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }
}
