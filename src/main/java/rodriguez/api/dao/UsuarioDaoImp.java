package rodriguez.api.dao;

import rodriguez.api.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManagerPersistenceContext;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario WHERE eliminado = 0";
        return entityManagerPersistenceContext.createQuery(query).getResultList();
    } /* getUsuarios */

    @Override
    public Usuario getUsuario(Long id) {
        Usuario userTmp = entityManagerPersistenceContext.find(Usuario.class, id);
        if( userTmp == null ){
            return null;
        }
        if( userTmp.getEliminado().equals("1") ){
            return null;
        }
        return userTmp;
    } /* getUsuario */

    @Override
    public void deleteUsuario(Long id) {
        Usuario usuarioDelete = entityManagerPersistenceContext.find(Usuario.class, id);

        /* eliminar real
        entityManagerPersistenceContext.remove(usuarioDelete);
        */

        usuarioDelete.setEliminado("1");
        entityManagerPersistenceContext.merge( usuarioDelete );

    } /* deleteUsuario */

    @Override
    public void createUsuario(Usuario newUser) {
        entityManagerPersistenceContext.merge(newUser);
    } /* createUsuario */

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario infoUser) {

        String query = "FROM Usuario WHERE correo = :correo";

        List<Usuario> listaUsuarios =
          entityManagerPersistenceContext.createQuery(query)
            .setParameter("correo", infoUser.getCorreo())
            .getResultList();

        if (listaUsuarios.isEmpty()) {
            return null;
        }

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if (
            argon2.verify(
              listaUsuarios.get(0).getContrasena(),
              infoUser.getContrasena().toCharArray()
            )
        ) {
           return (Usuario) listaUsuarios.get(0);
        }
        return null;

    } /* obtenerUsuarioPorCredenciales */

} // public class UsuarioDaoImp
