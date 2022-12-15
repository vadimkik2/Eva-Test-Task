package com.example.evatesttask.repository;

import java.util.stream.Stream;
import com.example.evatesttask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Stream<Product> streamAllBy();
}
