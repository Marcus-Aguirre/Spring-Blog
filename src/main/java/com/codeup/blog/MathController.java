package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{number}/and/{secondNumber}")
    @ResponseBody
    public String addition(@PathVariable int number, @PathVariable int secondNumber) {
        return number + " + " + secondNumber + " = " + (number + secondNumber);
    }


    @GetMapping("/subtract/{number}/from/{secondNumber}")
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int secondNumber) {
        return number + " - " + secondNumber + " = " + (secondNumber - number);
    }


    @GetMapping("/multiply/{number}/and/{secondNumber}")
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int secondNumber) {
        return number + " x " + secondNumber + " = " + (number * secondNumber);
    }


    @GetMapping("/divide/{number}/by/{secondNumber}")
    @ResponseBody
    public String divide(@PathVariable double number, @PathVariable double secondNumber) {
        return number + " / " + secondNumber + " = " + (number / secondNumber);
    }

}