public class Usuario {

    public Usuario(String username, String password, String nombreCompleto, String email) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    private String username;
    private String password;
    private String nombreCompleto;
    private String email;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return  password;
    }

    public String getNombreCompleto() {
        return  nombreCompleto;
    }

    public String getEmail() {
        return email;
    }
}
