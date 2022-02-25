package com.c3s.blogs.Entity;
import lombok.*;


@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

}

