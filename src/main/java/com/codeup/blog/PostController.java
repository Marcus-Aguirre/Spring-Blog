package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String showPost(){
        return "Post Index Page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showIndividualPost(@PathVariable long id){
        return "Viewing individual page " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "GET: A form for creating a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String CreatePost(){
        return "POST: Creating a new post";
    }


}
