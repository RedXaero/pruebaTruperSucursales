package com.micro.truper.sucursales.service;

import com.micro.truper.sucursales.dto.OrdenDto;

import java.util.List;
import java.util.Optional;

public interface OrdenService {

    Optional<OrdenDto> findOrdenById(Long id);
    Optional<List<OrdenDto>> findAllOrdenes();
    Optional<OrdenDto> createNewOrden(OrdenDto productoDto);
    Boolean deleteOrden(Long id);


}
