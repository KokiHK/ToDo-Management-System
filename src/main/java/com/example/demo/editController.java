package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class editController {
    @GetMapping("/edit")
    public String edit() {
        return "edit";
    }
}