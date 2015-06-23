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
public class Asignatura
{
    private String nombre;
    private double nota;
    
    /***
     * 
     * Constructor parametrizado
     * @param nombre nombre de la asignatura
     * @param nota nota en la asignatura
     */
    public Asignatura(String nombre, double nota)
    {
        this.nombre = nombre;
        this.nota = nota;
    }
    
    /***
     * 
     * @param nombre nombre de la asignatura
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /***
     * 
     * @return nombre de la asignatura
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /***
     * 
     * @param nota nota de la asignatura
     */
    public void setNota(double nota)
    {
        this.nota = nota;
    }
    
    /***
     * 
     * @return nota de la asignatura
     */
    public double getNota()
    {
        return nota;
    }
}
