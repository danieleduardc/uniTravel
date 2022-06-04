package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.entidades.ReservaHabitacion;
import co.edu.uniquindio.unitravel.entidades.dto.ReservaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    @Query("select r.cliente.nombre, r.fechaReserva, h.habitacion from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio < :fecha")
    List<Object[]> obtenerReservas(Integer codigoHotel, LocalDate fecha);

    @Query ("select count(r) from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio >= current_date ")
    Integer obtenerCantidadReservas(Integer codigoHotel);

    @Query("select r.codigo, ( select sum(rh.precio) from ReservaHabitacion rh where rh.reserva = r group by r), ( select sum(rs.precio) from ReservaSilla rs where rs.reserva = r group by r) from Reserva r where r.cliente.cedula = :cedula")
    List<Object[]> obtenerTotalReservasPorCliente(String cedula);

    @Query("select r.reservaHabitaciones from Reserva r")
    List<ReservaHabitacion> habitacionesReservadas();


    @Query("select r, rh ,rs from Reserva r join r.reservaHabitaciones rh left join r.reservaSillas rs where r.cliente.cedula = :cedula")
    List<Object[]> detallarReservasPorCliente(String cedula);

    @Query("select r, rh ,rs from Reserva r join r.reservaHabitaciones rh left join r.reservaSillas rs where r.cliente.email = :email")
    List<Object[]> obtenerReservaClienteEmail(String email);

    @Query("select r from Reserva r where r.fechaInicio >= :fechaMin and r.fechaFin <= :fechaMax")
    List<Reserva> devolverReservaIntervaloFecha(@NotBlank(message = "la fecha no puede estar vacia formato(aa/mm/dd)") LocalDateTime fechaMin, @Future @NotBlank(message = "la fecha no puede estar vacia formato(aa/mm/dd)") LocalDateTime fechaMax);

    @Query("select r.cliente.nombre, r.fechaReserva, h.habitacion from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo = :id and r.fechaInicio < :fecha")
    List<Object[]> obtenerReserva(Integer id, Date fecha);


    @Query("select count(r) from Reserva r join r.reservaHabitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio > current_date ")
    int obtenerNumeroDeReserva(Integer codigoHotel);

    @Query("select r.codigo ,r.cliente.nombre, r.precioTotal from Reserva r where r.cliente.cedula  = :codigoUsuario")
    List<Object[]> obtenerTotalPorReserva(String codigoUsuario);

    //Punto ocho taller
    @Query("select  r, h, s from Reserva r join r.reservaHabitaciones h left join r.reservaSillas s where r.cliente.cedula = :codigo")
    List<Object[]> obtenerDetalleDeCadaReserva(String codigo);

}
