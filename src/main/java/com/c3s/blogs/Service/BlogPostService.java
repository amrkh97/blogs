package com.c3s.blogs.Service;

import com.c3s.blogs.Entity.BlogPost;
import com.c3s.blogs.Entity.UserModel;
import com.c3s.blogs.Repository.BlogPostRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BlogPostService {

    @Autowired
    private BlogPostRepo repository;


    public List<BlogPost> getBlogPosts() {

        return repository.findAll();
    }

    public BlogPost addBlogPost(BlogPost blogPost){

        return repository.save(blogPost);
    }

    public BlogPost getBlogByUserUserName(String userName){

        return repository.findByUserUserName(userName);
    }

    public BlogPost getBlogByUserFirstName(String firstName){

        return repository.findByUserFirstName(firstName);
    }
    public BlogPost getBlogByUserLastName(String lastName){

        return repository.findByUserUserName(lastName);
    }

    public Boolean deleteBlogPost(BlogPost blogPost){
        Long id = blogPost.getId();
        repository.delete(blogPost);
        return !repository.existsById(id.intValue());
    }

}
