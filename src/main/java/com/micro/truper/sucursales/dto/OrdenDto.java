package com.micro.truper.sucursales.dto;

import com.micro.truper.sucursales.entity.Sucursal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDto {
    private Long ordenId;
    private Sucursal sucursales;
    private Double total;
    private Integer cantidad;
    private List<ProductoDto> productos;

}
