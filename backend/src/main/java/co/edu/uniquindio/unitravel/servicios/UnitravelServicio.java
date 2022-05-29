package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;

import java.util.List;

public interface UnitravelServicio {

    List<Ciudad> ListarCiudades();

    Ciudad obtenerCiudad(Integer codigoCiudad) throws Exception;

    Cliente validarLogin(String email, String password)throws Exception;

    Caracteristica obtenerCaracteristicaPorId(Integer id) throws Exception;

    List<Caracteristica> listarCaracteristicasHotel();

    List<Caracteristica> listarCaracteristicasHabitacion();

    Cama obtenerCamaId(int parseInt) throws Exception;

    List<Cama> listarCamas();



}
