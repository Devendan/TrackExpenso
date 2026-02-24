package com.dev.ExpenseTracker.Enitity.Model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryResponse {
    String id;
    String userId;
    String name;
    String title;
    LocalDateTime createdAt;

}
