package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.ChatGptService;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final FoodItemService service;
    private final ChatGptService chatGptService;

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe(){
        List<FoodItem> foodItems = service.listar();
        return chatGptService.generateRecipe(foodItems)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
