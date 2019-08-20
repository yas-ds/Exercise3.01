package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/dogform")
    public String loadDogForm(Model model){
        model.addAttribute("dog", new Dog());
        return "dogform";
    }

    @PostMapping("/dogform")
    public String processDogForm(@Valid Dog dog,
                                 BindingResult result){
        if (result.hasErrors()){
            return "dogform";
        }
        return "dogconfirm";
    }
}
