package dtos;

/**
 *
 * @author tacot
 */
public class UsuarioDto {
    private Long id;
    private String correo, usuario, contrasena;

    public UsuarioDto() {
    }

    public UsuarioDto(String correo, String usuario, String contrasena) {
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
