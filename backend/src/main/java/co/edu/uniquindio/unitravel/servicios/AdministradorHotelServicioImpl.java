package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import co.edu.uniquindio.unitravel.repositorios.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImpl implements  AdministradorHotelServicio {

    @Autowired
    private AdminHotelRepo adminHotelRepo;
    @Autowired
    private HabitacionRepo habitacionRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public AdministradorHotel validarLoginHotel(String email, String password) throws Exception {
        return null;
    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {
        return hotelRepo.save(hotel);
    }

    @Override
    public void eliminarHotel(Hotel hotel) throws Exception {

    }

    @Override
    public List<Hotel> listarHoteles(String CodigoAdmin) throws Exception {
        return adminHotelRepo.obtenerHotelesPorAdmin(CodigoAdmin);
    }

    @Override
    public Hotel actualizarHotel(Hotel hotel) throws Exception {
        return null;
    }

    @Override
    public Habitacion obtenerHabitacion(String numero) {
        return null;
    }


    @Override
    public Hotel consultarHotel(Integer codigoHotel) throws Exception {
        return null;
    }

    @Override
    public Habitacion crearHabitacion(Habitacion habitacion) throws Exception {
        return habitacionRepo.save(habitacion);
    }

    @Override
    public void eliminarHabitacion(Habitacion habitacion) throws Exception {
        Optional<Habitacion> habi = habitacionRepo.findById(habitacion.getNumero());
    }

    @Override
    public List<Habitacion> listarHabitaciones(Integer codigoHotel) throws Exception {
        return habitacionRepo.listarhabitacionesHotel(codigoHotel);
    }

    @Override
    public Hotel obtenerHotel(Integer codigoHotel) throws Exception {
        return null;
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigoCiudad) throws Exception {
        return ciudadRepo.findById(codigoCiudad).orElse(null);
    }

    @Override
    public AdministradorHotel obtenerAdministrador(String codigoAdmin) throws Exception {
        return adminHotelRepo.findById(codigoAdmin).orElse(null);
    }
}
