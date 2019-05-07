package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class DiceRollerController {

    @GetMapping("/dice")
    public String dice(){

        return "dice";
    }

    @GetMapping("/rollDice/{num}")
    public String guessTest(@PathVariable int num, Model viewModel){

        int diceRoll = new Random().nextInt(6) + 1;
        viewModel.addAttribute("diceRoll", diceRoll);

        int guess = num;
        viewModel.addAttribute("guess", guess);


        String result;

        if(num == diceRoll){
            result = "right";
        }else{
            result = "wrong";
        }

        viewModel.addAttribute("result", result);

        return "rollResults";

    }
}
