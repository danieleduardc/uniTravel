package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Getter @Setter
    private List<Hotel> hoteles;
    @Getter @Setter
    private List<Ciudad> ciudades;

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @PostConstruct
    public void inicializar() {
        hoteles = clienteServicio.listarHoteles();
        ciudades = unitravelServicio.ListarCiudades();
    }

    public String irRegistro() {return "registrarCliente?faces-redirect=true"; }

    public String irDetalleHotel(String codigoHotel) {
        return "detalleHotel?faces-redirect=true&amp;hotel_id="+codigoHotel; }

}
