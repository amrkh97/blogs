package com.c3s.blogs.Controller;
import com.c3s.blogs.Entity.Category;
import com.c3s.blogs.Entity.ResponseModel;
import com.c3s.blogs.Service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/category/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok().body(service.getCategories());
    }

    @PostMapping("/category/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.ok().body(service.addCategory(category));
    }

    @PutMapping("/category/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok().body(service.addCategory(category));
    }

    @GetMapping("category/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(service.getCategoryByName(name));
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<ResponseModel> deleteCategoryById(@PathVariable("id") Long id){
        int responseCode = -1;
        String responseMessage = "";
        try{
            service.deleteCategoryByID(id);
            responseCode = 200;
            responseMessage = String.format("Category With ID: %d Deleted Successfully", id);
            return ResponseEntity.ok()
                    .body(new ResponseModel(responseCode, responseMessage));
        }catch(Exception e){
            responseCode = 404;
            responseMessage = String.format("Category With ID: %d Does Not Exist", id);
            return ResponseEntity.status(responseCode)
                    .body(new ResponseModel(responseCode, responseMessage));
        }

    }

}
