package com.codeup.blog;


import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity @Table(name = "posts")
public class Post {
    //creating table
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

//geters and seters

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
}

//to create the Post table and all the columns and then post repository interface