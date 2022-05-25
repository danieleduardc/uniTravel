package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Vuelo;

public interface AdministradorServicio {

    AdministradorHotel registroAdministradorHote(AdministradorHotel admin) throws Exception;

    Vuelo crearVuelo(Vuelo vuelo) throws Exception;

    Ciudad crearCiudad(Ciudad ciudad) throws Exception;

    Ciudad buscarCiudad(String nombreCiudad) throws Exception;



}
