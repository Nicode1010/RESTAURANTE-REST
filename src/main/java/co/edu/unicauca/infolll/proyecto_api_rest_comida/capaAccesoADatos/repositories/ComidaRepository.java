package co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Repository;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models.ComidaEntity;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models.EnumTipodeComida;
@Repository
public class ComidaRepository {
   private ArrayList<ComidaEntity> listaDeComidas;

	public ComidaRepository() {
		this.listaDeComidas = new ArrayList<ComidaEntity>();
		cargarComidas();
	}

	public List<ComidaEntity> findAll() {
		System.out.println("Invocando a listarComidas");
		return this.listaDeComidas;
	}

	public ComidaEntity findById(String codigo) {
		System.out.println("Invocando a consultar una Comida");
		ComidaEntity objComida = null;

		for (ComidaEntity comida : listaDeComidas) {
			if (comida.getCodigo().equals(codigo)) {
				objComida = comida;
				break;
			}
		}

		return objComida;
	}

	public ComidaEntity save(ComidaEntity comida) {
		System.out.println("Invocando a almacenar Comida");
		ComidaEntity objComida = null;
		if (this.listaDeComidas.add(comida)) {
			objComida = comida;
		}

		return objComida;
	}

	public ComidaEntity update(String codigo, ComidaEntity comida) {
		System.out.println("Invocando a actualizar una Comida");
		ComidaEntity objComida = null;

		for (int i = 0; i < this.listaDeComidas.size(); i++) {
			if (this.listaDeComidas.get(i).getCodigo().equals(codigo)) {
				this.listaDeComidas.set(i, comida);
				objComida = comida;
				break;
			}
		}

		return objComida;
	}

	public boolean delete(String codigo) {
		System.out.println("Invocando a eliminar una Comida");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeComidas.size(); i++) {
			if (this.listaDeComidas.get(i).getCodigo().equals(codigo)) {
				this.listaDeComidas.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}

	private void cargarComidas() {
		ComidaEntity objComida1 = new ComidaEntity("101", "Burguer Nativa", EnumTipodeComida.COMIDA_RAPIDA, "50.000", 5);
		this.listaDeComidas.add(objComida1);
		ComidaEntity objComida2 = new ComidaEntity("102", "Sandwich Nativo", EnumTipodeComida.COMIDA_RAPIDA, "60.000", 7);
		this.listaDeComidas.add(objComida2);
		ComidaEntity objComida3 = new ComidaEntity("103", "Lasagna Nativa", EnumTipodeComida.ESPECIAL, "70.000", 4);
		this.listaDeComidas.add(objComida3);
		ComidaEntity objComida4 = new ComidaEntity("104", "Soda Mistica", EnumTipodeComida.BEBIDAS, "25.000", 5);
		this.listaDeComidas.add(objComida4);
	}
}
