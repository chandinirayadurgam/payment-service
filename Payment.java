package com.payment.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime timestamp;
    
    public Payment() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters & Setters
}
