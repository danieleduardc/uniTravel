package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.repositorios.AdminHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorHotelServicioImpl implements  AdministradorHotelServicio {

    @Autowired
    private AdminHotelRepo adminHotelRepo;

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
    public Hotel consultarHotel(Integer codigoHotel) throws Exception {
        return null;
    }
}
