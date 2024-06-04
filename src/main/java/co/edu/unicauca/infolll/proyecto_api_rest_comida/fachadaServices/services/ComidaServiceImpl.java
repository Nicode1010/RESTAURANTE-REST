package co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models.ComidaEntity;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.repositories.ComidaRepositoryBaseDatos;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.DTO.ComidaDTO;

@Service
public class ComidaServiceImpl implements IComidaService {
    
    @Autowired
	private ComidaRepositoryBaseDatos servicioAccesoBaseDatos;

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
	public ComidaDTO findById(Integer id) {
		ComidaEntity objComidaEntity = this.servicioAccesoBaseDatos.findById(id);
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
	public ComidaDTO update(Integer id, ComidaDTO comida) {
		ComidaEntity comidaEntity = this.modelMapper.map(comida, ComidaEntity.class);
		ComidaEntity comidaEntityActualizado = this.servicioAccesoBaseDatos.update(id, comidaEntity);
		ComidaDTO comidaDTO = this.modelMapper.map(comidaEntityActualizado, ComidaDTO.class);
		return comidaDTO;
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);
	}
	@Override
	public boolean existById(Integer id) {
		boolean bandera = false;
		ComidaEntity objComidaEntity = this.servicioAccesoBaseDatos.findById(id);
		if (objComidaEntity != null)
			bandera = true;

		return bandera;
	}

	@Override
	public boolean existByNombre(String nombre) {
		return this.servicioAccesoBaseDatos.findByNombre(nombre);
	}
}
