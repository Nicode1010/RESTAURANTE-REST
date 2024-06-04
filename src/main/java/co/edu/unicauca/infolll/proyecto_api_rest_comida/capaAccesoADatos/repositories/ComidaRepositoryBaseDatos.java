package co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models.ComidaEntity;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.models.EnumTipodeComida;
import co.edu.unicauca.infolll.proyecto_api_rest_comida.capaAccesoADatos.repositories.conexion.ConexionBD;

@Repository
public class ComidaRepositoryBaseDatos {
    private final ConexionBD conexionABaseDeDatos;

    public ComidaRepositoryBaseDatos() {
        conexionABaseDeDatos = new ConexionBD();
    }

    public ComidaEntity save(ComidaEntity objComida) {
        System.out.println("Registrando comida");
        ComidaEntity objComidaAlmacenado = null;
        int resultado = -1;

        try {
            conexionABaseDeDatos.conectar();

            PreparedStatement sentencia = null;
            String consulta = "INSERT INTO comidas (nombre, tipo, precio, cantidad_ingredientes) VALUES (?, ?, ?, ?)";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            sentencia.setString(1, objComida.getNombre());
            sentencia.setString(2, objComida.getTipo().toString());
            sentencia.setString(3, objComida.getPrecio());
            sentencia.setInt(4, objComida.getCantidadIngredientes());

            resultado = sentencia.executeUpdate();
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la inserción: " + e.getMessage());
        }

        if (resultado == 1) {
            objComidaAlmacenado = objComida;
        }
        return objComidaAlmacenado;
    }

    public List<ComidaEntity> findAll() {
        System.out.println("Listando comidas");
        LinkedList<ComidaEntity> comidas = new LinkedList<ComidaEntity>();

        conexionABaseDeDatos.conectar();
        try {
            PreparedStatement sentencia = null;
            String consulta = "SELECT * FROM comidas";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                ComidaEntity objComida = new ComidaEntity();
                objComida.setIdComida(res.getInt("idComida"));
                objComida.setNombre(res.getString("nombre"));
                objComida.setTipo(EnumTipodeComida.valueOf(res.getString("tipo")));
                objComida.setPrecio(res.getString("precio"));
                objComida.setCantidadIngredientes(res.getInt("cantidad_ingredientes"));
                comidas.add(objComida);
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la inserción: " + e.getMessage());
        }

        return comidas;
    }

    public ComidaEntity findById(Integer idComida) {
        System.out.println("Consultando comida");
        ComidaEntity objComida = null;

        conexionABaseDeDatos.conectar();
        try {
            PreparedStatement sentencia = null;
            String consulta = "SELECT * FROM comidas WHERE idComida=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            sentencia.setInt(1, idComida);
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                objComida = new ComidaEntity();
                objComida.setIdComida(res.getInt("idComida"));
                objComida.setNombre(res.getString("nombre"));
                objComida.setTipo(EnumTipodeComida.valueOf(res.getString("tipo")));
                objComida.setPrecio(res.getString("precio"));
                objComida.setCantidadIngredientes(res.getInt("cantidad_ingredientes"));
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la consulta de una comida: " + e.getMessage());
        }

        return objComida;
    }

    public boolean findByNombre(String nombre) {
        System.out.println("Consultando comida por nombre");
        boolean bandera = false;

        conexionABaseDeDatos.conectar();
        try {
            PreparedStatement sentencia = null;
            String consulta = "SELECT * FROM comidas WHERE nombre=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            sentencia.setString(1, nombre);
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                bandera = true;
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la consulta de una comida: " + e.getMessage());
        }

        return bandera;
    }

    public ComidaEntity update(Integer idComida, ComidaEntity objComida) {
        System.out.println("Actualizando comida");
        ComidaEntity objComidaActualizado = null;
        conexionABaseDeDatos.conectar();
        int resultado = -1;
        try {
            PreparedStatement sentencia = null;
            String consulta = "UPDATE comidas SET nombre=?, tipo=?, precio=?, cantidad_ingredientes=? WHERE idComida=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);

            sentencia.setString(1, objComida.getNombre());
            sentencia.setString(2, objComida.getTipo().toString());
            sentencia.setString(3, objComida.getPrecio());
            sentencia.setInt(4, objComida.getCantidadIngredientes());
            sentencia.setInt(5, idComida);
            
            resultado = sentencia.executeUpdate();
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la actualización: " + e.getMessage());
        }

        if (resultado == 1) {
            objComidaActualizado = objComida;
        }
        return objComidaActualizado;
    }

    public boolean delete(Integer idComida) {
        System.out.println("Eliminando comida");
        conexionABaseDeDatos.conectar();
        int resultado = -1;
        try {
            PreparedStatement sentencia = null;
            String consulta = "DELETE FROM comidas WHERE idComida=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            sentencia.setInt(1, idComida);
            resultado = sentencia.executeUpdate();
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la eliminación: " + e.getMessage());
        }

        return resultado == 1;
    }
}