package com.ollama.backend.service;

import reactor.core.publisher.Flux;

public interface AiService {
    String askAi(String question);
    public Flux<String> streamResponse(String question);
}
