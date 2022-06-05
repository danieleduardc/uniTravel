package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.*;
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

    @Getter @Setter
    private Hotel hotel;
    @Getter @Setter
    private Habitacion habitacion;
    @Setter @Getter
    private List<Cama> camas;
    @Value("${upload.url}")
    private String urlImagenes;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<String> imagenesHabitacion;
    private ArrayList<String> imagenesHotel;
    @Getter @Setter
    private List<Ciudad> ciudades;
    @Getter @Setter
    private List<Caracteristica> caracteristicasHotel;
    @Getter @Setter
    private List<Caracteristica> caracteristicasHabitacion;
    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;
    @Autowired
    private UnitravelServicio unitravelServicio;

    @Value(value = "#{seguridadBean.persona}")
    private Persona personaSesion;

    @PostConstruct
    public void init() {
        hotel = new Hotel();
        imagenesHotel = new ArrayList<>();
        habitacion = new Habitacion();
        habitaciones = new ArrayList<>();
        imagenesHabitacion = new ArrayList<>();
        ciudades = unitravelServicio.ListarCiudades();
        caracteristicasHotel = unitravelServicio.listarCaracteristicasHotel();
        caracteristicasHabitacion = unitravelServicio.listarCaracteristicasHabitacion();
        camas = unitravelServicio.listarCamas();
    }


    public String registrarHotel(){
        try {

            if(personaSesion != null) {

                if (imagenesHotel.size() > 0) {

                    if (habitaciones.size() > 0) {

                        hotel.setAdministradorHotel((AdministradorHotel) personaSesion);
                        hotel.setFotos(imagenesHotel);

                        Hotel h = administradorHotelServicio.crearHotel(hotel);

                        habitaciones.forEach(hab -> {

                            hab.setHotel(h);
                            try {
                                administradorHotelServicio.crearHabitacion(hab);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });

                        return "/admin_hotel/registroExitoso?faces-redirect=true&amp;hotel_id="+String.valueOf(hotel.getCodigo());


                    } else {
                        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio agregar habitaciones");
                        FacesContext.getCurrentInstance().addMessage("msj_bean", msj);
                    }
                } else {
                    FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Es obligatorio subir imagenes");
                    FacesContext.getCurrentInstance().addMessage("msj_bean", msj);
                }
            }

        } catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj_bean", msj);
            System.out.println("ERROR: " + e.getMessage());
        }

        return null;
    }


    public void subirImagenesHotel(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenesHotel.add(nombreImagen);
        }
    }

    public void subirImagenesHabitacion(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if(nombreImagen!=null) {
            imagenesHabitacion.add(nombreImagen);
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

    public void crearHabitacion(){
        if(!imagenesHabitacion.isEmpty()){
            habitacion.setFotos(imagenesHabitacion);
            habitaciones.add(habitacion);

            habitacion = new Habitacion();
            imagenesHabitacion = new ArrayList<>();
            System.out.println("habitacion agregada");
        }else {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Asigne al menos una Habitación");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    }

}
