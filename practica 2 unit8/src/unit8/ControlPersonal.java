/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit8;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Agustín Erkiletlian Battista
 */
public class ControlPersonal
{
    private static ArrayList<Persona> personas = new ArrayList();
    
    /***
     * Constructor vacío
     */
    private ControlPersonal()
    {
        
    }
    
    /***
     * 
     * Creo tres alumnos y tres profesores y les asigno asignaturas junto con
     * sus respectivas notas. Luego los muestro ordenados de distintas formas.
     * He puesto los métodos como static porque el enunciado no te dejaba muy
     * claro como hacerlo.
     */
    public static void main(String[] args)
    {
        Random rm = new Random();
        
        //Agrego 3 alumnos a la lista de personas
        anyadirPersona(new Alumno("Pablo García Taboada", "48563049X"));
        anyadirPersona(new Alumno("Álvaro González Pérez", "47952351W"));
        anyadirPersona(new Alumno("Pablo Trigueros de Miguel", "49823586Z"));
        
        //Agrego 3 profesores a la lista de personas
        anyadirPersona(new Profesor("Andrés Martínez Llopis", "41823853C"));
        anyadirPersona(new Profesor("Juan José Requena", "49374293F"));
        anyadirPersona(new Profesor("Miguel Ángel Ríos", "43438192G"));
        
        //Agrego asignaturas a las personas
        for (Persona p : personas)
        {
            p.anyadirAsignatura(new Asignatura("programacion", rm.nextDouble()*10));
            p.anyadirAsignatura(new Asignatura("entornos", rm.nextDouble()*10));
            p.anyadirAsignatura(new Asignatura("sistemas", rm.nextDouble()*10));
            p.anyadirAsignatura(new Asignatura("lenguaje de marcas", rm.nextDouble()*10));
        }
        
        //Muestro el listado de alumnos ordenado por nombre
        System.out.println("Alumnos ordenados por nombre");
        ordenarPorOrdenAlfabetico();
        mostrarListado(false);
        System.out.println();
        
        //Muestro el listado de alumnos con asignaturas ordenadas por nombre
        System.out.println("Alumnos con asignaturas ordenadas por nombre");
        for (Persona p : personas)
        {
            p.ordenarPorAsignaturas();
        }
        mostrarListado(false);
        System.out.println();
        
        //Muestro el listado de profesores ordenado por dni
        System.out.println("Profesores ordenados por dni");
        ordenarPorDni();
        mostrarListado(true);
        System.out.println();
        
        //Muestro el listado de alumnos con asignaturas ordenadas por nota
        System.out.println("Alumnos con asignaturas ordenadas por nota");
        for (Persona p : personas)
        {
            p.ordenarPorNota();
        }
        mostrarListado(false);
        System.out.println();
        
        //Muestro el listado de profesores con asignaturas ordenadas por nota
        System.out.println("Profesores con asignaturas ordenadas por nota");
        mostrarListado(true);
        System.out.println();
    }
    
    /***
     * 
     * Anyade la persona al ArrayList de personas
     * @param p nombre de la persona
     */
    public static void anyadirPersona(Persona p)
    {
        personas.add(p);
    }
    
    /***
     * Ordena las personas por dni
     */
    public static void ordenarPorDni()
    {
        String[] nombres = new String[personas.size()];
        String[] dnis = new String[personas.size()];
        boolean[] profesor = new boolean[personas.size()];
        
        for (int i = 0; i < personas.size(); i++)
        {
            nombres[i] = personas.get(i).getNombre();
            dnis[i] = personas.get(i).getDni();
            
            profesor[i] = personas.get(i).esProfesor();
        }
        
        personas.clear();
        
        for (int i = 1; i < dnis.length; i++) 
        {
            for (int j = dnis.length; i >= j; j--) 
            {
                if (dnis[j-1].compareTo(dnis[j])>0) 
                {
                    String nombreTemporal = nombres[j-1];
                    nombres[j-1] = nombres[j];
                    nombres[j] = nombreTemporal;
                    
                    String dniTemporal = dnis[j-1];
                    dnis[j-1] = dnis[j];
                    dnis[j] = dniTemporal;
                }
            }
        }
        
        for (int i = 0; i < nombres.length; i++)
        {
            if (profesor[i])
                personas.add(new Profesor(nombres[i], dnis[i]));
            else
                personas.add(new Alumno(nombres[i], dnis[i]));
        }
    }
    
    /***
     * Ordena las personas alfabeticamente
     */
    public static void ordenarPorOrdenAlfabetico()
    {
        String[] nombres = new String[personas.size()];
        String[] dnis = new String[personas.size()];
        boolean[] profesor = new boolean[personas.size()];
        
        for (int i = 0; i < personas.size(); i++)
        {
            nombres[i] = personas.get(i).getNombre();
            dnis[i] = personas.get(i).getDni();
            
            profesor[i] = personas.get(i).esProfesor();
        }
        
        personas.clear();
        
        for (int i = 1; i < dnis.length; i++) 
        {
            for (int j = dnis.length; i >= j; j--) 
            {
                if (nombres[j-1].compareTo(nombres[j])>0) 
                {
                    String nombreTemporal = nombres[j-1];
                    nombres[j-1] = nombres[j];
                    nombres[j] = nombreTemporal;
                    
                    String dniTemporal = dnis[j-1];
                    dnis[j-1] = dnis[j];
                    dnis[j] = dniTemporal;
                }
            }
        }
        
        for (int i = 0; i < nombres.length; i++)
        {
            if (profesor[i])
                personas.add(new Profesor(nombres[i], dnis[i]));
            else
                personas.add(new Alumno(nombres[i], dnis[i]));
        }
    }
    
    /***
     * Muestra los listados de asignaturas y notas
     * @param profesor indica si la persona es profesor o alumno
     */
    public static void mostrarListado(boolean profesor)
    {
        for (Persona p : personas)
        {
            if (profesor && p.esProfesor())
            {
                p.mostrarListadoAsignaturasNota();
                System.out.println();
            }
            
            else if (!profesor && !p.esProfesor())
            {
                p.mostrarListadoAsignaturasNota();
                System.out.println();
            }
        }
    }
}
