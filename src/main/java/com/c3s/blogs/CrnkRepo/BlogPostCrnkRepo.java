package com.c3s.blogs.CrnkRepo;

import com.c3s.blogs.Entity.BlogPost;
import com.c3s.blogs.Entity.UserModel;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Component
public class BlogPostCrnkRepo extends ResourceRepositoryBase<BlogPost, Long> {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(3);

    private Map<Long, BlogPost> blogPosts = new HashMap<>();

    public BlogPostCrnkRepo() {
        super(BlogPost.class);
        blogPosts.put(
                (long) 1,
                new BlogPost((long) 1, "Sushi Place",
                        new UserModel((long)1, "amrkh97", "Amr","Khaled", "Aa123456"),
                        null)
        );
        blogPosts.put(
                (long) 2,
                new BlogPost((long) 2, "Burger Place",
                        new UserModel((long)1, "amrkh97", "Amr","Khaled", "Aa123456"),
                        null)
        );
    }

    @Override
    public synchronized void delete(Long id) {
        blogPosts.remove(id);
    }

    @Override
    public synchronized <S extends BlogPost> S save(S restaurant) {
        if (restaurant.getId() == null) {
            restaurant.setId(ID_GENERATOR.getAndIncrement());
        }
        blogPosts.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    @Override
    public synchronized ResourceList<BlogPost> findAll(QuerySpec querySpec) {
        return querySpec.apply(blogPosts.values());
    }
}