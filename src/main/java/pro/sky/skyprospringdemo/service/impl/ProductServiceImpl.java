package pro.sky.skyprospringdemo.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.data.Product;
import pro.sky.skyprospringdemo.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
        products.add(new Product("еда", "хлеб"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("еда", "колбаса"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("еда", "йогурт"));
        products.add(new Product("техника", "планшет"));
    }

    @Override
    public List<String> getProductsNameByType(String type) {
        List<String> searchResult = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getType().equals(type)) {
                searchResult.add(product.getName());
            }
        }
        return searchResult;
    }

    @Override
    public List<String> getAllProductsName() {
        List<String> searchResult = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            searchResult.add(product.getName());
        }
        searchResult.sort(String::compareTo);
        return searchResult;
    }

    @Override
    public int countProductsByType(String type) {
//        List<String> searchResult = new ArrayList<>();
        int count = 0;                           //добавили счетчик заместо нового массива
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getType().equals(type)) {
//                searchResult.add(product.getName());
                count++;                          //добавили счетчик заместо нового массива
            }
        }
//        return searchResult.size();
        return count;                             //добавили счетчик заместо нового массива
    }



    @Override
    public boolean containsProduct(String name, String type) {
        return products.contains(new Product(type, name));
    }

    @Override
    public boolean addProduct(String name, String type) {
        return products.add(new Product(type, name));
    }

    @Override
    public boolean removeProduct(String name, String type) {
        return products.remove(new Product(type, name));
    }
}
