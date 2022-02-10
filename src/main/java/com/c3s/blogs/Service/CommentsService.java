package com.c3s.blogs.Service;
import com.c3s.blogs.Entity.Comment;
import com.c3s.blogs.Repository.CommentsRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CommentsService {

    @Autowired
    private CommentsRepo repository;

    //Repository.save: can be used to add or update a certain entity
    public Comment addComment(Comment comment){
        return repository.save(comment);
    }

    public Boolean deleteCommentByID(Long id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    public List<Comment> getAllCommentsForBlogPostById(Long id){
        return repository.findByBlogPostId(id);
    }

    public List<Comment> getAllCommentsForUserByUserName(String username){
        return repository.findByUserUserName(username);
    }

    public Boolean deleteCommentById(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
