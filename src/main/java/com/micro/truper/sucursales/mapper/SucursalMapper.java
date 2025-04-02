package com.micro.truper.sucursales.mapper;


import com.micro.truper.sucursales.dto.SucursalDto;
import com.micro.truper.sucursales.entity.Sucursal;

public class SucursalMapper {

    public static Sucursal fromSucursalDtoToSucursal(SucursalDto sucursalDto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDto.getNombre());

        return sucursal;
    }

    public static SucursalDto fromSucursalToSucursalDto(Sucursal sucursal) {
        SucursalDto sucursalDto = new SucursalDto();
        sucursalDto.setNombre(sucursal.getNombre());
        sucursalDto.setId(sucursal.getSucursalId());

        return sucursalDto;
    }

}
