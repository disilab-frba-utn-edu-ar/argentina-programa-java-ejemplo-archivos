package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import modelo.ArchivoServiciosContratados;
import modelo.LectorArchivos;
import modelo.Servicio;
import modelo.Suscripcion;

public class Main {
    public static void main(String[] args) {
        //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }

        LectorArchivos lectorArchivos = new LectorArchivos(args[0]);

        //Obtengo todas las líneas del archivo CSV
        lectorArchivos.parsearArchivo();

        //Genero una lista con todos los distintos servicios que hay en el archivo CSV
        ArrayList<Servicio> servicios = lectorArchivos.listarServicios();

        //Genero las suscripciones, que son un servicio contratado en una fecha, con un estado y un precio
        ArrayList<Suscripcion> suscripciones = lectorArchivos.listarSuscripciones(servicios);

        for (Suscripcion cadaSuscripcion : suscripciones){
            System.out.println(
                    "Estado de la suscripción: " + cadaSuscripcion .getEstado() + "\n" +
                            "Fecha de Alta: " + cadaSuscripcion.getFechaDeAlta() + "\n" +
                            "Precio de la suscripción " + cadaSuscripcion.getPrecio() + "\n" +
                            "Id Servicio suscripto: " + cadaSuscripcion.getServicio().getIdentificadorServicio() + "\n" +
                            "Nombre Servicio suscripto: " + cadaSuscripcion.getServicio().getNombreServicio() + "\n" +
                            "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+"
            );
        }

    }

}