package com.dev.ExpenseTracker.Enitity.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {

        private String id;
        private int amount;
        private String title;
        private String description;
        private String catTitle ;
        private LocalDateTime createdAt;

        private String userId;
        private String categoryId;

}
