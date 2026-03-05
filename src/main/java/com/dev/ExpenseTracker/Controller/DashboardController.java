package com.dev.ExpenseTracker.Controller;


import com.dev.ExpenseTracker.Enitity.Model.DashboardResponse;
import com.dev.ExpenseTracker.Service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/expo/dashboard")
public class DashboardController {

    private final DashboardService dashboardService ;

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboard(
            Authentication authentication
    ){
        String email = authentication.getName();

        DashboardResponse response = dashboardService.getDashboardData(email) ;

        return ResponseEntity.ok(response) ;
    }

}
