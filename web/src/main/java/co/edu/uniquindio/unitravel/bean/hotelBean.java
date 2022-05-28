package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Caracteristica;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import co.edu.uniquindio.unitravel.servicios.UnitravelServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class hotelBean implements Serializable {

    @Getter
    @Setter
    private Hotel hotel;

    @Value("${upload.url}")
    private String urlImagenes;

    private ArrayList<String> imagenes;

    @Getter @Setter
    private List<Ciudad> ciudades;
    @Getter @Setter
    private List<Caracteristica> caracteristicas;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @PostConstruct
    public void init() {
        hotel = new Hotel();
        imagenes = new ArrayList<>();
        ciudades = unitravelServicio.ListarCiudades();
        caracteristicas = unitravelServicio.listarCaracteristicasHotel();
    }

    public String RegistrarHotel() {
        try {
            hotel.setFotos(imagenes);

            if (imagenes.size() > 0) {

                AdministradorHotel administradorHotel = administradorHotelServicio.obtenerAdministrador("111");

                hotel.setAdministradorHotel(administradorHotel);

                administradorHotelServicio.crearHotel(hotel);
                return "registroExitoso?faces-redirect=true";
//            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel Creado Correctamente");
//            FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Debe subir al menos una imagen");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            }
        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msj);
            throw new RuntimeException(e);
        }
        return null;
    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenes.add(nombreImagen);
        }
    }

    private String subirImagen(UploadedFile imagen) {
        try {
            File file = new File(urlImagenes + "/" + imagen.getFileName());
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(imagen.getInputStream(), outputStream);
            return imagen.getFileName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
