package com.c3s.blogs.Controller;


import com.c3s.blogs.Entity.BlogPost;
import com.c3s.blogs.Entity.ResponseModel;
import com.c3s.blogs.Service.BlogPostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class BlogPostController {
    @Autowired
    private BlogPostService service;

    @GetMapping("/post/all")
    public ResponseEntity<List<BlogPost>> findAllBlogPosts() {
        return ResponseEntity.ok()
                .body(service.getBlogPosts());
    }

    @PostMapping("/post/add")
    public ResponseEntity<BlogPost> addBlogPost(@RequestBody BlogPost blogPost) {
        return ResponseEntity.ok()
                .body(service.addBlogPost(blogPost));
    }

    @GetMapping("/post/user/{username}")
    public ResponseEntity<List<BlogPost>> findAllBlogPostsByUserName(@PathVariable("username") String userName) {
        return ResponseEntity.ok()
                .body(service.getBlogByUserUserName(userName));
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<ResponseModel> deleteBlogPostById(@PathVariable("id") Long id) {
        int responseCode = -1;
        String responseMessage = "";
        try{
            service.deleteBlogPostById(id);
            responseCode = 200;
            responseMessage = String.format("Post With ID: %d Deleted Successfully", id);
            return ResponseEntity.ok()
                    .body(new ResponseModel(responseCode, responseMessage));
        }catch(Exception e){
            responseCode = 404;
            responseMessage = String.format("Post With ID: %d Does Not Exist", id);
            return ResponseEntity.status(responseCode)
                    .body(new ResponseModel(responseCode, responseMessage));
        }

    }

}
