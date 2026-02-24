package com.dev.ExpenseTracker.Repository;

import com.dev.ExpenseTracker.Enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByName(String name);

    User findByEmail(String name);

}
