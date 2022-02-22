package com.c3s.blogs.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.crnk.core.resource.annotations.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonApiResource(type = "blog")
@Data
@Entity
@Table(name = "BLOG_POSTS")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonApiId
    private Long id;

    @JsonApiField
    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name="POSTED_BY", referencedColumnName="id")
    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER)
    private UserModel user;

    @OneToOne
    @JoinColumn(name="POST_CATEGORY", referencedColumnName="id")
    @JsonApiRelation
    private Category category;

    @OneToMany
    @JoinColumn(name = "COMMENTS", referencedColumnName="id")
    @JsonBackReference
    @JsonApiRelation
    private List<Comment> comment;


    public BlogPost(Long id, String text, UserModel user, Category category) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.category = category;
    }

}
