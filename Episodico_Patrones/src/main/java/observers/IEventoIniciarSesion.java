package observers;

import dtos.UsuarioDto;

/**
 *
 * @author tacot
 */
public interface IEventoIniciarSesion {
    
    public void solicitudDeIncio(UsuarioDto usuario);
}
