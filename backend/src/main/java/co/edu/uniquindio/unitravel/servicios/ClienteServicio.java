package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface ClienteServicio {

        Cliente registrarCliente(Cliente u )throws Exception;

        Cliente actualizarCliente(Cliente u )throws Exception;

        Cliente obtenerCliente (String cedula);

        void eliminarCliente(String cedula)throws Exception;

        List<Cliente> ListarClientes();

        Cliente validarLogin(String email, String password)throws Exception;

        Comentario registrarComentario(Comentario comentario)throws Exception;

        Reserva registrarReserva(Reserva reserva, Vuelo vuelos, Habitacion habitacion)throws Exception;

        List<Hotel> ListarHotelesCiudad(String nombreCiudad);

        List<Habitacion> ListarHabitacionesHotel(String nombreHotel);

        List<Vuelo> ListarVuelosCiudad(String nombreCiudad);

        




}
