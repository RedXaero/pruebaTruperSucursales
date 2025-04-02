package com.micro.truper.sucursales.service.serviceImpl;

import com.micro.truper.sucursales.dto.ProductoDto;
import com.micro.truper.sucursales.entity.Orden;
import com.micro.truper.sucursales.entity.Producto;
import com.micro.truper.sucursales.mapper.OrdenMapper;
import com.micro.truper.sucursales.mapper.ProductoMapper;
import com.micro.truper.sucursales.repository.OrdenRepository;
import com.micro.truper.sucursales.repository.ProductoRepository;
import com.micro.truper.sucursales.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final OrdenRepository ordenRepository;

    @Override
    public Optional<ProductoDto> findProductById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);

        if(producto.isPresent()){
            return Optional.of(ProductoMapper.fromProductoToProductoDto(producto.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<ProductoDto>> findAllProducts() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDto> productoDtos = new ArrayList<>();

        if (!productos.isEmpty()){
            for (Producto producto : productos) {
                productoDtos.add(ProductoMapper.fromProductoToProductoDto(producto));
            }
            return Optional.of(productoDtos);
        }

        return Optional.empty();
    }

    @Override
    public Optional<ProductoDto> createNewProduct(ProductoDto productoDto) {
        Optional<Orden> orden = this.ordenRepository.findById(productoDto.getOrden().getOrdenId());

        if(orden.isPresent()) {
            productoDto.setOrden(orden.get());
            Producto producto = ProductoMapper.fromProductoDtoToProducto(productoDto);
            return Optional.of(ProductoMapper.fromProductoToProductoDto(this.productoRepository.save(producto)));
        }

        return Optional.empty();
    }

    @Override
    public Optional<ProductoDto> updateProduct(ProductoDto productoDto) {
        Optional<Producto> producto = this.productoRepository.findById(productoDto.getId());
        Orden orden = this.ordenRepository.findById(productoDto.getOrden().getOrdenId()).get();

        if(producto.isPresent()){
            if(Optional.ofNullable(productoDto.getDescripcion() ).isPresent()){
                producto.get().setDescripcion(productoDto.getDescripcion());
            }

            if(Optional.ofNullable(producto.get().getPrecio() ).isPresent()){
                producto.get().setPrecio(productoDto.getPrecio());
            }

            producto.get().setOrden(orden);

            return Optional.of(ProductoMapper.fromProductoToProductoDto(this.productoRepository.save(producto.get())));

        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteProduct(Long id) {
        Optional<Producto> producto = this.productoRepository.findById(id);
        if(producto.isPresent()){
            this.productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
