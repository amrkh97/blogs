package com.c3s.blogs.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name="WRITTEN_BY", referencedColumnName="id")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "FOR_POST", referencedColumnName = "id")
    private BlogPost blogPost;

}
