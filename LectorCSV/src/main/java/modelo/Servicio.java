package modelo;

import java.util.ArrayList;

public class Servicio {
    private String sitio;
    private String nombreServicio;
    private Integer identificadorServicio;

    public Servicio(String sitio, Integer idServicioDeContenido, String servicioDeContenido) {
        this.sitio = sitio;
        this.identificadorServicio = idServicioDeContenido;
        this.nombreServicio = servicioDeContenido;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Integer getIdentificadorServicio() {
        return identificadorServicio;
    }

    public void setIdentificadorServicio(Integer identificadorServicio) {
        this.identificadorServicio = identificadorServicio;
    }

    public static Servicio buscarServicio(ArrayList<Servicio> servicios, Integer identificadorServicio) {
        for (Servicio servicioDeLaLista : servicios){
           if (servicioDeLaLista.identificadorServicio.equals(identificadorServicio)) return servicioDeLaLista;
        }
        return null;
    }
}
