import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Empleados {
    String nombre;
    String apellido;
    LocalDate fecha_nacimiento;
    double sueldo ;

    
    //-----------------------------------------
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //-----------------------------------------


    //-----------------------------------------
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //-----------------------------------------


    //------------------------------------------
    public double getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(String sueldo) {
        this.sueldo = Double.parseDouble(sueldo);
    }
    //-----------------------------------------


    //-------------------------------------------
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento,formatter);
    }
    //-----------------------------------------


    public Empleados(String nombre, String apellido, String fecha_nacimietno, String sueldo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setSueldo(sueldo);
        this.setFecha_nacimiento(fecha_nacimietno);   
    }

    @Override
    public String toString() {
        return this.getNombre()+" "+this.getApellido();
    }
 
    
    public int edad() {
        int diferencia = (int)
        ChronoUnit.DAYS.between(this.fecha_nacimiento,LocalDate.now());
        return diferencia/365;
    }

    


}

