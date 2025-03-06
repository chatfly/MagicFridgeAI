package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final ChatGptService chatGptService;

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe(){
        return chatGptService.generateRecipe()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
