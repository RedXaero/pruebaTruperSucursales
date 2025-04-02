package com.micro.truper.sucursales.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 20)
    private  String codigo;

    @Size(min = 1, max = 200)
    private String descripcion;

    @NotNull
    private Double precio;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;


}
