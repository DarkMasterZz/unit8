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
public class Profesor extends Persona
{
    /***
     * 
     * Constructor parametrizado
     * @param nombre nombre de la persona
     * @param dni dni de la persona
     */
    public Profesor(String nombre, String dni) 
    {
        super(nombre, dni);
    }

    /***
     * Devuelve que es un profesor
     * @return true
     */
    @Override
    public boolean esProfesor() 
    {
        return true;
    }
}
