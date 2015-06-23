/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit8;

import java.util.ArrayList;

/**
 *
 * @author Agustín Erkiletlian Battista
 */
public abstract class Persona
{
    protected String nombre;
    protected String dni;
    protected ArrayList<Asignatura> asignaturas;
    
    /***
     * 
     * Constructor parametrizado
     * @param nombre nombre de la persona
     * @param dni dni de la persona
     * Inicializacion del ArrayList de asignaturas
     */
    public Persona(String nombre, String dni)
    {
        this.nombre = nombre;
        this.dni = dni;
        asignaturas = new ArrayList();
    }
    
    /***
     * 
     * @param a asignatura a agregar en el ArrayList de asignaturas 
     */
    public void anyadirAsignatura(Asignatura a)
    {
        asignaturas.add(a);
    }
    
    /***
     * Ordena el ArrayList de asignaturas por nombre
     * He intentado hacerlo con el comparator pero en la pagina solo te explica
     * como ordenar con numeros (int, float, double) y no strings.
     */
    public void ordenarPorAsignaturas()
    {
        String[] nombres = new String[asignaturas.size()];
        double[] notas = new double[asignaturas.size()];
        
        for (int i = 0; i < asignaturas.size(); i++)
        {
            nombres[i] = asignaturas.get(i).getNombre();
            notas[i] = asignaturas.get(i).getNota();
        }
        
        asignaturas.clear();
        
        for (int j = 0; j < nombres.length; j++) 
        {
            for (int i = 0; i < nombres.length - j; i++) 
            {
                if (nombres[i].compareTo(nombres[i+1])>0) 
                {
                    String nombreTemporal = nombres[i];
                    nombres[i] = nombres[i+1];
                    nombres[i+1] = nombreTemporal;
                    
                    double notaTemporal = notas[i];
                    notas[i] = notas[i+1];
                    notas[i+1] = notaTemporal;
                }
            }
        }
        
        for (int i = 0; i < nombres.length; i++)
        {
            asignaturas.add(new Asignatura(nombres[i], notas[i]));
        }
    }
    
    /***
     * Ordena el ArrayList de asignaturas por nota
     * He intentado hacerlo con el comparator pero no me ha salido, así que he
     * hecho lo mismo que en ordenarPorAsignaturas() pero con las notas
     */
    public void ordenarPorNota()
    {
        String[] nombres = new String[asignaturas.size()];
        double[] notas = new double[asignaturas.size()];
        
        for (int i = 0; i < asignaturas.size(); i++)
        {
            nombres[i] = asignaturas.get(i).getNombre();
            notas[i] = asignaturas.get(i).getNota();
        }
        
        asignaturas.clear();
        
        for (int j = 0; j < nombres.length; j++) 
        {
            for (int i = 0; i < nombres.length - j; i++) 
            {
                if (notas[i] > (notas[i+1])) 
                {
                    String nombreTemporal = nombres[i];
                    nombres[i] = nombres[i+1];
                    nombres[i+1] = nombreTemporal;
                    
                    double notaTemporal = notas[i];
                    notas[i] = notas[i+1];
                    notas[i+1] = notaTemporal;
                }
            }
        }
        
        for (int i = 0; i < nombres.length; i++)
        {
            asignaturas.add(new Asignatura(nombres[i], notas[i]));
        }
    }
    
    /***
     * Muestra el nombre del alumno y a continuación las asignaturas que cursa
     * con sus respectivas notas
     */
    public void mostrarListadoAsignaturasNota()
    {
        System.out.println(this.getNombre());
        
        for (Asignatura a : asignaturas)
        {
            System.out.print(a.getNombre());
            
            int espacios = 30 - a.getNombre().length();
            
            while(espacios > 0)
            {
                System.out.print(" ");
                espacios--;
            }
            
            System.out.println(a.getNota());
        }
    }
    
    public abstract boolean esProfesor();
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setDni(String dni)
    {
        this.dni = dni;
    }
    
    public String getDni()
    {
        return dni;
    }
    
    public ArrayList<Asignatura> getAsignaturas()
    {
        return asignaturas;
    }
}
