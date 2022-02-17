package com.c3s.blogs.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonApiResource(type = "category")
public class Category {

    @JsonApiId
    private Long id;

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    @JsonProperty
    private String categoryName;


}
