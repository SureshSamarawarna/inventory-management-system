package lk.ijse.dep9.controller;

import lk.ijse.dep9.model.Item;
import lk.ijse.dep9.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

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
        return itemRepository.save(item);
    }

}
