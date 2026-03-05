package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Enitity.Expenses;
import com.dev.ExpenseTracker.Enitity.Model.DashboardResponse;
import com.dev.ExpenseTracker.Enitity.User;
import com.dev.ExpenseTracker.Repository.ExpenseRepository;
import com.dev.ExpenseTracker.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ExpenseRepository expenseRepo ;
    private final UserRepository userRepository ;

    public DashboardResponse getDashboardData( String email){
        User user = userRepository.findByEmail(email) ;
//                .orElseThrow(() -> new RuntimeException("User not Found"));

        List<Expenses> expenses = expenseRepo.findByUser_Id(user.getId()) ;

        int totalAmount = expenses.stream()
                .mapToInt(Expenses::getAmount)
                .sum() ;

        long totalTransaction = expenses.size() ;

        Map<String , Integer> categoryWiseTotal =
                expenses.stream()
                        .collect(Collectors.groupingBy(
                                e-> e.getCatTitle() , Collectors.summingInt(Expenses::getAmount)
                        ));

        Map<String , Integer > monthWiseTotal = expenses.stream()
                .collect(Collectors.groupingBy(
                        e ->e.getCreatedAt().getMonth().toString() ,
                        Collectors.summingInt(Expenses::getAmount)
                )) ;

        List<Expenses> recentExpenses = expenses.stream()
                .sorted(Comparator.comparing(Expenses::getCreatedAt).reversed())
                .limit(5)
                .toList() ;


        return new DashboardResponse(
                totalAmount ,
                totalTransaction,
                categoryWiseTotal ,
                monthWiseTotal ,
                recentExpenses
        ) ;

    }
}
