package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Enitity.Expenses;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseRequest;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseResponse;
import com.dev.ExpenseTracker.Enitity.User;

import java.util.List;

public interface IExpenseService {
    public ExpenseResponse addExpenses(ExpenseRequest expense);
    public List<ExpenseResponse> getExpenseByCategory(String categoryId);
    public List<ExpenseResponse> getExpenseByUser(String userId);
    public ExpenseResponse updateExpense(ExpenseRequest expense , String id);
    public void deleteExpense(String expenseId);
}
