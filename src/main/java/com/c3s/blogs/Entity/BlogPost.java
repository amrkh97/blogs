package com.c3s.blogs.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiRelationId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.*;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonApiResource(type = "blog")
public class BlogPost {
    @JsonApiId
    private Long id;

    @JsonProperty
    private String text;

    public BlogPost(Long id, String text, UserModel user, Category category) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.category = category;
    }

    @JsonApiRelationId
    private UserModel user;

    @JsonApiRelationId
    private Category category;

    @JsonApiRelation
    private List<Comment> comment;


}
