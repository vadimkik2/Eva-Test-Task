package com.example.evatesttask.service;

import com.example.evatesttask.dto.ProductResponseDto;
import com.example.evatesttask.model.Product;
import com.example.evatesttask.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @Test
    void shouldReturnAllByNameFilter() {
        Mockito.when(productRepository.streamAllBy()).thenReturn(Stream.of(
                new Product("Product", "description"),
                new Product("Product1", "description")));
        String nameFilter = "^.*[1].*$";
        List<ProductResponseDto> actual = productService.getByNameFilter(nameFilter);
        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals("Product", actual.get(0).getName());
    }
}
