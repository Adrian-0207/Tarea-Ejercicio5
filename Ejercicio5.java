/*
Dado un archivo de texto (.txt) con el siguiente formato:
{nombre},{apellido},{fecha de nacimiento},{sueldo}

Donde:
Nombre, apellido: String
fecha de nacimiento: Fecha con formato (dia-mes-año, ejemplo: 23-05-2021)
Sueldo: es numérico con decimales.

Ejemplo:
Carlos,Sanchez,20-01-1980,45678.08

Cálculos (sobre la lista final):
Método que devuelva todos los empleados que comienzan con una letra dada en el apellido
Método que devuelva el empleado más joven y el más viejo (necesito una funcion para 
calcular el año basado en una fecha)
El empleado que más gana y el que menos gana.
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Ejercicio5 {
    private static List<Empleados> empleados = new ArrayList<>();
    public static void main(String args[]) throws IOException{
        
        String path = "Empleados.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line =  br.readLine();
            while ( line != null ){
                cargarEmpleado(line);
                line = br.readLine();
            }
        }

        char letra;
              System.out.print("Introduce una letra: ");
              letra = (char)System.in.read();
     
        System.out.println("Empleados cuyo apellido comienza con " + letra + " : " + BuscarApellido(letra));
        System.out.println("Empleados más joven : " + getMenorEdadEmpleados());
        System.out.println("Empleados más viejo : " + getMayorEdadEmpleados());
        System.out.println("Empleado de mayor salario: " + getMayorSalarioEmpleados()); 
        System.out.println("Empleado de menor salario : " + getMenorSalarioEmpleados()); 
    }

    public static void cargarEmpleado(String fila){
        if (fila != null){
            fila = fila.toUpperCase();
            String[] dato = fila.split(",");
            Empleados e = new Empleados(dato[0], dato[1], dato[2], dato[3]);
            empleados.add(e); 
        }  
    }


    //Busqueda apellido
    public static List<Empleados> BuscarApellido(char letra){
        List<Empleados> encontrados = new ArrayList<>();
        for (Empleados e: empleados){
            if (e.getApellido().charAt(0) == Character.toUpperCase(letra)){
                encontrados.add(e);
            }
        }
        return encontrados;
    }    


    //Mayor sueldo
    public static double getMayorSueldo(){
        double mayor_sueldo = empleados.get(0).getSueldo();
        for (Empleados e: empleados){
            if (e.getSueldo() > mayor_sueldo){
                mayor_sueldo = e.getSueldo();
            }
        }
        return mayor_sueldo;
    }


    //Menor sueldo
    public static double getMenorSueldo(){
        double menor_sueldo = empleados.get(0).getSueldo();
        for (Empleados e: empleados){
            if (e.getSueldo() < menor_sueldo){
                menor_sueldo = e.getSueldo();
            }
        }
        return menor_sueldo;
    }


    //Mayor edad
    public static int getMayorEdad(){
        int mayor_edad = ((Empleados) empleados.get(0)).edad();
        for (Empleados e: empleados){
            if (e.edad() > mayor_edad){
                mayor_edad = e.edad();
            }
        }
        return mayor_edad;
    }


    //Menor edad
    public static int getMenorEdad(){
        int menor_edad = empleados.get(0).edad();
        for (Empleados e: empleados){
            if (e.edad() < menor_edad){
                menor_edad = e.edad();
            }
        }
        return menor_edad;
    }


    //Menor salario
    public static List<Empleados> getMenorSalarioEmpleados(){
        List<Empleados> seleccion = new ArrayList<>();
        double menor_salario = getMenorSueldo();
        for (Empleados e: empleados){
            if (e.getSueldo() == menor_salario){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }


    //Mayor salario
    public static List<Empleados> getMayorSalarioEmpleados(){
        List<Empleados> seleccion = new ArrayList<>();
        double mayor_salario = getMayorSueldo();
        for (Empleados e: empleados){
            if (e.getSueldo() == mayor_salario){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleados> getMenorEdadEmpleados(){
        List<Empleados> seleccion = new ArrayList<>();
        double menor_edad = getMenorEdad();
        for (Empleados e: empleados){
            if (e.edad() == menor_edad){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }

    public static List<Empleados> getMayorEdadEmpleados(){
        List<Empleados> seleccion = new ArrayList<>();
        double mayor_edad = getMayorEdad();
        for (Empleados e: empleados){
            if (e.edad() == mayor_edad){
                seleccion.add(e);
            }
        }
        return seleccion;   
    }
}