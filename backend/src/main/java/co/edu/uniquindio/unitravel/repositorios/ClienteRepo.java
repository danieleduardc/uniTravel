package co.edu.uniquindio.unitravel.repositorios;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    List<Cliente> findAllByNombre(String nombre);

    Optional<Cliente> findByEmailAndPassword(String email, String password);

    Page<Cliente> findAll(Pageable pageable);

    Optional<Cliente> findByEmail(String email);

    @Query("select r from Cliente c, IN (c.reservas) r where c.email = :email")
    List<Reserva> obternerReservas(String email);

    @Query("select c.email, c.comentarios from Cliente c left join c.comentarios co")
    List<Object[]> obtenerComentarios();

    @Query("select c,r from Cliente c left join c.reservas r")
    List<Object[]> obtenerReservas();

    @Query("select c from Cliente c join c.telefonos t where t = :numTelefono")
     List<Cliente> obtenerClienteTelefono(String numTelefono);

    @Query("select distinct t from Cliente c left join c.telefonos t")
    List<String> obtenerTelefonos();
}
