/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author dorian
 */
public class Tarea {

    private String nombre;
    private String descripcion;
    private String fechaEntrega;
    private String fechaLimiteEntrega;
    private int estado;

    public Tarea(String nombre, String descripcion, String fechaEntrega, String fechaLimiteEntrega, int estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.fechaLimiteEntrega = fechaLimiteEntrega;
        this.estado = estado;
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

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaLimiteEntrega() {
        return fechaLimiteEntrega;
    }

    public void setFechaLimiteEntrega(String fechaLimiteEntrega) {
        this.fechaLimiteEntrega = fechaLimiteEntrega;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
