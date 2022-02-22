package com.c3s.blogs.CrnkRepo;

import com.c3s.blogs.Entity.Comment;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;


@Component
public class CommentRepoImpl extends JpaEntityRepositoryBase<Comment, Long> {


    public CommentRepoImpl() {
        super(Comment.class);
    }

   }
