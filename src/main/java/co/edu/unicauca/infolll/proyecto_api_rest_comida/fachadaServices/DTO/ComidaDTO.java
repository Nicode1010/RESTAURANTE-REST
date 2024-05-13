package co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ComidaDTO {
    private String codigo;
	private String nombre;
	private String tipo;
	private String precio;
	private Integer cantidadIngredientes;

    public ComidaDTO(){

    }

}
