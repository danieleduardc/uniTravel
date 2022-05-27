package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import co.edu.uniquindio.unitravel.repositorios.ComentarioRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private ClienteRepo clienteRepo;
    private ComentarioRepo comentarioRepo;
    private ReservaRepo reservaRepo;
    private HotelRepo hotelRepo;
    private EmailServices emailServices;

    private ClienteServicioImpl(ClienteRepo clienteRepo, ComentarioRepo comentarioRepo, ReservaRepo reservaRepo,
                                HotelRepo hotelRepo, EmailServices emailServices) {
        this.clienteRepo = clienteRepo;
        this.comentarioRepo = comentarioRepo;
        this.reservaRepo = reservaRepo;
        this.hotelRepo = hotelRepo;
        this.emailServices = emailServices;
    }

    @Override
    public Cliente registrarCliente(Cliente u) throws Exception {
        Cliente buscado = obtenerCliente(u.getCedula());
        if (buscado != null) {
            throw new Exception("El usuario ya existe");
        }

        Cliente clienteEmail = buscarEmail(u.getEmail());
        if (clienteEmail != null) {
            throw new Exception("El email ya esta registrado");
        }

        return clienteRepo.save(u);
    }

    public Cliente buscarEmail(String email) {
        return clienteRepo.findByEmail(email).orElse(null);
    }

    @Override
    public Cliente actualizarCliente(Cliente u) throws Exception {
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
    public void eliminarCliente(String cedula) throws Exception {
        Cliente cliente = obtenerCliente(cedula);

        if (cliente == null) {
            throw new Exception("El usuario no existe");
        }
        clienteRepo.delete(cliente);
    }

    @Override
    public List<Cliente> ListarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente validarLogin(String email, String password) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findByEmailAndPassword(email, password);

        if (cliente.isEmpty()) {
            throw new Exception("los datos son incorrectos");
        }
        return cliente.get();
    }

    @Override
    public Hotel obtenerHotel(String hotel) {
        return obtenerHotel(hotel);
    }

    @Override
    public Reserva registrarReserva(Reserva reserva) throws Exception {

        List<ReservaHabitacion> habitaciones = reserva.getReservaHabitaciones();

        for(ReservaHabitacion rh:habitaciones){
            // Validar que las habitaciones estén disponibles
        }
            // Validar disponibilidad de los vuelos,aignar la silla aleatoriamente

        return reservaRepo.save(reserva);
    }

    @Override
    public List<Object[]> listarReservas(String emailCliente) {
        return reservaRepo.obtenerReservaClienteEmail(emailCliente);
    }

    @Override
    public Reserva obtenerReserva(Integer codigo) {
        return obtenerReserva(codigo);
    }

    @Override
    public Reserva actualizarReserva(Reserva r) throws Exception {
        Reserva reserva = obtenerReserva(r.getCodigo());
        if (reserva == null) {
            throw new Exception("la reserva no existe");
        }
        return reservaRepo.save(r);
    }

    @Override
    public void eliminarReserva(Integer codigo) throws Exception {

        Optional<Reserva> reserva = reservaRepo.findById(codigo);

        if(reserva.isEmpty()){
            throw new Exception("La reserva no existe");
        }
    }

    @Override
    public List<Hotel> buscarHotelesPorNombre(String nombre) {
        return hotelRepo.listarHotelesPorNombre(nombre);
    }

    @Override
    public List<Hotel> BuscarHotelesPorCiudad(String ciudad) {
        return hotelRepo.listarHotelesPorCiudad(ciudad);
    }



    @Override
    public Comentario registrarComentario(Comentario comentario) throws Exception {

        if (comentario.getCliente() == null) {
            throw new Exception("El cliente no existe");
        }
        return comentarioRepo.save(comentario);
    }

    @Override
    public Comentario actualizarComentario(Comentario comentario) throws Exception {
        Comentario comentarioActual = obtenerComentario(comentario.getCodigo());
        return comentarioRepo.save(comentario);
    }

    private Comentario obtenerComentario(int codigo) {
        return obtenerComentario(codigo);
    }

    @Override
    public Comentario calificarHotel(Comentario comentario) throws Exception {
        return null;
    }

    @Override
    public void RestablecerPassword(String email) throws Exception {

        Optional<Cliente> cliente = clienteRepo.findByEmail(email);
        if (cliente.isEmpty()) {
            throw new Exception("El correo no pertenece a ningun cliente");
        }

        String password = cliente.get().getPassword();
        emailServices.enviarEmail(email, "Restablecer contraseña", "Su contraseña es: " + password);


    }

    @Override
    public List<Habitacion> ListarHabitacionesHotel(String nombreHotel) {
        return null;
    }

    @Override
    public List<Vuelo> ListarVuelosCiudad(String nombreCiudad) {
        return null;
    }

}
