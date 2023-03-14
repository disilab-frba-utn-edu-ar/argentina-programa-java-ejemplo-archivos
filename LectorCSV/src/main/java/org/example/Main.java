package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import modelo.ServicioContratado;

public class Main {
    public static void main(String[] args) {
        //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.exit(88);
        }

        List <ServicioContratado> listaDeSuscripciones;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
           listaDeSuscripciones = new CsvToBeanBuilder(new FileReader(args[0]))
                      // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ServicioContratado.class)
                    .build()
                    .parse();

              //El resultado de este método nos da una lita del objetos

            for (ServicioContratado suscripcion : listaDeSuscripciones) {
                System.out.println(suscripcion.getSitio() + ";" + suscripcion.getServicioDeContenido() + ";" +
                        suscripcion.getIdServicioDeContenido() + ";" + suscripcion.getFechaDeAlta() + ";" + suscripcion.getEstado());
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
}
}