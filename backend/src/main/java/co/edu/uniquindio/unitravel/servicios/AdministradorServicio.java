package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

public interface AdministradorServicio {

    Administrador validarLogin(String email, String password)throws Exception;

    Ciudad crearCiudad(Ciudad ciudad) throws Exception;

    Ciudad actualizarCiudad(Ciudad ciudad) throws Exception;

    void eliminarCiudad(Ciudad ciudad) throws Exception;

    Ciudad buscarCiudad(String nombreCiudad) throws Exception;

    Vuelo crearVuelo(Vuelo vuelo, Silla silla) throws Exception;

    void eliminarVuelo(Vuelo vuelo) throws Exception;

    Vuelo actualizarVuelo(Vuelo vuelo) throws Exception;

    Vuelo consultarVuelo(String codigoVuelo) throws Exception;

    AdministradorHotel registroAdministradorHote(AdministradorHotel admin) throws Exception;

    AdministradorHotel actualizarAdministradorHotel(AdministradorHotel admin) throws Exception;

    AdministradorHotel consultarAdministradorHotel(String email) throws Exception;

    void eliminarAdministradorHotel(AdministradorHotel admin) throws Exception;


}
