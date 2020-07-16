/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean.principal;

/**
 *
 * @author diego
 */
public class Curso_MB {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String status;

    public Curso_MB(int id, String nombre, String descripcion, String status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.status = status;
    }

      
    
    public Curso_MB(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
