package com.micro.truper.sucursales.controller;

import com.micro.truper.sucursales.config.TrackExecutionTime;
import com.micro.truper.sucursales.dto.ProductoDto;
import com.micro.truper.sucursales.mapper.ProductoMapper;
import com.micro.truper.sucursales.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {


    private final ProductoService productoService;

    @PostMapping("/")
    @TrackExecutionTime
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoDto productoDto) {

        Optional<ProductoDto> productoGuardado = this.productoService.createNewProduct(productoDto);
        if (productoGuardado.isPresent()) {
            return new ResponseEntity<>( productoGuardado.get(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @PutMapping("/update")
    @TrackExecutionTime
    public ResponseEntity<ProductoDto> updateProducto(@RequestBody ProductoDto productoDto) {

        Optional<ProductoDto> productoGuardado = this.productoService.updateProduct(productoDto);
        if (productoGuardado.isPresent()) {
            return new ResponseEntity<>( productoGuardado.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
