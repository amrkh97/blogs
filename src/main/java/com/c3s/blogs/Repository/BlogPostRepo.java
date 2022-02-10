package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {
    List<BlogPost> findByUserUserName(String name);
    List<BlogPost> findByUserFirstName(String firstName);
    List<BlogPost> findByUserLastName(String lastName);
    List<BlogPost> findByCategoryCategoryName(String categoryName);
}