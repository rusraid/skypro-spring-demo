package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.service.ShoppingService;

import java.util.List;
import java.util.Set;

@RestController
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping(path = "/post/shopping-list")
    public boolean addToShoppingList(@RequestParam("item") String item) {
        return shoppingService.addToShoppingList(item);
    }

    @GetMapping(path = "delete/shopping-list/")
    public boolean removeFromShoppingList(@RequestParam("item") String item) {
        return shoppingService.removeFromShoppingList(item);
    }

    @GetMapping(path = "/get/shopping-list/")
    public Set<String> getShoppingList() {
        return shoppingService.getShoppingList();
    }
}
