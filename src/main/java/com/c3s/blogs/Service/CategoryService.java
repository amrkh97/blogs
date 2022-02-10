package com.c3s.blogs.Service;
import com.c3s.blogs.Entity.Category;
import com.c3s.blogs.Repository.CategoryRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CategoryService {
    @Autowired
    private CategoryRepo repository;

    public List<Category> getCategories(){
        return repository.findAll();
    }

    public Category addCategory(Category category){
        return repository.save(category);
    }

    public Category getCategoryByName(String name){
        return repository.findByName(name);
    }

    public Boolean deleteCategoryByID(Long id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
