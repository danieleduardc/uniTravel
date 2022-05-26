package co.edu.uniquindio.unitravel.servicios;


import co.edu.uniquindio.unitravel.entidades.*;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImpl implements AdministradorServicio {
    @Override
    public Administrador validarLogin(String email, String password) throws Exception {
        return null;
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {
        return null;
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        return null;
    }

    @Override
    public void eliminarCiudad(Ciudad ciudad) throws Exception {

    }

    @Override
    public Ciudad buscarCiudad(String nombreCiudad) throws Exception {
        return null;
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo, Silla silla) throws Exception {
        return null;
    }

    @Override
    public void eliminarVuelo(Vuelo vuelo) throws Exception {

    }

    @Override
    public Vuelo actualizarVuelo(Vuelo vuelo) throws Exception {
        return null;
    }

    @Override
    public Vuelo consultarVuelo(String codigoVuelo) throws Exception {
        return null;
    }

    @Override
    public AdministradorHotel registroAdministradorHote(AdministradorHotel admin) throws Exception {
        return null;
    }

    @Override
    public AdministradorHotel actualizarAdministradorHotel(AdministradorHotel admin) throws Exception {
        return null;
    }

    @Override
    public AdministradorHotel consultarAdministradorHotel(String email) throws Exception {
        return null;
    }

    @Override
    public void eliminarAdministradorHotel(AdministradorHotel admin) throws Exception {

    }
}
