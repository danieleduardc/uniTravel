package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    @Query("select r.cliente.nombre, r.fechaReserva, h.habitacion from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio < :fecha")
    List<Object[]> obtenerReservas(Integer codigoHotel, LocalDate fecha);

    @Query ("select count(r) from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio >= current_date ")
    Integer obtenerCantidadReservas(Integer codigoHotel);

    @Query("select r.codigo, ( select sum(rh.precio) from ReservaHabitacion rh where rh.reserva = r group by r), ( select sum(rs.precio) from ReservaSilla rs where rs.reserva = r group by r) from Reserva r where r.cliente.cedula = :cedula")
    List<Object[]> obtenerTotalReservasPorCliente(String cedula);


    @Query("select r, rh ,rs from Reserva r join r.reservaHabitaciones rh left join r.reservaSillas rs where r.cliente.cedula = :cedula")
    List<Object[]> deatallarReservasPorCliente(String cedula);
}
