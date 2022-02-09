package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost,Integer> {
    BlogPost findByUserUserName(String name);
    BlogPost findByUserFirstName(String firstName);
    BlogPost findByUserLastName(String lastName);
    BlogPost findByCategoryName(String categoryName);
}