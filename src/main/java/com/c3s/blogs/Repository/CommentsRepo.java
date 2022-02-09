package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comment,Integer> {
    //Comment findBy(String name);
}
