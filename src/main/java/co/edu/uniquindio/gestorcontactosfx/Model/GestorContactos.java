package co.edu.uniquindio.gestorcontactosfx.Model;

import java.util.ArrayList;
import java.util.List;

//Usarr
public class GestorContactos {

    private List<Usuario> contactos;

    public GestorContactos() {
        this.contactos = new ArrayList<>();
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


    public void actualizarEstudiante(Usuario usuarioActualizado) throws Exception {
        Usuario usuarioExistente = buscarPorTelefono(usuarioActualizado.getTelefono());

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setEmail(usuarioActualizado.getEmail());
            usuarioExistente.setFechaNacimiento(usuarioActualizado.getFechaNacimiento());
            usuarioExistente.setFotoPerfil(usuarioActualizado.getFotoPerfil());
        } else {
            throw new Exception("No existe un contacto con el teléfono dado.");
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


    public List<Usuario> getContactos() {
        return contactos;
    }


    public int obtenerCantidadContactos() {
        return contactos.size();
    }
}