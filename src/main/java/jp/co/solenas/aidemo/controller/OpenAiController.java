package jp.co.solenas.aidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class OpenAiController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
