package com.c3s.blogs.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import io.crnk.core.resource.annotations.RelationshipRepositoryBehavior;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonApiResource(type = "comment")
@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonApiId
    private Long id;

    @JsonProperty
    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name="WRITTEN_BY", referencedColumnName="id")
    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER)
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "FOR_POST", referencedColumnName = "id")
    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER)
    private BlogPost blogPost;

    public Comment(Long id, String text, UserModel user, BlogPost blogPost) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.blogPost = blogPost;
    }

}
