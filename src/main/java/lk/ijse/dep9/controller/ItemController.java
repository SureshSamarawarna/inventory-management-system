package lk.ijse.dep9.controller;

import lk.ijse.dep9.exception.ResourceNotFoundException;
import lk.ijse.dep9.model.Item;
import lk.ijse.dep9.repository.ItemRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping()
    public Item createItems(@RequestBody Item item){
        System.out.println("request came");
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id,@RequestBody Item item){
        Item foundItem = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Can't fint item with : " + id));
        foundItem.setName(item.getName());
        foundItem.setCategory(item.getCategory());
        foundItem.setDiscount(item.getDiscount());
        foundItem.setPrice(item.getPrice());
        foundItem.setProductId(item.getProductId());
        foundItem.setQty(item.getQty());

        return itemRepository.save(foundItem);
    }

    @GetMapping
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable int id){
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Can,t find item with: "+id));
        return Optional.of(item);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteItemById(@PathVariable int id){
        Map<String,Boolean> status = new HashMap<>();
        Item foundItem = itemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Can,t find item with: "+id));
        itemRepository.delete(foundItem);
        status.put("DELETED",Boolean.TRUE);
        return status;

    }

    @DeleteMapping()
    public Map<String,Boolean> deleteAllItems(){
        Map<String,Boolean> status = new HashMap<>();
        itemRepository.deleteAll();
        status.put("DELETED ALL ITEMS",Boolean.TRUE);
        return status;

    }

}
