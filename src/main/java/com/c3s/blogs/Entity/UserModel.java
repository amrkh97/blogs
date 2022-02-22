package com.c3s.blogs.Entity;
import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@ToString
@NoArgsConstructor
@JsonApiResource(type = "user")
@Table(name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonApiId
    private Long id;

    @Column(name = "USER_NAME")
    @JsonApiField
    private String userName;

    @Column(name = "FIRST_NAME")
    @JsonApiField
    private String firstName;

    @Column(name = "LAST_NAME")
    @JsonApiField
    private String lastName;

    @Column(name = "PASSWORD")
    @JsonApiField
    @ToString.Exclude
    private String password;

    public UserModel(Long id, String userName, String firstName, String lastName, String password) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}

