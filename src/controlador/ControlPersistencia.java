/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author dorian
 */
import flujos.FlujoLinkedListInputStream;
import flujos.FlujoLinkedListOutputStream;
import java.util.LinkedList;
import java.util.List;
import modelo.Integrante;
import modelo.Lider;

public class ControlPersistencia {

    private FlujoLinkedListInputStream flujoEntrada;
    private FlujoLinkedListOutputStream flujoSalida;

    private String path = "./";
    private String archivoLider = path + "lider.obj";
    private String archivoIntegrantes = path + "integrantes.obj";

    private Lider lider;
    private LinkedList<Integrante> integrantes;

    public ControlPersistencia() {
        integrantes = new LinkedList<>();
        //escritos = new LinkedList<>();

        cargarIntegrantes();
        //cargarEscritos();
    }

    public void guardarLider(Lider lider) {
        this.lider = lider;
        flujoSalida = new FlujoLinkedListOutputStream(archivoLider);
        flujoSalida.escribirObjeto(this.lider);
    }

    public void cargarLider() {
        flujoEntrada = new FlujoLinkedListInputStream(archivoLider);
        this.lider = (Lider) flujoEntrada.leerObjeto();
    }

    public boolean compararLider(Lider lider) {
        cargarLider();
        System.out.println(this.lider.getEmail() + "  " + lider.getEmail() + "  " + this.lider.getPassword() + "  " + lider.getPassword());
        if ((this.lider.getEmail() == null ? lider.getEmail() == null : this.lider.getEmail().equals(lider.getEmail())) && (this.lider.getPassword() == null ? lider.getPassword() == null : this.lider.getPassword().equals(lider.getPassword()))) {
            return true;
        }
        return false;
    }

    public void cargarIntegrantes() {
        try {
            flujoEntrada = new FlujoLinkedListInputStream(archivoIntegrantes);
            List<Object> integrantesRegistrados = flujoEntrada.leerObjetos();
            integrantesRegistrados.stream().forEach((integrante) -> {
                integrantes.add((Integrante) integrante);
            });
        } catch (Exception e) {
            System.out.println("No se hay registros");
        }
    }

    public void guardarIntegrantes() {
        flujoSalida = new FlujoLinkedListOutputStream(archivoIntegrantes);
        LinkedList<Object> integrantesRegistrados = new LinkedList<>();
        integrantesRegistrados.addAll(integrantes);
        flujoSalida.escribirObjetos(integrantesRegistrados);
    }

    public void agregarIntegrante(Integrante integrante) {
        integrantes.add(integrante);
        guardarIntegrantes();
    }

    public Integrante buscarIntegrante(Integrante integrante) {
        for (Integrante integranteRegistrado : integrantes) {
            if (integranteRegistrado.getEmail().equals(integrante.getEmail())
                    && integranteRegistrado.getPassword().equals(integrante.getPassword())) {
                return integranteRegistrado;
            }
        }
        return null;
    }

    /*public void cargarUsuarios() {
        try {
            flujoEntrada = new FlujoLinkedListInputStream(archivoUsuario);
            List<Object> usuariosRegistrados = flujoEntrada.leerObjetos();
            usuariosRegistrados.stream().forEach((usuario) -> {
                usuarios.add((RegistroUsuario) usuario);
            });
        } catch (Exception e) {
            System.out.println("No se hay registros");
        }
    }*/
//    public void guardarUsuarios() {
//        flujoSalida = new FlujoLinkedListOutputStream(archivoUsuario);
//        LinkedList<Object> usuariosRegistrados = new LinkedList<>();
//        usuariosRegistrados.addAll(usuarios);
//        flujoSalida.escribirObjetos(usuariosRegistrados);
//    }
}
