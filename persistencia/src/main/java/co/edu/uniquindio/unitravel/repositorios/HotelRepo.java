package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByNumeroEstrellas(int numeroEstrellas);

    @Query("select h.ciudad.nombre from Hotel h where h.codigo =:codigo")
    String obtenerNombreCiudadCodigo(Integer codigo);

    @Query ("select h from Hotel h where h.ciudad.nombre =:nombreCiudad")
    List<Hotel> obtenerHotelesCiudad(String nombreCiudad);




}

