package com.example.evatesttask.service;

import com.example.evatesttask.dto.ProductResponseDto;
import com.example.evatesttask.mapper.ResponseDtoMapper;
import com.example.evatesttask.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public List<ProductResponseDto> getByNameFilter(String nameFilter) {
        List<ProductResponseDto> responseDtos = productRepository.streamAllBy().parallel()
                .filter(product -> !product.getName().matches(nameFilter))
                .map(ResponseDtoMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
        return responseDtos;
    }
}
