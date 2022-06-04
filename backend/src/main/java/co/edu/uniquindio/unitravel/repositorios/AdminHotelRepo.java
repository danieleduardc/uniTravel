package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminHotelRepo extends JpaRepository<AdministradorHotel, String> {

    Optional<AdministradorHotel> findByEmailAndPassword(String email, String password);

    @Query("select h from Hotel h where h.administradorHotel.cedula = :cedulaAdmin")
    List<Hotel> obtenerHotelesPorAdmin(String cedulaAdmin);

    Optional<AdministradorHotel> findByEmail(String correo);

    Optional<AdministradorHotel> findByCedula(String cedula);

    @Query("select ha from Hotel ho join ho.habitaciones ha where ho.codigo= :codigoHotel and ha.numero= :numeroHabitacion")
    Habitacion obtenerHabitacion(Integer numeroHabitacion, Integer codigoHotel);

    @Query("select ho.habitaciones from Hotel ho where ho.codigo = :codigoHotel")
    List<Habitacion> listarHabitacionesHotel(Integer codigoHotel);
}
