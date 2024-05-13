package co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models.ComidaEntity;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.repositories.ComidaRepository;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.DTO.ComidaDTO;

@Service
public class ComidaServiceImpl implements IComidaService {
    
    @Autowired
	private ComidaRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ComidaDTO> findAll() {

		List<ComidaEntity> comidaEntity = this.servicioAccesoBaseDatos.findAll();
		List<ComidaDTO> comidaDTO = this.modelMapper.map(comidaEntity, new TypeToken<List<ComidaDTO>>() {
		}.getType());
		return comidaDTO;
	}

    @Override
	public ComidaDTO findById(String codigo) {
		ComidaEntity objComidaEntity = this.servicioAccesoBaseDatos.findById(codigo);
		ComidaDTO comidaDTO = this.modelMapper.map(objComidaEntity, ComidaDTO.class);
		return comidaDTO;
	}

	@Override
	public ComidaDTO save(ComidaDTO comida) {
		ComidaEntity comidaEntity = this.modelMapper.map(comida, ComidaEntity.class);
		ComidaEntity objComidaEntity = this.servicioAccesoBaseDatos.save(comidaEntity);
		ComidaDTO comidaDTO = this.modelMapper.map(objComidaEntity, ComidaDTO.class);
		return comidaDTO;
	}

	@Override
	public ComidaDTO update(String codigo, ComidaDTO comida) {
		ComidaEntity comidaEntity = this.modelMapper.map(comida, ComidaEntity.class);
		ComidaEntity comidaEntityActualizado = this.servicioAccesoBaseDatos.update(codigo, comidaEntity);
		ComidaDTO comidaDTO = this.modelMapper.map(comidaEntityActualizado, ComidaDTO.class);
		return comidaDTO;
	}

	@Override
	public boolean delete(String codigo) {
		return this.servicioAccesoBaseDatos.delete(codigo);
	}
}
