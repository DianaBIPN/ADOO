/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author doria
 */
public class FlujoLinkedListInputStream {

    private final String archivo;
    private ObjectInputStream ois;
    private FileInputStream fis;

    public FlujoLinkedListInputStream(String archivo) {
        this.archivo = archivo;
        ois = null;
        fis = null;
    }

    private void abrirFlujo() {
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarFlujo() {
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Object> leerObjetos() {
        abrirFlujo();
        LinkedList<Object> lista = new LinkedList<>();
        try {
            Object obj = new Object();
            while (true) {
                if (fis.available() != 0) {
                    obj = ois.readObject();
                    lista.add(obj);
                } else {
                    break;
                }
            }
        } catch (EOFException eof) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, eof);
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarFlujo();
        }
        return lista;
    }

    public Object leerObjeto() {
        abrirFlujo();
        Object obj = new Object();
        try {
            if (fis.available() != 0) {
                obj = ois.readObject();
            }
        } catch (EOFException eof) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, eof);
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarFlujo();
        }

        return obj;
    }
}
