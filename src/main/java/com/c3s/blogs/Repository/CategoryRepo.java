package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByName(String name);

}
