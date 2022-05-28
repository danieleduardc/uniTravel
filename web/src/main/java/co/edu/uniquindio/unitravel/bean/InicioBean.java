package co.edu.uniquindio.unitravel.bean;

import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
@Component
@ViewScoped
public class InicioBean implements Serializable {

    public String irRegistro(){
        return "registrarCliente?faces-redirect=true";
    }
}
