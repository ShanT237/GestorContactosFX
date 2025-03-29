package co.edu.uniquindio.gestorcontactosfx.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

//Usarr
public class GestorContactos {
    public void setContactos(ObservableList<Usuario> contactos) {
        this.contactos = contactos;
    }

    private ObservableList<Usuario> contactos;

    public GestorContactos() {
        this.contactos = FXCollections.observableArrayList();
    }


    public void crearEstudiante(Usuario usuario) throws Exception {
        Usuario usuarioExistente = buscarPorTelefono(usuario.getTelefono());

        if (usuarioExistente != null) {
            throw new Exception("Ya existe un contacto con el mismo teléfono.");
        } else {
            contactos.add(usuario);
        }
    }

    public void eliminarEstudiante(String telefono) throws Exception {
        Usuario usuarioExistente = buscarPorTelefono(telefono);

        if (usuarioExistente == null) {
            throw new Exception("No existe un contacto con el teléfono dado.");
        } else {
            contactos.remove(usuarioExistente);
        }
    }



    public Usuario buscarPorTelefono(String telefono) {
        return contactos
                .stream()
                .filter(u -> u.getTelefono().equals(telefono))
                .findFirst()
                .orElse(null);
    }


    public List<Usuario> buscarPorNombre(String nombre) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : contactos) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(u);
            }
        }
        return resultado;
    }


    public ObservableList<Usuario> getContactos() {
        return (ObservableList<Usuario>) contactos;
    }


    public int obtenerCantidadContactos() {
        return contactos.size();
    }
}