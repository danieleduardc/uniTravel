package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Hotel;

public interface AdministradorHotelServicio {

    Hotel crearHotel(Hotel hotel) throws Exception;

    void eliminarHotel(Hotel hotel) throws Exception;

    Hotel actualizarHotel(Hotel hotel) throws Exception;

    Hotel consultarHotel(Hotel hotel) throws Exception;
}
