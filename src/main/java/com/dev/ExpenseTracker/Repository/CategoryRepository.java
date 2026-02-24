package com.dev.ExpenseTracker.Repository;

import com.dev.ExpenseTracker.Enitity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,String> {
    List<Categories> findByUser(String username);
}
