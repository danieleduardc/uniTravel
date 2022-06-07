package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.ClienteServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Getter @Setter
    private List<Hotel> hoteles;
    @Getter @Setter
    private List<Hotel> hotelesRecomendados;
    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<AdministradorHotel> administradores;

    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @PostConstruct
    public void inicializar() {
        hoteles = clienteServicio.listarHoteles();
        hotelesRecomendados = clienteServicio.ListarHotelsPorNumeroEstrellas(5);
        ciudades = unitravelServicio.ListarCiudades();
        administradores = unitravelServicio.ListarAdministradores();
    }

    public String irRegistro() {return "registrarCliente?faces-redirect=true"; }

    public String irDetalleHotel(String codigoHotel) {
        return "detalleHotel?faces-redirect=true&amp;hotel_id="+codigoHotel; }


}
