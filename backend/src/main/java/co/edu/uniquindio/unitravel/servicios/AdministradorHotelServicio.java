package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.entidades.Vuelo;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel validarLoginHotel(String email, String password) throws Exception;

    Hotel crearHotel(Hotel hotel) throws Exception;

    void eliminarHotel(Hotel hotel) throws Exception;

    List<Hotel> listarHoteles(String CodigoAdmin) throws Exception;

    Hotel actualizarHotel(Hotel hotel) throws Exception;

    Hotel consultarHotel(Integer codigoHotel) throws Exception;



}
