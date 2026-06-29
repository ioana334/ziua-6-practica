package com.company.booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "trip")
@Getter
@Setter
@NoArgsConstructor
public class Trip{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String destination;
    
    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColum(name="user_id")
    private AppUser user;
}