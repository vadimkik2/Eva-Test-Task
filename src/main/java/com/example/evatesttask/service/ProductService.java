package com.example.evatesttask.service;

import com.example.evatesttask.model.Product;
import java.util.stream.Stream;

public interface ProductService {
    Stream<Product> getByNameFilter(String nameFilter);
}
