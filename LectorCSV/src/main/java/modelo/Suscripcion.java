package modelo;

import java.time.LocalDate;

public class Suscripcion {
    private Integer identificadorPlan;
    private LocalDate fechaDeAlta;
    private String estado;
    private Float precio;

    private Servicio servicio;

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Suscripcion(Integer identificadorDelPlan, LocalDate fechaDeAlta, Float precioDelPlan, String estado, Servicio servicio) {
        this.identificadorPlan = identificadorDelPlan;
        this.estado = estado;
        this.fechaDeAlta = fechaDeAlta;
        this.precio = precioDelPlan;
        this.servicio = servicio;
    }

    public Integer getIdentificadorPlan() {
        return identificadorPlan;
    }

    public void setIdentificadorPlan(Integer identificadorPlan) {
        this.identificadorPlan = identificadorPlan;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
