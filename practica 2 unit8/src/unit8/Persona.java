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
    protected static ArrayList<Asignatura> asignaturas;
    
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
            for (int i = 1; i < nombres.length; i++)
            {
                if (nombres[j-1].compareTo(nombres[j]) > 0) 
                {
                    String nombreTemporal = nombres[j-1];
                    nombres[j-1] = nombres[j];
                    nombres[j] = nombreTemporal;
                    
                    double notaTemporal = notas[j-1];
                    notas[j-1] = notas[j];
                    notas[j] = notaTemporal;
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
        
        for (int i = 1; i < nombres.length; i++) 
        {
            for (int j = nombres.length; i >= j; j--) 
            {
                if (notas[j-1] > (notas[j])) 
                {
                    String nombreTemporal = nombres[j-1];
                    nombres[j-1] = nombres[j];
                    nombres[j] = nombreTemporal;
                    
                    double notaTemporal = notas[j-1];
                    notas[j-1] = notas[j];
                    notas[j] = notaTemporal;
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
    
    /***
     * 
     * @param nombre nombre de la persona 
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /***
     * 
     * @return nombre de la persona 
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /***
     * 
     * @param dni dni de la persona 
     */
    public void setDni(String dni)
    {
        this.dni = dni;
    }
    
    /***
     * 
     * @return dni de la persona
     */
    public String getDni()
    {
        return dni;
    }
    
    /***
     * 
     * @return ArrayList de las asignaturas de la persona 
     */
    public ArrayList<Asignatura> getAsignaturas()
    {
        return asignaturas;
    }
}
