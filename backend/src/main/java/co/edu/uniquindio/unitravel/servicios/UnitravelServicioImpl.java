package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Cama;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.CamaRepo;
import co.edu.uniquindio.unitravel.repositorios.CaracteristicaRepo;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Ciudad> ListarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigoCiudad) throws Exception {
        return ciudadRepo.findById(codigoCiudad).orElse(null);
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


}
