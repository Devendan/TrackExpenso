package com.dev.ExpenseTracker.Enitity;

import com.dev.ExpenseTracker.Enitity.Model.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @Column (unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole roles = UserRole.USER;

    @Timestamp
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Timestamp
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Categories> category;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Expenses> expenses;


}