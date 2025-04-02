package com.micro.truper.sucursales.mapper;

import com.micro.truper.sucursales.dto.ProductoDto;
import com.micro.truper.sucursales.entity.Producto;

public class ProductoMapper {

    public static Producto fromProductoDtoToProducto(ProductoDto productoDto) {
        Producto producto = new Producto();

        producto.setCodigo(productoDto.getCodigo());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setOrden(productoDto.getOrden());

        return producto;
    }

    public static ProductoDto fromProductoToProductoDto(Producto producto) {
        ProductoDto productoDto = new ProductoDto();

        productoDto.setId(producto.getId());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setOrden(producto.getOrden());

        return productoDto;
    }

}
