/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Integrante;
import modelo.Lider;

/**
 *
 * @author dorian
 */
public class ControlInicio {

    ControlPersistencia controlPersistencia;

    public ControlInicio() {
        controlPersistencia = new ControlPersistencia();
    }

    public boolean iniciarSesionLider(String email, String password) {
        Lider lider = new Lider("", email, password, "");
        return controlPersistencia.compararLider(lider);
    }

    public boolean iniciarSesionIntegrante(String email, String password) {
        Integrante integrante = new Integrante("", email, password, "");
        if (controlPersistencia.buscarIntegrante(integrante).getNickname() != "" && controlPersistencia.buscarIntegrante(integrante).getNombre() != "") {
            return true;
        }
        return false;
    }
}
