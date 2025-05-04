package com.ollama.backend.controller;

import com.ollama.backend.service.AiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {
    private AiService aiService;

    public AiController(AiService aiService){
        this.aiService = aiService;
    }
    @GetMapping
    public ResponseEntity<String> askAi(
    @RequestParam(value= "query",
            required = false,
            defaultValue = "How are You Doing? How Can You Help Me"  )
            String query
    ){
    String response= aiService.askAi(query);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("stream")
    public Flux<String> streamAi(
            @RequestParam(value= "query",
                    required = false,
                    defaultValue = "How are You? How Can You Help Me"  )
            String query
    ){

        return aiService.streamResponse(query);
    }

}
