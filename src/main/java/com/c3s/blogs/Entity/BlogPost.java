package com.c3s.blogs.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "BLOG_POSTS")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name="POSTED_BY", referencedColumnName="id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name="POST_CATEGORY", referencedColumnName="id")
    private Category category;

    @OneToMany
    @JoinColumn(name = "COMMENTS", referencedColumnName="id")
    private List<Comment> comment;


}
