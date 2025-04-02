package com.micro.truper.sucursales.repository;

import com.micro.truper.sucursales.entity.Producto;
import com.micro.truper.sucursales.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
