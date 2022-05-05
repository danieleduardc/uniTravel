package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.entidades.Comentario;
import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepository;

    @Test
    public void registrarClienteTest() {
        Cliente cliente = new Cliente("111", "Juanita@gmail.com", "junita", "123");
        Cliente guardado = clienteRepository.save(cliente);
        Assertions.assertNotNull(guardado);
    }

    @Test
    public void actualizarClienteTest() {
        Cliente cliente = new Cliente("111", "Juanita@gmail.com", "junita", "123");

        Cliente clienteRegistrado = clienteRepository.save(cliente);
        clienteRegistrado.setNombre("Juanita Lopez");

        clienteRepository.save(clienteRegistrado);

        Cliente buscarCliente = clienteRepository.findById("111").orElse(null);
        Assertions.assertEquals("Juanita Lopez", buscarCliente.getNombre());

    }

    @Test
    public void eliminarClienteTest() {
        Cliente cliente = new Cliente("111", "Juanita@gmail.com", "junita", "123");
        Cliente clienteRegistrado = clienteRepository.save(cliente);

        clienteRepository.delete(clienteRegistrado);

        Cliente buscarCliente = clienteRepository.findById("111").orElse(null);
        Assertions.assertNull(buscarCliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ListarClientesTest(){
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarNombreClientes(){
        List<Cliente> clientesNombre = clienteRepository.findAllByNombre("luisa");
        clientesNombre.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void AutentificarCliente() {
        Optional<Cliente> cliente = clienteRepository.findByEmailAndPassword("julia@gmail.com", "qwe1");
        System.out.println(cliente.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesPaginacion() {
        Page<Cliente> clientes = clienteRepository.findAll(PageRequest.of(0, 2));
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarOrdenClientesSort() {
        List<Cliente> clientes = clienteRepository.findAll(Sort.by("nombre"));
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReserva() {
        List<Reserva> reservas = clienteRepository.obternerReservas("julia@gmail.com");
        reservas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentarios() {
        List<Object[]> comentarios = clienteRepository.obtenerComentarios();
        comentarios.forEach(comentario -> System.out.println(comentario[0] + " -- " + comentario[1]));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservas() {
        List<Object[]> clientes = clienteRepository.obtenerReservas();
        clientes.forEach(cliente -> System.out.println(cliente[0] + " -- " + cliente[1]));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTelefonos() {
        List<Cliente> clientes = clienteRepository.obtenerClienteTelefono("1234567");
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodosTelefonos() {
        List<String> telefonos = clienteRepository.obtenerTelefonos();
        telefonos.forEach(System.out::println);
    }
}
