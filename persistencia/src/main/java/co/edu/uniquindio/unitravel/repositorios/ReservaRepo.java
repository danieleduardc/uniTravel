package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.dto.ReservaDTO;
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



}
