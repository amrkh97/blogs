package com.c3s.blogs.Controller;
import com.c3s.blogs.Entity.Comment;
import com.c3s.blogs.Entity.ResponseModel;
import com.c3s.blogs.Service.CommentsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class CommentsController {
    @Autowired
    private CommentsService service;

    @PostMapping("/comment/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        return ResponseEntity.ok().body(service.addComment(comment));
    }

    @GetMapping("/comment/post/{id}")
    public ResponseEntity<List<Comment>> getAllPostCommentsByPostId(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.getAllCommentsForBlogPostById(id));
    }

    @PutMapping("/comment/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){
        return ResponseEntity.ok().body(service.addComment(comment));
    }

    @DeleteMapping("/comment/delete/{id}")
    public ResponseEntity<ResponseModel> deleteCommentById(@PathVariable("id") Long id){
        int responseCode = -1;
        String responseMessage = "";
        try{
            service.deleteCommentById(id);
            responseCode = 200;
            responseMessage = String.format("Comment With ID: %d Deleted Successfully", id);
            return ResponseEntity.ok()
                    .body(new ResponseModel(responseCode, responseMessage));
        }catch(Exception e){
            responseCode = 404;
            responseMessage = String.format("Comment With ID: %d Does Not Exist", id);
            return ResponseEntity.status(responseCode)
                    .body(new ResponseModel(responseCode, responseMessage));
        }
    }
}
