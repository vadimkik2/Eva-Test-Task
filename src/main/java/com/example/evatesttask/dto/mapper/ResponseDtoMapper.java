package com.example.evatesttask.dto.mapper;

import com.example.evatesttask.dto.ProductResponseDto;
import com.example.evatesttask.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseDtoMapper {
    ResponseDtoMapper INSTANCE = Mappers.getMapper(ResponseDtoMapper.class);
    ProductResponseDto mapToDto(Product product);
}
