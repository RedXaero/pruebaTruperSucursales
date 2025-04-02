package com.micro.truper.sucursales.repository;

import com.micro.truper.sucursales.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal,Long> {
}
