package pro.sky.skyprospringdemo.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.service.ShoppingService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    Set<String> shoppingList;

    public ShoppingServiceImpl() {
        shoppingList = new HashSet<>();
    }

    @Override
    public boolean addToShoppingList(String item) {
        return shoppingList.add(item);
    }

    @Override
    public boolean removeFromShoppingList(String item) {
        return shoppingList.remove(item);
    }

    @Override
    public Set<String> getShoppingList() {
        return shoppingList;
    }
}
