package com.codeup.blog.models;


import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity @Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToOne
    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}

//to create the Post table and all the columns and then post repository interface