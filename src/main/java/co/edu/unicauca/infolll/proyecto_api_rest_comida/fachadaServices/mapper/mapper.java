package co.edu.unicauca.infolll.proyecto_api_rest_comida.fachadaServices.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    @Bean
    public ModelMapper generarMapeador() {
        System.out.println("invocando método automáticamente");
        ModelMapper objMapeador = new ModelMapper();
        return objMapeador;
    }
}