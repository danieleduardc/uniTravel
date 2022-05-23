package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void numeroEstrellas(){
        List<Hotel> hoteles = hotelRepository.findAllByNumeroEstrellas(5);
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar(){
        Hotel hotel = hotelRepository.findById(1).orElse(null);
        System.out.println(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHoteles(){
        List<Hotel> hoteles = hotelRepository.findAll();
        hoteles.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHotelesOrdenSort(){
        List<Hotel> hoteles = hotelRepository.findAll(Sort.by("numeroEstrellas").descending());
        hoteles.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerNombreCiudadCodigo(){
        String  nombreCiudad = hotelRepository.obtenerNombreCiudadCodigo(2);
        System.out.println(nombreCiudad);
        //sirve para correctar el test
        Assertions.assertEquals("Bogota", nombreCiudad);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHotelesCiudad(){
        List<Hotel> hoteles = hotelRepository.obtenerHotelesCiudad("Cali");
        hoteles.forEach(System.out::println);
        Assertions.assertEquals(1, hoteles.size());
    }


}
