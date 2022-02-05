package pro.sky.skyprospringdemo.service;

import java.util.List;
import java.util.Set;

public interface ShoppingService {
    boolean addToShoppingList(String item);
    boolean removeFromShoppingList(String item);
    Set<String> getShoppingList();
}
