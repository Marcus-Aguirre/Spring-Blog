package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    private final PostRepository postDao;

    //constructor
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    //    shows all the posts in the table
    @GetMapping("/posts")
    public String index(Model vmodel){
        vmodel.addAttribute("post",postDao.findAll());
        return "posts/index";
    }



    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model viewModel){
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post",post);
        viewModel.addAttribute("postId", id);
        return "posts/show";
    }

    //this url comes from browser then shows the create.html and from there,
//    there is a form that its method is post and action of URL:posts.
//    create so it sends the information here and saves it to the table
    @GetMapping("/posts/create")
    public String showCreateForm(){
        return "posts/create";
    }

    //information comes from create.html
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title,@RequestParam String body){
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        postDao.save(newPost);
        return "new post created";
    }


    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Long id ,Model viewModel){
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post",post);
        return "posts/edit";
    }


    @PostMapping("/posts/{id}/edit")
    public String editPost(@RequestParam String title,@RequestParam String body,@PathVariable Long id){
        Post post = postDao.findOne(id);
        post.setBody(body);
        post.setTitle(title);
        postDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/delete")
    public String deleteForm(@PathVariable Long id,Model viewModel){

        Post post = postDao.findOne(id);
        viewModel.addAttribute("post",post);
        return ("posts/delete");
    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable Long id){
        postDao.delete(id);

        return "deleted";
    }




/*    @GetMapping("/abc")
    public String showposts(Model vmodel) {
       // Post comes from Post.java
        List<Post> post = new ArrayList<>();

        post.add(new Post("a","b"));
        post.add(new Post("c","d"));

        vmodel.addAttribute("post",post);
        return "posts/index";
    }*/





}
