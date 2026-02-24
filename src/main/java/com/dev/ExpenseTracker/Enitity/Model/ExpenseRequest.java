package com.dev.ExpenseTracker.Enitity.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequest {

        private int amount;
        private String description;
        private String title ;
        private String catTitle ;
        private String userId;
        private String categoryId;


}
