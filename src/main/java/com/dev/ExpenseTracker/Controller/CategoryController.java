package com.dev.ExpenseTracker.Controller;


import com.dev.ExpenseTracker.Enitity.Model.CategoryRequest;
import com.dev.ExpenseTracker.Enitity.Model.CategoryResponse;
import com.dev.ExpenseTracker.Service.CategoryServiceImple;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/expo/category")
public class CategoryController {

    private final CategoryServiceImple categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest categoryreq) {
        return ResponseEntity.ok(categoryService.addCategory(categoryreq));
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<List<CategoryResponse>> getCategoryByUser(@PathVariable String email) {
       List<CategoryResponse> cat = categoryService.getCategoryByUser(email);
        return ResponseEntity.ok(cat);
    }

    @PutMapping ("/edit")
    public ResponseEntity<CategoryResponse> updateCategory(CategoryRequest categoryReq) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryReq));
    }

    @DeleteMapping("del/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@RequestBody String categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
