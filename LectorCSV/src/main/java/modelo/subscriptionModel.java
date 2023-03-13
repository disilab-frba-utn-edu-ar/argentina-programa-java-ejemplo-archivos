package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class subscriptionModel {
    @CsvBindByPosition(position = 0)
    private String sitio;
    @CsvBindByPosition(position = 1)
    private String servicioDeContenido;
    @CsvBindByPosition(position = 2)
    private Integer idServicioDeContenido;
    @CsvBindByPosition(position = 3)
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate fechaDeAlta;
    @CsvBindByPosition(position = 4)
    private String estado;

    public subscriptionModel(){};
    public subscriptionModel(String sitio, String servicioDeContenido, Integer idServicioDeContenido, LocalDate fechaDeAlta, String estado){
        this.sitio = sitio;
        this.servicioDeContenido = servicioDeContenido;
        this.idServicioDeContenido = idServicioDeContenido;
        this. fechaDeAlta= fechaDeAlta;
        this.estado = estado;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getServicioDeContenido() {
        return servicioDeContenido;
    }

    public void setServicioDeContenido(String servicioDeContenido) {
        this.servicioDeContenido = servicioDeContenido;
    }

    public Integer getIdServicioDeContenido() {
        return idServicioDeContenido;
    }

    public void setIdServicioDeContenido(Integer idServicioDeContenido) {
        this.idServicioDeContenido = idServicioDeContenido;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
