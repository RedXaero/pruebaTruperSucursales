package com.micro.truper.sucursales.controller;

import com.micro.truper.sucursales.config.TrackExecutionTime;
import com.micro.truper.sucursales.dto.SucursalDto;
import com.micro.truper.sucursales.service.SucursalService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }


    @PostMapping("/")
    @TrackExecutionTime
    public ResponseEntity<SucursalDto> createSucursal(@RequestBody SucursalDto sucursalDto) {
        Optional<SucursalDto> savedSucursal;

        savedSucursal = this.sucursalService.createNewSucursal(sucursalDto);
        if (savedSucursal.isPresent()) {
            return new ResponseEntity<>(savedSucursal.get(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/{id}")
    @TrackExecutionTime
    public ResponseEntity<SucursalDto> getSucursal(@PathVariable Long id) {
        Optional<SucursalDto> savedSucursal = this.sucursalService.findSucursalById(id);
        if (savedSucursal.isPresent()) {
            return new ResponseEntity<>(savedSucursal.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    @TrackExecutionTime
    public ResponseEntity<List<SucursalDto>> getAllSucursales() {
        Optional<List<SucursalDto>> sucursales= this.sucursalService.findAllSucursales();
        if (sucursales.isPresent()) {
            return new ResponseEntity<>(sucursales.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
