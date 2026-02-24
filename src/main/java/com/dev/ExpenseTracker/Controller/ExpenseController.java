package com.dev.ExpenseTracker.Controller;


import com.dev.ExpenseTracker.Enitity.Expenses;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseRequest;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseResponse;
import com.dev.ExpenseTracker.Repository.ExpenseRepository;
import com.dev.ExpenseTracker.Service.ExpenseServiceImpl;
import com.dev.ExpenseTracker.Service.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("expo")
public class ExpenseController  {

    private final ExpenseServiceImpl expenseService;

    @PostMapping("/addExpenses")
    public ResponseEntity<ExpenseResponse> addExpenses(@RequestBody ExpenseRequest expense) {
        return ResponseEntity.ok(expenseService.addExpenses(expense));
    }

    @GetMapping("Expenses/category")
    public ResponseEntity<List<ExpenseResponse>> getExpenseByCategory( @PathVariable  String categoryId) {
        List<ExpenseResponse> exBycat = expenseService.getExpenseByCategory(categoryId);
        return ResponseEntity.ok(exBycat);
    }

    @GetMapping("Expense/user/{userId}")
    public ResponseEntity<List<ExpenseResponse>> getExpenseByUser(@PathVariable  String userId) {
        List<ExpenseResponse> exByUser = expenseService.getExpenseByUser(userId);
        return ResponseEntity.ok(exByUser);
    }

    @PutMapping("expense/edit/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense( @RequestBody ExpenseRequest expense ,@PathVariable String id) {

        return ResponseEntity.ok(expenseService.updateExpense(expense , id));
    }

    @DeleteMapping("expense/{expenseId}")
    public ResponseEntity<Void> deleteExpense( @PathVariable String expenseId) {
    expenseService.deleteExpense(expenseId);
     return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}/category/{catTitle}")
    public ResponseEntity<List<ExpenseResponse>>  getByUserIdAndCatTitle(@PathVariable String userId , @PathVariable String catTitle){
        List<ExpenseResponse> catTitleExpense = expenseService.getExpensesByCatTitleAndUserId(userId , catTitle) ;
        System.out.println(catTitleExpense);
        return ResponseEntity.ok(catTitleExpense) ;
    }

    @GetMapping("expense/{id}")
    public  ResponseEntity<ExpenseResponse> ggetExpenseById(@PathVariable String id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }


}
