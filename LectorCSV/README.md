# Ejemplo de lectura de archivo CSV y generación de un objeto

En el main de este proyecto van a ver una forma de parsear un archivo .CSV que se ingrese por argumento en la ejecucción del programa

_El modelo elegido para este ejemplo es el en cual tenemos un archivo que ingresa con información de suscripciones a un partners de contenido (disney,hbo,etc), 
el código lee el archivo sampleFile.csv que se encuentra en la parte de recrusos de nuestro proyecto e imprime todos los campos del objeto subscriptionModel_

**Consideraciones**
Es necesario tener instalado Maven, porque vamos a utilizar al gestor de dependencias para incluir una clase a nuestro proyecto

Van a poder ver dentro del archivo pom.xml esta líneas que justamente lo que hace es agregar la dependencia de la clase
```
    <dependencies>
        <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>5.5.2</version>
        </dependency>
    </dependencies>
```

También van a encontrar otra sección dentro del mismo archivo con lo siguiente

```
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>org.example.Main</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

Todo esto se utiliza para que utilizando la instrucción de Maven 
```mvn package```
se genere un archivo ejecutable dentro de la carpeta /target y que ustedes puedan ejecutar por consola un proyecto en caso de querer

Tengan presente que el tag ***<mainClass>*** debe tener la ruta de su clase Main
<mainClass>org.example.Main</mainClass> 


Por último, van a ver que en el subscriptionModel.java, donde tenemos definidos los objetos que queremos obtener a partir del archivo hay algunas anotaciones
```
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

```

Esa anotaciones **@CsvBindByPosition(position=0)** lo que están haciendo es indicarle a nuestro Parseador que atributo vamos a tener en cada posición del archivo

También van a observar que tenemos una anotación distinta **@CsvDate(value = "yyyy-MM-dd")** el objetivo de esta es indicarle el formato que queremos para nuestra fecha





