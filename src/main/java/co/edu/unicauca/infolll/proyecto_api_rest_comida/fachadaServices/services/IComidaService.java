package co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.DTO.ComidaDTO;

public interface IComidaService {
    
    public List<ComidaDTO> findAll();

	public ComidaDTO findById(String codigo);

	public ComidaDTO save(ComidaDTO comida);

	public ComidaDTO update(String codigo, ComidaDTO comida);

	public boolean delete(String codigo);
}
