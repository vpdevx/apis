package com.kurtfinancial.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity @Table(name = "bill")
@Getter @Setter
@NoArgsConstructor @ToString
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float value;

    private Date date;
}
