package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Habitacion;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import co.edu.uniquindio.unitravel.repositorios.HabitacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImpl implements  AdministradorHotelServicio {

    @Autowired
    private AdminHotelRepo adminHotelRepo;
    private HabitacionRepo habitacionRepo;

    @Override
    public AdministradorHotel validarLoginHotel(String email, String password) throws Exception {
        return null;
    }

    @Override
    public Hotel crearHotel(Hotel hotel) throws Exception {
        return null;
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
}
