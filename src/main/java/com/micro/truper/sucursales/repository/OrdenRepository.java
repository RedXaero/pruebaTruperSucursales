package com.micro.truper.sucursales.repository;

import com.micro.truper.sucursales.dto.ProductoDto;
import com.micro.truper.sucursales.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
