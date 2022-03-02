package com.c3s.blogs.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.c3s.blogs.Config.DynamoDBConfig;
import com.c3s.blogs.Entity.BlogPost;
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

    @Autowired
    private DynamoDBConfig config;

    public List<BlogPost> getBlogPosts() {

        return (List) repository.findAll();
    }

    public BlogPost addBlogPost(BlogPost blogPost){

        AmazonDynamoDB dynamoDB = config.amazonDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        mapper.save(blogPost);
        return repository.save(blogPost);
    }

    public List<BlogPost> getBlogByUserUserName(String userName){

        return (List) repository.findByUserUserName(userName);
    }

    public List<BlogPost> getBlogByUserFirstName(String firstName){

        return (List) repository.findByUserFirstName(firstName);
    }
    public List<BlogPost> getBlogByUserLastName(String lastName){

        return repository.findByUserLastName(lastName);
    }

    public List<BlogPost> getBlogByCategoryName(String name){
        return repository.findByCategoryCategoryName(name);
    }

    public Boolean deleteBlogPost(BlogPost blogPost){
        String id = blogPost.getId();
        repository.delete(blogPost);
        return !repository.existsById(id);
    }

    public Boolean deleteBlogPostById(String id){
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
