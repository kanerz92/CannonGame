package com.saggezza.CannonGame;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "users")
public class UserModel {

    @Id
    private String id;
    @Field(name = "username")
    private String username;
    @Field(name = "password")
    private String password;

    public UserModel() {

    }

    public UserModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
