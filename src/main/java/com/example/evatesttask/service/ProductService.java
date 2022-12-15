package com.example.evatesttask.service;

import com.example.evatesttask.dto.ProductResponseDto;
import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getByNameFilter(String nameFilter);
}
