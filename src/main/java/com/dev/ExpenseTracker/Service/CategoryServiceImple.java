package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Repository.CategoryRepository;
import com.dev.ExpenseTracker.Enitity.Categories;
import com.dev.ExpenseTracker.Enitity.Model.CategoryRequest;
import com.dev.ExpenseTracker.Enitity.Model.CategoryResponse;
import com.dev.ExpenseTracker.Enitity.User;
import com.dev.ExpenseTracker.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImple implements ICategoryService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    UserRepository userRepo;

    @Override
    public CategoryResponse addCategory(CategoryRequest CategoryReq ) {
        User user =userRepo. findById(CategoryReq.getUserId())
                .orElseThrow(()->new RuntimeException("user Not Found"));
        Categories category=mapper.map(CategoryReq,Categories.class);
        category.setId(null);
        category.setUser(user);
        //category.getCreatedAt();
        Categories savedCategory = categoryRepo.save(category);

        CategoryResponse response = mapper.map(savedCategory, CategoryResponse.class);

        // IMPORTANT: manually set userId
        response.setUserId(user.getId());
        return response;

    }

//    @Override
//    public List<CategoryResponse> getCategoryByUser(String email) {
//       User user=userRepo.findByEmail(email);
//        List<Categories> categoryResp=categoryRepo.findByUser (String.valueOf(user));
//        return categoryResp.stream()
//                .map(category->mapper.map(category,CategoryResponse.class)).toList();
//    }


    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryReq) {
        Categories category=mapper.map(categoryReq,Categories.class);
        Categories updated=categoryRepo.save(category);
        return mapper.map(updated,CategoryResponse.class);
    }

    @Override
    public void deleteCategory(String CategoryId) {
        categoryRepo.deleteById(CategoryId);

    }


}
