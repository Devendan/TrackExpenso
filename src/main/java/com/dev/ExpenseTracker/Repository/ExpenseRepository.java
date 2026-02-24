package com.dev.ExpenseTracker.Repository;

import com.dev.ExpenseTracker.Enitity.Expenses;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,String> {
    List<Expenses> findByUser_Id(String userId);

    List<ExpenseResponse> findByCategory_Id(String categoryId);

    List<Expenses> findByUserId(String userId);

//    List<ExpenseResponse> findByUser_IdAndCatTitle(String userId, String lowerCase);
List<Expenses> findByUser_IdAndCatTitle(String userId, String lowerCase);
}
