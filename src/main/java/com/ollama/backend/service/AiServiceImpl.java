package com.ollama.backend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AiServiceImpl implements  AiService {

    private ChatClient clint;

    public AiServiceImpl(ChatClient.Builder builder){
        this.clint = builder.build();
    }
    @Override
    public String askAi(String question){

        return clint.prompt(question).call().content();
    }
    @Override
    public Flux<String> streamResponse(String question){

        return this.clint.prompt().user(question).stream().content();
    }
}
