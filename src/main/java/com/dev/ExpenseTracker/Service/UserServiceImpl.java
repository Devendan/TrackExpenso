package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Enitity.Model.UserRequest;
import com.dev.ExpenseTracker.Enitity.Model.UserResponse;
import com.dev.ExpenseTracker.Enitity.User;
import com.dev.ExpenseTracker.JwtUtils;
import com.dev.ExpenseTracker.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
     UserRepository userRepo;
    @Autowired
    ModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder ;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public UserResponse createUser(UserRequest userReq) {
        User user= mapper.map(userReq,User.class);
        user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        userRepo.save(user);
        String token = jwtUtils.generateToken(user.getEmail() , String.valueOf(user.getRoles()));
       UserResponse res =  mapper.map(user , UserResponse.class);
       res.setToken(token);
        return res;
    }

    @Override
    public void updateUser(UserRequest userReq) {
        User user=userRepo.findByEmail(userReq.getEmail());
         user= mapper.map(userReq,User.class);
        userRepo.save(user);

    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);

    }



    @Override
    public UserResponse getUserById(String id) {
        User user =  userRepo.findById(id).get();
        UserResponse userResp=mapper.map(user,UserResponse.class);
        return userResp;
    }


    public Map<String, Object> loginUser(UserRequest req) {

        User user = userRepo.findByEmail(req.getEmail());
        if (user == null)
            throw new RuntimeException("Invalid credentials");

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid credentials");

        // ✅ Generate JWT
        String token = jwtUtils.generateToken(
                user.getEmail(),
                user.getRoles().toString() // or String.valueOf(user.getRoles())
        );

        // ✅ Return token
        return Map.of(
                "token", token,
                "id",user.getId(),
                "email", user.getId(),
                "role", user.getRoles()
        );
    }

}
