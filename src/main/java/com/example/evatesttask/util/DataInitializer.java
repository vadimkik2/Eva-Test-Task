package com.example.evatesttask.util;

import com.example.evatesttask.model.Product;
import com.example.evatesttask.repository.ProductRepository;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final ProductRepository repository;

    @PostConstruct
    public void inject() {
        Product firstProduct = new Product("Iphone","description");
        repository.save(firstProduct);
        Product secondProduct = new Product("Ipad1","description");
        repository.save(secondProduct);
        Product thirdProduct = new Product("Xiaomi","description");
        repository.save(thirdProduct);
    }
}
