package co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.DTO.ComidaDTO;

public interface IComidaService {
    
    public List<ComidaDTO> findAll();

	public ComidaDTO findById(Integer id);

	public ComidaDTO save(ComidaDTO comida);

	public ComidaDTO update(Integer id, ComidaDTO comida);

	public boolean delete(Integer id);

	public boolean existById(Integer id);

	public boolean existByNombre(String nombre);
}
