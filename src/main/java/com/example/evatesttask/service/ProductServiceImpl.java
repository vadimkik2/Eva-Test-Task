package com.example.evatesttask.service;

import java.util.stream.Stream;
import com.example.evatesttask.model.Product;
import com.example.evatesttask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Stream<Product> getByNameFilter(String nameFilter) {
        Stream<Product> products = productRepository.streamAllBy().parallel()
                .filter(product -> !product.getName().matches(nameFilter));
        return products;
    }
}
