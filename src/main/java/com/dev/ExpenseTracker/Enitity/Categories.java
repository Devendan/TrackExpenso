package com.dev.ExpenseTracker.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    String id;
    String name;
    String title ;

    @CreationTimestamp
    LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn (name="user_id")
    @JsonIgnore
    private User user;

    @OneToMany (mappedBy ="category" ,cascade =CascadeType.ALL)
    private List<Expenses> expenses;

}
