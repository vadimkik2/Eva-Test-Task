package com.example.evatesttask.controller;

import com.example.evatesttask.dto.mapper.ResponseDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import com.example.evatesttask.dto.ProductResponseDto;
import com.example.evatesttask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/product")
    @Transactional
    public List<ProductResponseDto> getProductsByNameFilter(
            @RequestParam String nameFilter) {
        return productService.getByNameFilter(nameFilter).map(ResponseDtoMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}