package modelo;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {

    String rutaArchivo;
    List<ArchivoServiciosContratados> lineasArchivo;

    public LectorArchivos(String ruta) {
        this.rutaArchivo = ruta;
        this.lineasArchivo = new ArrayList<>();
    }

    public void parsearArchivo() {
        List<ArchivoServiciosContratados> listaDeServiciosContratados = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
            listaDeServiciosContratados = new CsvToBeanBuilder(new FileReader(this.rutaArchivo))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ArchivoServiciosContratados.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        this.lineasArchivo = listaDeServiciosContratados;
    }

    public ArrayList<Servicio> listarServicios(){
        boolean servicioYaCargado = false;
        ArrayList<Servicio> servicios = new ArrayList<>();

            for (ArchivoServiciosContratados lineaarchivoServiciosContratados : this.lineasArchivo) {
                servicioYaCargado = false;
                Servicio nuevoServicio = new Servicio(lineaarchivoServiciosContratados.getSitio(),
                        lineaarchivoServiciosContratados.getIdServicioDeContenido(),
                        lineaarchivoServiciosContratados.getServicioDeContenido());

                for ( Servicio servicioGuardado : servicios) {
                    if (nuevoServicio.getIdentificadorServicio().equals(servicioGuardado.getIdentificadorServicio())) {
                        servicioYaCargado = true;
                        break;
                    }
                }
                if (!servicioYaCargado) {
                    servicios.add(nuevoServicio);
                }
        }
        return servicios;
    }

    public ArrayList<Suscripcion> listarSuscripciones(ArrayList<Servicio> servicios) {
        ArrayList<Suscripcion> suscripciones = new ArrayList<>();

        for (ArchivoServiciosContratados lineaarchivoServiciosContratados : this.lineasArchivo) {

            Servicio unServicioBuscado = Servicio.buscarServicio(servicios, lineaarchivoServiciosContratados.getIdServicioDeContenido());

            Suscripcion unaSuscripcion = new Suscripcion(
                    lineaarchivoServiciosContratados.getIdentificadorDelPlan(),
                    lineaarchivoServiciosContratados.getFechaDeAlta(),
                    lineaarchivoServiciosContratados.getPrecioDelPlan(),
                    lineaarchivoServiciosContratados.getEstado(),
                    unServicioBuscado
            );

            suscripciones.add(unaSuscripcion);
        }
        return suscripciones;
    }
}
