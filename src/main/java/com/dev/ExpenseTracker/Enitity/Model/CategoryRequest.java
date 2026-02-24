package com.dev.ExpenseTracker.Enitity.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    String name;
    String title;
    String userId;

}
