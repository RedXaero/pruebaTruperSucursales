package com.micro.truper.sucursales.service.serviceImpl;

import com.micro.truper.sucursales.dto.OrdenDto;
import com.micro.truper.sucursales.dto.ProductoDto;
import com.micro.truper.sucursales.entity.Orden;
import com.micro.truper.sucursales.entity.Producto;
import com.micro.truper.sucursales.entity.Sucursal;
import com.micro.truper.sucursales.mapper.OrdenMapper;
import com.micro.truper.sucursales.mapper.ProductoMapper;
import com.micro.truper.sucursales.repository.OrdenRepository;
import com.micro.truper.sucursales.repository.ProductoRepository;
import com.micro.truper.sucursales.repository.SucursalRepository;
import com.micro.truper.sucursales.service.OrdenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;
    private final SucursalRepository  sucursalRepository;
    private final ProductoRepository productoRepository;

    @Override
    public Optional<OrdenDto> findOrdenById(Long id) {
        Optional<Orden> orden = this.ordenRepository.findById(id);
        List<Producto>  listaProductos = this.productoRepository.findAll();
        List<ProductoDto> listaProductoDtos = new ArrayList<>();
        OrdenDto ordenDto= OrdenMapper.fromOrdenToOrdenDto(orden.get());
        Double total = 0.0;

        if(orden.isPresent()){
            for(Producto producto: listaProductos){
                listaProductoDtos.add(ProductoMapper.fromProductoToProductoDto(producto));
                total +=  producto.getPrecio();
            }
            ordenDto.setTotal(total);
            ordenDto.setCantidad(listaProductoDtos.size());
            ordenDto.setProductos(listaProductoDtos);
        }



        return Optional.of(ordenDto);
    }

    @Override
    public Optional<List<OrdenDto>> findAllOrdenes() {
        List<Orden>  ordenes = this.ordenRepository.findAll();
        List<OrdenDto> ordenesDto = new ArrayList<>();

        if(!ordenes.isEmpty()){
            for(Orden orden : ordenes){
                ordenesDto.add(OrdenMapper.fromOrdenToOrdenDto(orden));
            }
            return Optional.of(ordenesDto);
        }

        return Optional.empty();
    }

    @Override
    public Optional<OrdenDto> createNewOrden(OrdenDto ordenDto) {
        Orden ordenSaved;
        Optional<Sucursal> sucursal = this.sucursalRepository.findById(ordenDto.getSucursales().getSucursalId());

        if(sucursal.isPresent()){
            ordenDto.setSucursales(sucursal.get());
            ordenSaved = this.ordenRepository.save(OrdenMapper.fromOrdenDtoToOrden(ordenDto));
            return Optional.of(OrdenMapper.fromOrdenToOrdenDto(ordenSaved));
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteOrden(Long id) {
        if(this.ordenRepository.existsById(id)){
            this.ordenRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
