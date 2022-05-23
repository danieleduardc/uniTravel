package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import java.util.List;

public interface ClienteServicio {

        Cliente registrarUsuario(Cliente u )throws Exception;

        Cliente actualizarusuario(Cliente u )throws Exception;

        Cliente obtenerCliente (String cedula);

        void eliminarusuario(String cedula)throws Exception;

        List<Cliente> listarusuarios();

        Cliente validarLogin(String email, String password)throws Exception;


}
