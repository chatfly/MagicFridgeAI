package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItem salvar(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public List<FoodItem> listar() {
        return repository.findAll();
    }

    public FoodItem listarPorId(Long id) {
        Optional<FoodItem> foodItemPorId = repository.findById(id);
        if(foodItemPorId.isPresent()){
            return foodItemPorId.get();
        }
        return null;
    }

    public FoodItem atualizar(Long id, FoodItem foodItemNovo){
        Optional<FoodItem> foodItemAtual = repository.findById(id);
        if(foodItemAtual.isPresent()){
            foodItemNovo.setId(foodItemAtual.get().getId());
            return repository.save(foodItemNovo);
        }
        return null;
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

}
