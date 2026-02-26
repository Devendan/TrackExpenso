package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Enitity.Model.CategoryRequest;
import com.dev.ExpenseTracker.Enitity.Model.CategoryResponse;
import com.dev.ExpenseTracker.Enitity.User;

import java.util.List;

public interface ICategoryService {
    public CategoryResponse addCategory(CategoryRequest categoryreq );
//    public List<CategoryResponse> getCategoryByUser(String email);
    public CategoryResponse updateCategory(CategoryRequest categoryReq);

    public void deleteCategory(String CategoryId);
}
