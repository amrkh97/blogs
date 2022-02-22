package com.c3s.blogs.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonApiResource(type = "category")
@Data
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @JsonApiId@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonApiField
    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
}
