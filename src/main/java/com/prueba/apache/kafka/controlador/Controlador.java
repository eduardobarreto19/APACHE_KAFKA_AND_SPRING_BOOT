package com.prueba.apache.kafka.controlador;

import com.prueba.apache.kafka.helper.Consolidado;
import com.prueba.apache.kafka.helper.ProductorKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Controlador")
public class Controlador {

    private static   List<String> lista;
    private  static List<String> numeros;

    public Controlador(){
        lista = new ArrayList<>();
        lista.add("Luis");
        lista.add("eduardo");
        lista.add("barreto");
        lista.add("santamaria");

        numeros = new ArrayList<>();
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
        numeros.add("5");
    }



    @Autowired
    private ProductorKafka productorKafka;

    @GetMapping("/{mensaje}")
    public String enviarMensaje(@PathVariable String mensaje) {
        String respuesta = "Proceso exitoso";
        try {
            productorKafka.send(mensaje);
            pruebaLista();
        } catch (Exception e) {
            respuesta = "Error desconocido";
        }
        return respuesta;

    }

    private void pruebaLista() {
        List numbers = Arrays.asList(7, 7, 7, 7, 2, 2, 2, 3, 3, 3, 3, 100, 100, 200, 200);
        numbers = (List) numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Lista con elementos distintos: "+numbers);

        System.out.println("******");

        Set nums = (Set) numbers.stream().collect(Collectors.toSet());
        System.out.println("SET con elementos distintos: "+numbers);

        System.out.println("******");

      //  filtrar();
       // ordenar();
       // transformar();
       // limitar();
       // contar();
        ejercicio1();
    }

    public static void filtrar(){
        //filtrar elementos que empuecen con la lista M
        lista.stream().filter(x -> x.startsWith("s")).forEach(System.out::println);
        System.out.println("******");

    }

    public static void ordenar(){
        //lista.stream().sorted().forEach(System.out::println);
        lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println); // ordenamiento en orden inverso
        System.out.println("******");
    }

    public static void transformar(){
        lista.stream().map(String::toUpperCase).forEach(System.out::println); //COnvertir todo a mayuscula (Map transformna elementos de coleccion)
        System.out.println("******");
        numeros.stream().map(x -> Integer.parseInt(x)+1).forEach(System.out::println);
        System.out.println("******");

    }
    public static void limitar(){
        lista.stream().limit(2).forEach(System.out::println);
        System.out.println("******");

    }

    public static void contar(){
        long x= lista.stream().count();
        System.out.println("****** COUNT: " + x);

    }

    public static void ejercicio1(){

        //JDK8
        System.out.println("******************* JDK 8");
        Integer[] numbers = new Integer[] {1,2,3,4,5,1,3,5};

        //This array has duplicate elements
        System.out.println( "JDK8 con duplicados" + Arrays.toString(numbers) );


        //Opcion 1
        List numbersAux = (List)  Arrays.asList(numbers).stream().distinct().collect(Collectors.toList());
        ////Opcion 2
        //Set nums = (Set)   Arrays.asList(numbers).stream().collect(Collectors.toSet());
        System.out.println("JDK8 Sin dulicados: "+numbersAux);



        //JDK7
        System.out.println("******************* JDK 7");
        Integer[] numbers2 = new Integer[] {1,2,3,4,5,1,3,5};

        //This array has duplicate elements
        System.out.println( "JDK7 con duplicados" + Arrays.toString(numbers2) );

        //Create set from array elements
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>( Arrays.asList(numbers2) );

        //Get back the array without duplicates
        Integer[] numbersWithoutDuplicates = linkedHashSet.toArray(new Integer[] {});
        System.out.println( "JDK 7 Sin duplicados" +linkedHashSet );

    }

}
