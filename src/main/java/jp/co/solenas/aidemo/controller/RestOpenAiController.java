package jp.co.solenas.aidemo.controller;

import jp.co.solenas.aidemo.request.BotRequest;
import jp.co.solenas.aidemo.request.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import jp.co.solenas.aidemo.response.BotResponse;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestOpenAiController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.max-completions}")
    private int maxCompletions;

    @Value("${openai.temperature}")
    private double temperature;

    @Value("${openai.maxTokens}")
    private int maxTokens;

    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")
    public BotResponse chat(@RequestParam("prompt") String prompt) {
        BotRequest request = new BotRequest(model,
                List.of(new Message("user", prompt)),
                maxCompletions,
                temperature,
                maxTokens);

        BotResponse response = restTemplate.postForObject(apiUrl, request, BotResponse.class);
        return response;
    }

    @PostMapping("/chat")
    public BotResponse postPrompt(@RequestParam("prompt") String prompt){
        return chat(prompt);
    }


}