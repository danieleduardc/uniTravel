package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.*;
import co.edu.uniquindio.unitravel.repositorios.*;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UnitravelServicioImpl implements UnitravelServicio {

    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private CaracteristicaRepo caracteristicaRepo;
    @Autowired
    private CamaRepo camaRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private ComentarioRepo comentarioRepo;

    @Autowired
    private AdminHotelRepo adminHotelRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public List<Ciudad> ListarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigoCiudad) throws Exception {
        return ciudadRepo.findById(codigoCiudad).orElse(null);
    }

    @Override
    public Caracteristica obtenerCaracteristicaPorId(Integer id) throws Exception {
        return caracteristicaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHotel() {
        return caracteristicaRepo.findAllByTipo("1");
    }

    @Override
    public List<Caracteristica> listarCaracteristicasHabitacion() {
        return caracteristicaRepo.findAllByTipo("2");
    }

    @Override
    public Cama obtenerCamaId(int id) throws Exception {
        return camaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Cama> listarCamas() {
        return camaRepo.findAll();
    }

    @Override
    public Hotel obtenerHotel(Integer codigoHotel) throws Exception {
        return hotelRepo.findById(codigoHotel).orElseThrow(() -> new Exception("Hotel no encontrado"));

    }

    @Override
    public void crearComentario(Comentario comentario) throws Exception {
        comentario.setFechaCalificacion(LocalDateTime.now());
        comentarioRepo.save(comentario);
    }

    @Override
    public Persona validarLogin(String correo, String password) throws Exception {

        try {
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            Persona cliente = clienteRepo.findByEmail(correo).orElse(null);

            if (cliente == null) {
                cliente = adminHotelRepo.findByEmail(correo).orElse(null);
            } else {
                if (!passwordEncryptor.checkPassword(password, cliente.getPassword())) {
                    throw new Exception("Contraseña incorrecta");
                } else {
                    return cliente;
                }
            }

            if (cliente == null) {
                cliente = adminRepo.findByEmail(correo).orElse(null);
            } else {
                if (!passwordEncryptor.checkPassword(password, cliente.getPassword())) {
                    throw new Exception("Contraseña incorrecta");
                } else {
                    return cliente;
                }
            }

            if (cliente == null) {
                throw new Exception("El correo o la contraseña son incorrectos");
            } else {
                if (!passwordEncryptor.checkPassword(password, cliente.getPassword())) {
                    throw new Exception("Contraseña incorrecta");
                } else {
                    return cliente;
                }
            }
        } catch (EncryptionOperationNotPossibleException e) {
            throw new Exception("Contraseña es incorrecta");

        }
    }

    @Override
    public List<AdministradorHotel> ListarAdministradores() {
        return adminHotelRepo.findAll();
    }



}
