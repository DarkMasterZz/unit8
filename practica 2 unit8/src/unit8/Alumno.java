/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit8;

/**
 *
 * @author Agustín Erkiletlian Battista
 */
public class Alumno extends Persona
{
    /***
     * 
     * Constructor parametrizado
     * @param nombre nombre de la persona
     * @param dni dni de la persona
     */
    public Alumno(String nombre, String dni) 
    {
        super(nombre, dni);
    }

    /***
     * Devuelve que no es un profesor
     * @return false
     */
    @Override
    public boolean esProfesor() 
    {
        return false;
    }
}
