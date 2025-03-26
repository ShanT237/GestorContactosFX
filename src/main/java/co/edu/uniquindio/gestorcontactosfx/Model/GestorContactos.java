package co.edu.uniquindio.gestorcontactosfx.Model;

import java.util.ArrayList;
import java.util.List;

public class GestorContactos {

    private List<Usuario> contactos;

    public GestorContactos() {
        this.contactos = new ArrayList<>();
    }

    /**
     * Método para agregar un nuevo contacto a la lista.
     * @param usuario Contacto a agregar
     * @throws Exception Si el contacto ya existe
     */
    public void agregar(Usuario usuario) throws Exception {
        Usuario usuarioExistente = buscarPorTelefono(usuario.getTelefono());

        if (usuarioExistente != null) {
            throw new Exception("Ya existe un contacto con el mismo teléfono.");
        } else {
            contactos.add(usuario);
        }
    }

    /**
     * Método para eliminar un contacto de la lista.
     * @param telefono Teléfono del contacto a eliminar
     * @throws Exception Si el contacto no existe
     */
    public void eliminar(String telefono) throws Exception {
        Usuario usuarioExistente = buscarPorTelefono(telefono);

        if (usuarioExistente == null) {
            throw new Exception("No existe un contacto con el teléfono dado.");
        } else {
            contactos.remove(usuarioExistente);
        }
    }

    /**
     * Método para actualizar la información de un contacto existente.
     * @param usuarioActualizado Usuario con los datos modificados
     * @throws Exception Si el contacto no existe
     */
    public void actualizar(Usuario usuarioActualizado) throws Exception {
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

    /**
     * Método para obtener un contacto por su teléfono.
     * @param telefono Teléfono del contacto a buscar
     * @return Usuario encontrado o null si no existe
     */
    public Usuario buscarPorTelefono(String telefono) {
        return contactos
                .stream()
                .filter(u -> u.getTelefono().equals(telefono))
                .findFirst()
                .orElse(null);
    }

    /**
     * Método para buscar contactos por nombre.
     * @param nombre Nombre del contacto a buscar
     * @return Lista de contactos con el nombre dado
     */
    public List<Usuario> buscarPorNombre(String nombre) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : contactos) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    /**
     * Método para obtener todos los contactos.
     * @return Lista de contactos
     */
    public List<Usuario> getContactos() {
        return contactos;
    }

    /**
     * Método para obtener la cantidad de contactos registrados.
     * @return Cantidad de contactos
     */
    public int obtenerCantidadContactos() {
        return contactos.size();
    }
}
