package com.micro.truper.sucursales.mapper;

import com.micro.truper.sucursales.dto.OrdenDto;
import com.micro.truper.sucursales.dto.ProductoDto;
import com.micro.truper.sucursales.entity.Orden;

import java.time.LocalDateTime;
import java.util.List;


public class OrdenMapper {

    public static Orden fromOrdenDtoToOrden(OrdenDto ordenDto) {
        Orden orden = new Orden();

        orden.setTotal(ordenDto.getTotal());
        orden.setFecha(LocalDateTime.now());
        orden.setSucursales(ordenDto.getSucursales());

        return orden;
    }

    public static OrdenDto fromOrdenToOrdenDto(Orden orden) {
        OrdenDto ordenDto = new OrdenDto();

        ordenDto.setOrdenId(orden.getOrdenId());
        ordenDto.setSucursales(orden.getSucursales());
        ordenDto.setTotal(orden.getTotal());
        return ordenDto;
    }
}
