package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model viewModel){
        viewModel.addAttribute("username", name);
        return "home";
    }



}
