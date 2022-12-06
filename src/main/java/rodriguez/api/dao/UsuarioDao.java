package rodriguez.api.dao;

import rodriguez.api.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario getUsuario(Long id);

    void deleteUsuario(Long id);

    void createUsuario(Usuario newUser);

    Usuario obtenerUsuarioPorCredenciales(Usuario infoUser);

} // public interface UsuarioDao
