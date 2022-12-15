package com.example.evatesttask.controller;

import com.example.evatesttask.dto.ProductResponseDto;
import com.example.evatesttask.mapper.ResponseDtoMapper;
import com.example.evatesttask.model.Product;
import com.example.evatesttask.service.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldShowAllProductsByNameFilter() {
        String nameFilter = "^.*[1].*$";
        List<Product> mockProducts = List.of(
                new Product(1L, "Product", "description"),
                new Product(2L, "Product1", "description"));
        List<ProductResponseDto> collect = mockProducts.stream()
                .map(ResponseDtoMapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
        Mockito.when(productService.getByNameFilter(nameFilter)).thenReturn(collect);

        RestAssuredMockMvc
                .given()
                .queryParam("nameFilter", nameFilter)
                .when()
                .get("/shop/product")
                .then()
                .body("size()", Matchers.equalTo(2))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].name", Matchers.equalTo("Product"))
                .body("[0].description", Matchers.equalTo("description"))
                .body("[1].id", Matchers.equalTo(2))
                .body("[1].name", Matchers.equalTo("Product1"))
                .body("[1].description", Matchers.equalTo("description"));
    }
}
