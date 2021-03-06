package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;

import java.util.List;

public interface UnitravelServicio {
    List<Ciudad> ListarCiudades();

    Ciudad obtenerCiudad(Integer codigoCiudad) throws Exception;

    Caracteristica obtenerCaracteristicaPorId(Integer id) throws Exception;

    List<Caracteristica> listarCaracteristicasHotel();

    List<Caracteristica> listarCaracteristicasHabitacion();

    Cama obtenerCamaId(int parseInt) throws Exception;

    List<Cama> listarCamas();

    Hotel obtenerHotel(Integer codigoHotel) throws Exception;

    void crearComentario(Comentario comentario) throws Exception;

    Persona validarLogin(String correo, String password) throws Exception;

    List<AdministradorHotel> ListarAdministradores();

}
