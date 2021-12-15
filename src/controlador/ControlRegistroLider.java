/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Lider;

/**
 *
 * @author dorian
 */
public class ControlRegistroLider {

    ControlPersistencia controlPersistencia;

    public ControlRegistroLider() {
        controlPersistencia = new ControlPersistencia();
    }

    public void guardarLider(String nombre, String email, String password, String nickname) {
        Lider lider = new Lider(nombre, email, password, nickname);
        controlPersistencia = new ControlPersistencia();
        controlPersistencia.guardarLider(lider);
    }
}
