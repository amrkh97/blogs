package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.BlogPost;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface BlogPostRepo extends CrudRepository<BlogPost,Long> {
    List<BlogPost> findByUserUserName(String name);
    List<BlogPost> findByUserFirstName(String firstName);
    List<BlogPost> findByUserLastName(String lastName);
    List<BlogPost> findByCategoryCategoryName(String categoryName);
}