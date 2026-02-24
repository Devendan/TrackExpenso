package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Enitity.Model.UserRequest;
import com.dev.ExpenseTracker.Enitity.Model.UserResponse;
import com.dev.ExpenseTracker.Enitity.User;

public interface IUserService {

    public UserResponse createUser(UserRequest userReq);
    public void updateUser(UserRequest userReq);

    public void deleteUser(String id);
    public UserResponse getUserById(String id);
}
