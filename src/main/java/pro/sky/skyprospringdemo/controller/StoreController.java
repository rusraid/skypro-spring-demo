package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.service.ProductService;

import java.util.List;

@RestController
public class StoreController {

    private final ProductService productService;

    public StoreController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/get/name-by-type")
    public List<String> getProductsNameByType(@RequestParam("type") String type) {
        return productService.getProductsNameByType(type);
    }

    @GetMapping(path = "/get/names")
    public List<String> getAllProducts() {
        return productService.getAllProductsName();
    }

    @GetMapping(path = "/get/count-by-type")
    public int countProductsByType(@RequestParam("type") String type) {
        return productService.countProductsByType(type);
    }

    @GetMapping(path = "/post/add-product")
    boolean addProduct(@RequestParam("name") String name, @RequestParam("type") String type) {
        return productService.addProduct(name, type);
    }

    @GetMapping(path = "/post/remove-product")
    boolean removeProduct(@RequestParam("name") String name, @RequestParam("type") String type) {
        return productService.removeProduct(name, type);
    }

    @GetMapping(path = "/get/contains-product")
    boolean containsProduct(@RequestParam("name") String name, @RequestParam("type") String type) {
        return productService.containsProduct(name, type);
    }

}