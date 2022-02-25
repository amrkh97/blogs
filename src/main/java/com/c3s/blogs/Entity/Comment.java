package com.c3s.blogs.Entity;
import lombok.*;


@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {


    private Long id;


    private String text;

    private UserModel user;

    private BlogPost blogPost;

}
