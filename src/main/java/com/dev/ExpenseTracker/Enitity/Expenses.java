package com.dev.ExpenseTracker.Enitity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int Amount;
    private String title ;
    private String description;
    private String catTitle ;

    @Timestamp
    @CreationTimestamp
    private LocalDateTime CreatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Categories category;

}
