package com.example.demo.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizz-buzz")
public class FizzBuzzController {

    @RequestMapping(value = "/{num}", method = RequestMethod.GET)
    public String getResult(@PathVariable int num) {
        if(num==0)
            return "Unsupport 0!";

        int count=0;

        if(num%3==0)
            count++;
        if(num%5==0)
            count++;
        if(count==1)
            if(num%3==0)
                return "fizz";
            else
                return "buzz";
        if(count==2)
            return  "fizzbuzz";

        return String.valueOf(num);
    }

}
