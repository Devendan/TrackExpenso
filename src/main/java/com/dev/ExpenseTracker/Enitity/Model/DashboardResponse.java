package com.dev.ExpenseTracker.Enitity.Model;


import com.dev.ExpenseTracker.Enitity.Expenses;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class DashboardResponse {

    private int totalAmount ;
    private long totalTransaction ;
    private Map<String , Integer> categoryWiseTotal ;
    private  Map<String , Integer> monthWiseTotal ;
    private List<Expenses> recentExpense ;
}
