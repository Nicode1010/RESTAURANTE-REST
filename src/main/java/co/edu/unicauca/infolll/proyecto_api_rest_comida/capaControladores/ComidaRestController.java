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
	public List<ComidaDTO> index() {
		return comidaService.findAll();
	}

	@GetMapping("/comidas/{codigo}")
	public ComidaDTO show(@PathVariable String codigo) {
		ComidaDTO objComida = null;
		objComida = comidaService.findById(codigo);
		return objComida;
	}


	@PostMapping("/comidas")
	public ComidaDTO create(@RequestBody ComidaDTO comida) {
		ComidaDTO objComida = null;
		objComida = comidaService.save(comida);
		return objComida;
	}

	@PutMapping("/comidas/{codigo}")
	public ComidaDTO update(@RequestBody ComidaDTO comida, @PathVariable String codigo) {
		ComidaDTO objComida = null;
		ComidaDTO comidaActual = comidaService.findById(codigo);
		if (comidaActual != null) {
			objComida = comidaService.update(codigo, comida);
		}
		return objComida;
	}

	@DeleteMapping("/comidas/{codigo}")
	public Boolean delete(@PathVariable String codigo ) {
		Boolean bandera = false;
		ComidaDTO comidaActual = comidaService.findById(codigo);
		if (comidaActual != null) {
			bandera = comidaService.delete(codigo);
		}
		return bandera;

	}

	@GetMapping("/comidas/listarCabeceras")
	public void listarCabeceras(@RequestHeader Map<String, String> headers) {
		System.out.println("cabeceras");
		headers.forEach((key, value) -> {
			System.out.println(String.format("Cabecera '%s' = %s", key, value));
		});
	}

}
