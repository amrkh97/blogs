package com.c3s.blogs.Repository;

import com.c3s.blogs.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepo extends JpaRepository<Comment,Long> {
    List<Comment> findByUserUserName(String userName);
    List<Comment> findByBlogPostId(Long id);
}
