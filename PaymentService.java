package com.payment.service;

import com.payment.model.Payment;
import com.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    private static final String TOPIC = "payment_topic";

    public Payment processPayment(Payment payment) {
        payment.setStatus("PENDING");
        Payment savedPayment = paymentRepository.save(payment);
        
        kafkaTemplate.send(TOPIC, savedPayment); // Send to Kafka for async processing
        
        return savedPayment;
    }
}
