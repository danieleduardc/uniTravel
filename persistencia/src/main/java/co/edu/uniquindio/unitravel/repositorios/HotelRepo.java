package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByNumeroEstrellas(int numeroEstrellas);

    String findByObtenerHotelesCiudad(Integer codigoCiudad);

    List<Hotel> findAllByObtenerHoteles(String nombreCiudad);


}

