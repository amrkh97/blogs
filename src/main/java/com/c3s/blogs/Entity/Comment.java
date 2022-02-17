package com.c3s.blogs.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonApiResource(type = "comment")
public class Comment {
    @JsonApiId
    private Long id;

    @JsonProperty
    private String text;

    public Comment(Long id, String text, UserModel user, BlogPost blogPost) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.blogPost = blogPost;
    }

    @JsonApiRelationId
    private UserModel user;

    @JsonApiRelationId
    private BlogPost blogPost;

}
