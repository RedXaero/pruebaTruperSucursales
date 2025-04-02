package com.micro.truper.sucursales.service.serviceImpl;

import com.micro.truper.sucursales.dto.SucursalDto;
import com.micro.truper.sucursales.entity.Sucursal;
import com.micro.truper.sucursales.mapper.SucursalMapper;
import com.micro.truper.sucursales.repository.SucursalRepository;
import com.micro.truper.sucursales.service.ProductoService;
import com.micro.truper.sucursales.service.SucursalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    @Override
    public Optional<SucursalDto> findSucursalById(Long id) {
        return Optional.of(SucursalMapper.fromSucursalToSucursalDto(this.sucursalRepository.findById(id).get()));
    }

    @Override
    public Optional<List<SucursalDto>> findAllSucursales() {
        List<Sucursal> listaSucursales = this.sucursalRepository.findAll();
        List<SucursalDto> listaSucursalDto = new ArrayList<>();
        if (!listaSucursales.isEmpty()) {
            for (Sucursal sucursal : listaSucursales) {
                listaSucursalDto.add(SucursalMapper.fromSucursalToSucursalDto(sucursal));
            }
        }

        return Optional.of(listaSucursalDto);
    }

    @Override
    public Optional<SucursalDto> createNewSucursal(SucursalDto productoDto) {
        Sucursal sucursal = SucursalMapper.fromSucursalDtoToSucursal(productoDto);
        return Optional.ofNullable(SucursalMapper.fromSucursalToSucursalDto(this.sucursalRepository.save(sucursal)));
    }

    @Override
    public Optional<SucursalDto> updateSucursal(SucursalDto productoDto) {
        Optional<Sucursal> sucursal = this.sucursalRepository.findById(productoDto.getId());
        if (sucursal.isPresent()) {
            Sucursal newSucursal = new Sucursal();
            newSucursal.setNombre(productoDto.getNombre());

            this.sucursalRepository.save(newSucursal);

            return Optional.of(SucursalMapper.fromSucursalToSucursalDto(newSucursal));
        }

        return Optional.empty();
    }


    @Override
    public Boolean deleteSucursal(Long id) {
        Optional<Sucursal> sucursal = this.sucursalRepository.findById(id);
        if (sucursal.isPresent()) {
            this.sucursalRepository.delete(sucursal.get());
            return true;
        }

        return false;
    }
}
