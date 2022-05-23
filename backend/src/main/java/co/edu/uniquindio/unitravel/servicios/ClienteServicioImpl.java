package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private ClienteRepo clienteRepo;

    private ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Cliente registrarUsuario(Cliente u) throws Exception {
        Cliente buscado = obtenerCliente(u.getCedula());
        if (buscado != null) {
            throw new Exception("El usuario ya existe");
        }

        Cliente clienteEmail = buscarEmail(u.getEmail());
        if (clienteEmail != null) {
            throw new Exception("El email ya existe");
        }

        return clienteRepo.save(u);
    }

    public Cliente buscarEmail(String email) {
        return clienteRepo.findByEmail(email).orElse(null);
    }

    @Override
    public Cliente actualizarusuario(Cliente u) throws Exception {
        Cliente cliente = obtenerCliente(u.getCedula());
        if (cliente == null) {
            throw new Exception("El usuario no existe");
        }
        return clienteRepo.save(u);
    }

    @Override
    public Cliente obtenerCliente(String cedula) {
        return clienteRepo.findById(cedula).orElse(null);
    }

    @Override
    public void eliminarusuario(String cedula) throws Exception {
        Cliente cliente = obtenerCliente(cedula);

        if (cliente == null) {
            throw new Exception("El usuario no existe");
        }
        clienteRepo.delete(cliente);
    }

    @Override
    public List<Cliente> listarusuarios() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente validarLogin(String email, String password) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findByEmailAndPassword(email, password);

        if (cliente.isEmpty()) {
            throw new Exception("los datos son incorrectos");
        }
        return null;
    }

}
