package com.c3s.blogs.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "USERS")
public class UserModel {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    @ToString.Exclude
    @JsonIgnore
    private String password;

    /*
    public User(){
        this.userName = "amrkh97";
        this.firstName = "Amr";
        this.lastName = "Khaled";
        this.password = "Aa123456";
    }
    */
}

