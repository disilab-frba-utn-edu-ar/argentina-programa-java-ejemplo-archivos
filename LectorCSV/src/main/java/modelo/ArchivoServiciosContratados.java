package modelo;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class ArchivoServiciosContratados {
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
    @CsvBindByPosition(position = 5)
    private Integer identificadorDelPlan;

    @CsvBindByPosition(position = 6)
    private Float precioDelPlan;

    public Integer getIdentificadorDelPlan() {
        return identificadorDelPlan;
    }

    public void setIdentificadorDelPlan(Integer identificadorDelPlan) {
        this.identificadorDelPlan = identificadorDelPlan;
    }

    public Float getPrecioDelPlan() {
        return precioDelPlan;
    }

    public void setPrecioDelPlan(Float precioDelPlan) {
        this.precioDelPlan = precioDelPlan;
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
