package com.micro.truper.sucursales.service;

import com.micro.truper.sucursales.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Optional<ProductoDto> findProductById(Long id);
    Optional<List<ProductoDto>> findAllProducts();
    Optional<ProductoDto> createNewProduct(ProductoDto productoDto);
    Optional<ProductoDto> updateProduct(ProductoDto productoDto);
    Boolean deleteProduct(Long id);

}
