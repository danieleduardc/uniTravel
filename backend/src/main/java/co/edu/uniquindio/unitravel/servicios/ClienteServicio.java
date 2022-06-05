package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface ClienteServicio {

        Cliente registrarCliente(Cliente u) throws Exception;

        Cliente actualizarCliente(Cliente u) throws Exception;

        Cliente obtenerCliente(String cedula);

        void eliminarCliente(String cedula) throws Exception;

        List<Cliente> ListarClientes();

        Hotel obtenerHotel(String hotel);

        Reserva registrarReserva(Reserva reserva) throws Exception;

        List<Object[]> listarReservas(String cedula);

        Reserva obtenerReserva(Integer codigo);

        Reserva actualizarReserva(Reserva reserva) throws Exception;

        void eliminarReserva(Integer codigo) throws Exception;

        List<Hotel> buscarHotelesPorNombre(String nombre);


        List<Hotel> BuscarHotelesPorCiudad(String ciudad);

        Comentario registrarComentario(Comentario comentario) throws Exception;

        Comentario actualizarComentario(Comentario comentario) throws Exception;

        Comentario calificarHotel(Comentario comentario) throws Exception;

        void RestablecerPassword(String email) throws Exception;

        List<Habitacion> ListarHabitacionesHotel(String nombreHotel);

        List<Vuelo> ListarVuelosCiudad(String nombreCiudad);

        List<Hotel> listarHoteles();

        List<Hotel> ListarHotelsPorNumeroEstrellas(Integer numero) throws Exception;

        List<Hotel> obtenerHotelCiudad(int codiogCiudad);

}

