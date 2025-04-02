package com.micro.truper.sucursales.controller;

import com.micro.truper.sucursales.config.TrackExecutionTime;
import com.micro.truper.sucursales.dto.OrdenDto;
import com.micro.truper.sucursales.entity.Orden;
import com.micro.truper.sucursales.repository.OrdenRepository;
import com.micro.truper.sucursales.service.OrdenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orden")
public class OrdenController {

    private final OrdenService ordenService;

    public  OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }


    @PostMapping("/")
    @TrackExecutionTime
    public ResponseEntity<OrdenDto> createNewOrden(@RequestBody OrdenDto productoDto) {
        Optional<OrdenDto> ordenSaved = this.ordenService.createNewOrden(productoDto);
        if(ordenSaved.isPresent()){
            return new ResponseEntity<>(ordenSaved.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/")
    @TrackExecutionTime
    public ResponseEntity<List<OrdenDto>> getAllOrdenes() {
        Optional<List<OrdenDto>> listaOrdenes = this.ordenService.findAllOrdenes();

        if(listaOrdenes.isPresent()){
            return new ResponseEntity<>(listaOrdenes.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/{orden_id}")
    @TrackExecutionTime
    public ResponseEntity<OrdenDto> getOrdenById(@PathVariable(value = "orden_id") Long ordenId) {
        Optional<OrdenDto> ordenDto = this.ordenService.findOrdenById(ordenId);

        if(ordenDto.isPresent()){
            return new ResponseEntity<>(ordenDto.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
