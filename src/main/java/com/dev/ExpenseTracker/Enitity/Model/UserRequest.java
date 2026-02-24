package com.dev.ExpenseTracker.Enitity.Model;

import lombok.Data;
import lombok.Getter;

@Data
public class UserRequest {
    private String name;
    private String password;
    private String email;

}
