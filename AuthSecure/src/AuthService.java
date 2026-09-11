import java.util.HashMap;

public class AuthService {

    HashMap<String, Usuario> usuario;

    public AuthService() {
        usuario = new HashMap<>();
    }


    public boolean registrarUsuario(String username, String password, String nombreCompleto, String email) {

        if (usuario.containsKey(username)) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(username,password, nombreCompleto, email);


        usuario.put(username, nuevoUsuario);
        return true;
    }

    public boolean iniciarSesion(String username, String password) {

        usuario.get(username);

        if (username == null) {
            return false;
        }

        return usuario.get(username).getPassword().equals(password);

    }

    public boolean eliminarUsuario(String username) {

        if (username == null) {
            return false;
        }

        usuario.remove(username);
        return true;
    }

    public boolean usernameDisponible(String username) {
            if(!usuario.containsKey(username)) {
                return true;
            }else {
                return false;
            }
    }

}
