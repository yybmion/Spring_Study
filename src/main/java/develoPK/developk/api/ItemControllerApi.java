package develoPK.developk.api;

import develoPK.developk.domain.Item;
import develoPK.developk.repository.ItemRepository;
import develoPK.developk.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemControllerApi {

    private final ItemRepository itemRepository;
    private final TestRepository testRepository;

    @GetMapping("/saveItem")
    public List<Item> itemList(){
        List<Item> all = itemRepository.findAll();
        return all;
    }

    @PostMapping("/saveItem")
    public String saveItem(@RequestBody Item item){
        itemRepository.save(item);
        return "200OK";
    }

    @GetMapping("/pickItem")
    public Item pickItem(){
        Item pickItem = testRepository.itemQuerydsl();
        return pickItem;
    }
}
