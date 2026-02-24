package com.dev.ExpenseTracker.Service;

import com.dev.ExpenseTracker.Enitity.Categories;
import com.dev.ExpenseTracker.Enitity.Expenses;
import com.dev.ExpenseTracker.Enitity.Model.CategoryResponse;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseRequest;
import com.dev.ExpenseTracker.Enitity.Model.ExpenseResponse;
import com.dev.ExpenseTracker.Enitity.User;
import com.dev.ExpenseTracker.Repository.CategoryRepository;
import com.dev.ExpenseTracker.Repository.ExpenseRepository;
import com.dev.ExpenseTracker.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements IExpenseService {



    @Autowired
    ModelMapper mapper;

    private final UserRepository userRepo;
    private final CategoryRepository categoryRepo;
    private final ExpenseRepository expenseRepo;


    @Override
    public ExpenseResponse addExpenses(ExpenseRequest expenseRequest) {
        User user=userRepo.findById(expenseRequest.getUserId())
                .orElseThrow(()->new RuntimeException("User not Found Exception"));
//        Categories category=categoryRepo.findById(expenseRequest.getCategoryId())
//                .orElseGet(() ->{
//                    Categories newCategory =  new Categories();
//                    newCategory.setTitle(expenseRequest.getCategoryTitle);
//                    newCategory.setUser(user);
//                    categoryRepo.save(newCategory);
//                });
        //Expenses expense=mapper.map(expenseRequest,Expenses.class);
        Expenses expense = new Expenses();
        expense.setDescription(expenseRequest.getDescription());
        expense.setCatTitle(expenseRequest.getCatTitle()) ;
        expense.setTitle(expenseRequest.getTitle());
        expense.setAmount(expenseRequest.getAmount());
        expense.setUser(user);
        //expense.setCategory(category);
        Expenses savedExpense=expenseRepo.save(expense);
        ExpenseResponse response=mapper.map(savedExpense,ExpenseResponse.class);

        response.setUserId(user.getId());
       // response.setCategoryId(category.getId());
        return response;

    }

    @Override
    public List<ExpenseResponse> getExpenseByCategory(String categoryId) {
        List<ExpenseResponse> catList =expenseRepo.findByCategory_Id(categoryId);
        return catList;
    }

    @Override
    public List<ExpenseResponse> getExpenseByUser(String userId) {
        List<Expenses> exp =expenseRepo.findByUser_Id(userId);

        return exp.stream()
                .map(ex -> mapper.map(ex ,ExpenseResponse.class))
                .toList();
        //return exp;
    }

    public ExpenseResponse updateExpense (ExpenseRequest req , String id ){
        Expenses existingExpense = expenseRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Expense not Found"));
        existingExpense.setAmount(req.getAmount()) ;
        existingExpense.setCatTitle(req.getCatTitle());
        existingExpense.setDescription(req.getDescription());
        existingExpense.setTitle(req.getTitle());

        Expenses updatedExp = expenseRepo.save(existingExpense);

        return mapper.map(updatedExp,ExpenseResponse.class);

    }



//    public ExpenseResponse updatedBlog(ExpenseRequest req ){
//
////        User user=userRepo.findById(request.getUserId())
////                .orElseThrow(()->new RuntimeException("User not Found"));
//        Expenses post = expenseRepo.findById(req.getPostId())
//                .orElseThrow(() -> new RuntimeException("Post not found"));
//
//        // sirf update hone wale fields set karo
//        post.setTitle(req.getTitle());
//        post.setContent(req.getContent());
//
//        BlogRepo.save(post);
//
//        return mapper.map(post, BlogResponse.class);
//    }

    @Override
    public void deleteExpense(String  expenseId) {
         expenseRepo.deleteById(expenseId);
    }

//    public Expenses saveExpenseWithCategory(ExpenseRequest req , String userId){
//        //Check if Category is Exist or not
//        Categories category = categoryRepo.findByTitleAndUserId(req.getTitle() ,userId)
//                .orElseGet(()->{
//                    Categories newCat = new Categories();
//                    newCat.setTitle(req.get);
//                })
//    }

    public List<ExpenseResponse> getExpensesByCatTitleAndUserId(String userId , String catTitle){
        List<Expenses> expense =  expenseRepo.findByUser_IdAndCatTitle(userId , catTitle); //.trim().toLowerCase()
        //return exp.stream().map(ex -> mapper.map(exp, ExpenseResponse.class)).toList();
        return expense.stream().map(exp -> {
            ExpenseResponse res = new ExpenseResponse();
            res.setId(exp.getId());
            res.setAmount(exp.getAmount());
            res.setTitle(exp.getTitle());
            res.setCatTitle(exp.getCatTitle()) ;
            res.setDescription(exp.getDescription());
            res.setUserId(exp.getUser().getId());
            res.setCreatedAt(exp.getCreatedAt());

            return res;
        }).toList();


    }

    public ExpenseResponse getExpenseById( String id){
        Expenses expense = expenseRepo.findById(id).orElseThrow(()->new RuntimeException("Expesne not Found"));
        return mapper.map(expense , ExpenseResponse.class);
    }
}
