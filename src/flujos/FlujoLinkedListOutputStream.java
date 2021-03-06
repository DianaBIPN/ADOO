/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doria
 */
public class FlujoLinkedListOutputStream {

    private final String archivo;
    private ObjectOutputStream oos;
    private FileOutputStream fos;

    public FlujoLinkedListOutputStream(String archivo) {
        this.archivo = archivo;
        oos = null;
        fos = null;
    }

    private void abrirFlujo() {
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujoLinkedListOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarFlujo() {
        if (oos != null) {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(FlujoLinkedListOutputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escribirObjetos(LinkedList<Object> lista) {
        abrirFlujo();
        try {
            Object obj;
            Iterator<Object> itera = lista.iterator();
            while (itera.hasNext()) {
                obj = itera.next();
                oos.writeObject(obj);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarFlujo();
        }
    }

    public void escribirObjeto(Object obj){
        abrirFlujo();
        try {
            oos.writeObject(obj);
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarFlujo();
        }
    }
}
