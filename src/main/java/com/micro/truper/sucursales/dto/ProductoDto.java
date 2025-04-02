package com.micro.truper.sucursales.dto;


import com.micro.truper.sucursales.entity.Orden;
import com.micro.truper.sucursales.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long id;
    private String descripcion;
    private Double precio;
    private Orden orden;
    private String codigo;


}
