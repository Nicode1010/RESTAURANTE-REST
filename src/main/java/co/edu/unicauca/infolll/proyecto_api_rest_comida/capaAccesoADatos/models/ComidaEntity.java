package co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class ComidaEntity {
    private String codigo;
	private String nombre;
	private String tipo;
	private String precio;
	private Integer cantidadIngredientes;

    public ComidaEntity(){

    }
}
