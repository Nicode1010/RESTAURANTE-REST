package co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
public class ComidaEntity {
	//se definen atributos
    private Integer idComida;
	private String nombre;
	private EnumTipodeComida tipo;
	private String precio;
	private Integer cantidadIngredientes;
//Constructor vacio que no toma ningun argumento
//Cuando se crea un objeto ComidaEntity no se inicializan los valores de sus atributos
    public ComidaEntity(){

    }
}
