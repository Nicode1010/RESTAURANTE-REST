package co.edu.unicauca.infolll.proyecto_api_rest_comida.capaControladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.DTO.ComidaDTO;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.services.IComidaService;

@RestController
@RequestMapping("/api")
public class ComidaRestController {

	@Autowired
	private IComidaService comidaService;

	@GetMapping("/comidas")
	public List<ComidaDTO> show() {
		return comidaService.findAll();
	}

	@GetMapping("/comidas/{id}")
	public ComidaDTO show(@PathVariable Integer id) {
		ComidaDTO objComida = null;
		objComida = comidaService.findById(id);
		return objComida;
	}

	@GetMapping("/comidas/consultarSiExiste/{id}")
	public boolean consultarSiExistePorID(@PathVariable Integer id) {
		Boolean bandera = comidaService.existById(id);
		return bandera;
	}

	@GetMapping("/comidas/consultarSiExistePorNombre/{nombre}")
	public boolean consultarSiExistePorNombre(@PathVariable String nombre) {
		Boolean bandera = comidaService.existByNombre(nombre);
		return bandera;
	}

	@PostMapping("/comidas")
	public ComidaDTO create(@RequestBody ComidaDTO comida) {
		ComidaDTO objComida = null;
		objComida = comidaService.save(comida);
		return objComida;
	}

	@PutMapping("/comidas/{id}")
	public ComidaDTO update(@RequestBody ComidaDTO comida, @PathVariable Integer id) {
		ComidaDTO objComida = null;
		ComidaDTO comidaActual = comidaService.findById(id);
		if (comidaActual != null) {
			objComida = comidaService.update(id, comida);
		}
		return objComida;
	}

	@DeleteMapping("/comidas/{id}")
	public Boolean delete(@PathVariable Integer id) {
		Boolean bandera = false;
		ComidaDTO comidaActual = comidaService.findById(id);
		if (comidaActual != null) {
			bandera = comidaService.delete(id);
		}
		return bandera;

	}

}


