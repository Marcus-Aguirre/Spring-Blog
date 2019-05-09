package com.codeup.blog.controllers;

import com.codeup.blog.EmailService;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailSvc;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailSvc){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
    }

    @GetMapping("/posts")
    public String index(Model vmodel){
        vmodel.addAttribute("posts",postDao.findAll());
        return "posts/index";
    }



    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model viewModel){
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post",post);
        viewModel.addAttribute("postId", id);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String showCreateForm(Model viewModel){

        viewModel.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){

        post.setUser(userDao.findOne(1L));
        postDao.save(post);
        emailSvc.prepareAndSend(post, "New Post Created", "A new post has been created and is ready to be viewed");

        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Long id , Model viewModel){
        viewModel.addAttribute("post", postDao.findOne(id));

        return "posts/edit";
    }


    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){

        post.setUser(userDao.findOne(1L));
        postDao.save(post);

        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/delete")
    public String deleteForm(@PathVariable Long id, Model viewModel){

        Post post = postDao.findOne(id);
        viewModel.addAttribute("post",post);
        return ("posts/delete");
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id){
        postDao.delete(id);

        return "redirect:/posts";
    }



}
