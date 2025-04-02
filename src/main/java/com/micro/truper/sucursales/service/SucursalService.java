package com.micro.truper.sucursales.service;

import com.micro.truper.sucursales.dto.SucursalDto;

import java.util.List;
import java.util.Optional;

public interface SucursalService {


    Optional<SucursalDto> findSucursalById(Long id);
    Optional<List<SucursalDto>> findAllSucursales();
    Optional<SucursalDto> createNewSucursal(SucursalDto productoDto);
    Optional<SucursalDto> updateSucursal(SucursalDto productoDto);
    Boolean deleteSucursal(Long id);


}
