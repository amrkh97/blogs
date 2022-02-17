package com.c3s.blogs.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonApiResource(type = "user")
public class UserModel {
    @JsonApiId
    private Long id;

    public UserModel(Long id, String userName, String firstName, String lastName, String password) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @JsonProperty
    private String userName;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
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

