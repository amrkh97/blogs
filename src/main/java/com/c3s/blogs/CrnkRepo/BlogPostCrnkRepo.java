package com.c3s.blogs.CrnkRepo;

import com.c3s.blogs.Entity.BlogPost;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;



@Component
public class BlogPostCrnkRepo extends JpaEntityRepositoryBase<BlogPost, Long> {


    public BlogPostCrnkRepo() {
        super(BlogPost.class);

    }

}