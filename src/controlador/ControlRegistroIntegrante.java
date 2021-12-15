/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Integrante;

/**
 *
 * @author dorian
 */
public class ControlRegistroIntegrante {
    ControlPersistencia controlPersistencia;

    public ControlRegistroIntegrante() {
        controlPersistencia = new ControlPersistencia();
    }

public void guardarIntegrante(String nombre, String email, String password, String nickname) {
        Integrante integrante = new Integrante(nombre, email, password, nickname);
        controlPersistencia = new ControlPersistencia();
        controlPersistencia.agregarIntegrante(integrante);
    }
}
