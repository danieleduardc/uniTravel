package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Reserva;
import co.edu.uniquindio.unitravel.repositorios.ReservaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void ListarReservas(){
        List<Reserva> reservas = reservaRepository.findAll();
        reservas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ObtenerReservas(){

        LocalDate fecha = LocalDate.of(2022,9,4);

        List<Object[]> reservas = reservaRepository.obtenerReservas(1, fecha);
        reservas.forEach(r -> System.out.println(r[0]+" - "+r[1]+" - "+r[2]));
    }
}
