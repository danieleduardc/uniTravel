package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
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
    public Cliente registrarCliente(Cliente cliente)  throws Exception{

        Cliente clienteBuscado = clienteRepo.findById(cliente.getCedula()).orElse(null);

        if(clienteBuscado != null){
            throw new Exception("El cliente ya existe");
        }

        Cliente clienteEmail = clienteRepo.findByEmail(cliente.getEmail()).orElse(null);

        if(clienteEmail != null){
            throw new Exception("Ya existe alguien usando este correo");
        }

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        cliente.setPassword( passwordEncryptor.encryptPassword( cliente.getPassword() ) );

        return clienteRepo.save(cliente);
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
    public Hotel obtenerHotel(String hotel) {
        return obtenerHotel(hotel);
    }

    @Override
    public Reserva registrarReserva(Reserva reserva) throws Exception {

        if(reserva == null){
            throw new Exception("Reserva vacia, verifique la informacion");
        }

        //Revisa que las habitaciones esten disponibles
        if (reserva.getReservaHabitaciones() == null){
            throw new Exception("No hay habitaciones disponibles");
        }
        for (int i = 0; i < reserva.getReservaHabitaciones().size(); i++) {
            ReservaHabitacion habitacion = reserva.getReservaHabitaciones().get(i);

            if(!revisarHabitacionDisponible(habitacion)){
                if (!revisarHabitacionReservadaSegunFecha(reserva, habitacion)) {
                    throw new Exception("La habitacion con codigo: " + habitacion.getCodigo() + ", se encuentra ocupada");
                }
            }
        }
        //Revisa que las sillas esten disponibles
        for (int i = 0; i < reserva.getReservaSillas().size(); i++) {
            ReservaSilla silla = reserva.getReservaSillas().get(i);
            Vuelo vuelo = silla.getSilla().getVuelo();
            if(!sillaDisponible(silla, vuelo)){
                throw new Exception("La silla: " + silla.getCodigo() + ", no esta disponible");
            }
        }

        return reserva;
    }

    private boolean revisarHabitacionDisponible(ReservaHabitacion habitacionActual) {

        List<ReservaHabitacion> habitacionesReservadas = reservaRepo.habitacionesReservadas();
        for(ReservaHabitacion habitacion : habitacionesReservadas){
            if(habitacion.getCodigo() == habitacionActual.getCodigo()){
                return false;
            }
        }
        return true;
    }
    private boolean revisarHabitacionReservadaSegunFecha(Reserva reserva, ReservaHabitacion habitaconA) {

        List<Reserva> reservasSegunFecha = reservaRepo.devolverReservaIntervaloFecha(reserva.getFechaInicio(), reserva.getFechaFin());
        for(Reserva reservas : reservasSegunFecha){
            List<ReservaHabitacion> habitacionesReservadas = reservas.getReservaHabitaciones();
            for(int i = 0; i < habitacionesReservadas.size(); i++) {
                ReservaHabitacion habitacion = habitacionesReservadas.get(i);
                if(habitacion.getCodigo() == habitaconA.getCodigo()){
                    return false;
                }
            }

        }
        return true;
    }

    private boolean sillaDisponible(ReservaSilla sillaReservada, Vuelo vuelo) {

        List<Silla> sillas = vuelo.getSillas();
        for (Silla silla : sillas){
            if(silla.getCodigo() == sillaReservada.getCodigo()){
                if(silla.getEstadoSilla() == EstadoSilla.DISPONIBLE){
                    return true;
                }
            }
        }
        return false;
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

    @Override
    public List<Hotel> listarHoteles() {
        return hotelRepo.findAll();
    }

//    @Override
//    public List<Hotel> ListarHotelsPorCaracteristica(String caracteristica) {
//        return hotelRepo.listarHotelesPorCaracteristica(caracteristica);
//    }

    @Override
    public List<Hotel> obtenerHotelCiudad(int codiogCiudad) {
        return hotelRepo.obtenerHotelesCiudad(codiogCiudad);
    }


}
