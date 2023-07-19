package com.sourav.publisher;

import com.sourav.PaymentService;
import com.sourav.dto.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

    @Autowired
    private PaymentService service;

    @PostMapping("/publish")
    public String publish(@RequestBody Payment payment) {
        return service.publish(payment);
    }
}
