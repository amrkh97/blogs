package com.c3s.blogs.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
public class blogPostDTO {

    private Long id;

    private String text;

    private UserModel user;

    private Category category;

    private List<Comment> comment;
}
