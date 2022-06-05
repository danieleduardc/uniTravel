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
    List<Hotel> obtenerHotelesCiudadNombre(String nombreCiudad);

    @Query ("select h.ciudad.nombre, count(h) from Hotel h group by h.ciudad")
    List< Object[] > listarHotelesCiudad();


    @Query("select h from Hotel h where h.comentarios is empty ")
    List<Hotel> hotelesSinComentarios();


    @Query("select h from Hotel h where lower(h.nombre) like concat('%',lower(:nombre),'%')")
    List<Hotel> listarHotelesPorNombre(String nombre);


    @Query("select h, avg(c.calificacion) from Hotel h join h.comentarios c group by h")
    List<Object[]> obtenerCalificacion();

    @Query("select h from Hotel h where h.ciudad.nombre =:nombreCiudad order by h.nombre asc ")
    List<Hotel> listarHotelesPorCiudad(String nombreCiudad);

    @Query("select h from Hotel h join h.habitaciones hh where hh.precio between :precioMin and :precioMax and hh.capacidad <=:capacidad")
    List<Hotel> listaHotelesRangoPrecio(float precioMin, float precioMax, int capacidad);

    @Query ("select h from Hotel h where h.ciudad.codigo = :codigoCiudad")
    List<Hotel> obtenerHotelesCiudad (Integer codigoCiudad);

    @Query("select h from Hotel h where h.numeroEstrellas >=:numeroEstrellas")
    List<Hotel> listarHotelesPorNumeroEstrellas(int numeroEstrellas);


}

