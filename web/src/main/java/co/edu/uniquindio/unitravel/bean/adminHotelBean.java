package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class adminHotelBean implements Serializable {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Value("#{param['admin_id']}")
    private String codigoAdmin;

    @Getter @Setter
    private List<Hotel> hotelesAdmin;

    @PostConstruct
    public void init(){
        hotelesAdmin = new ArrayList<>();

        try{
            if(codigoAdmin != null && !codigoAdmin.isEmpty()) {
                hotelesAdmin = administradorHotelServicio.listarHotelesAdministrador(codigoAdmin);
                hotelesAdmin.forEach(hotel -> System.out.println(hotel.getNombre()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

