package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel validarLoginHotel(String email, String password) throws Exception;

    Hotel crearHotel(Hotel hotel) throws Exception;

    void eliminarHotel(Hotel hotel) throws Exception;

    List<Hotel> listarHotelesAdministrador(String CodigoAdmin) throws Exception;

    Hotel actualizarHotel(Hotel hotel) throws Exception;

    Habitacion obtenerHabitacion(String numero);

    Hotel consultarHotel(Integer codigoHotel) throws Exception;

    Habitacion crearHabitacion(Habitacion habitacion) throws Exception;

    void eliminarHabitacion(Habitacion habitacion) throws Exception;

    List<Habitacion> listarHabitaciones(Integer codigoHotel) throws Exception;

    Hotel obtenerHotel(Integer codigoHotel) throws Exception;

    Ciudad obtenerCiudad(Integer codigoCiudad)throws Exception;

    AdministradorHotel obtenerAdministrador(String codigoAdmin) throws Exception;

    List<Ciudad> ListarCiudades();
}
