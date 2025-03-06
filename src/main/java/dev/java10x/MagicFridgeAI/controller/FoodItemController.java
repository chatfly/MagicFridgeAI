package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;

    @PostMapping("/")
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        FoodItem salvo = foodItemService.salvar(foodItem);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/")
    public ResponseEntity<List<FoodItem>> listar() {
        return ResponseEntity.ok(foodItemService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(foodItemService.listarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> atualizarPorId(@PathVariable Long id, @RequestBody FoodItem foodItem) {
        FoodItem foodItemAtualizado = foodItemService.atualizar(id, foodItem);
        if(foodItemAtualizado != null) {
            return ResponseEntity.ok(foodItemAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        foodItemService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
