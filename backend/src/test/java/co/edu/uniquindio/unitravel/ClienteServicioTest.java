package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Test
    @Sql({"classpath:dataset.sql"})
    public void registrarClienteTest() {
        Cliente u = new Cliente("1234", "juanito", "juan@gmail.com", "0000");

        List<String> telefonos = new ArrayList();
        telefonos.add("3123123");
        telefonos.add("3123123");

        u.setTelefonos(telefonos);


        try {
            Cliente guardado = clienteServicio.registrarCliente(u);
            Assertions.assertNotNull(guardado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void actualizarClienteTest() {
        Cliente cliente = clienteServicio.obtenerCliente("123");
        cliente.setPassword("0000");

        try {
            Cliente actualizado = clienteServicio.actualizarCliente(cliente);
            Assertions.assertEquals("0000", actualizado.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void eliminarClienteTest() {

        try {
            clienteServicio.eliminarCliente("1234");
            Cliente eliminado = clienteServicio.obtenerCliente("123");
            Assertions.assertNull(eliminado);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    @Sql({"classpath:dataset.sql"})
    public void listarCliente() {
        List<Cliente> lista = clienteServicio.ListarClientes();
        lista.forEach(System.out::println);
    }


    @Test
    @Sql({"classpath:dataset.sql"})
    public void loginUsuarioTest() {
        Cliente cliente = null;
        try {
            cliente = clienteServicio.validarLogin("julia@gmail.com", "qwe1");
            Assertions.assertNotNull(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
