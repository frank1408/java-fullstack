package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
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
    @Transactional
    public List<Usuario> getUsuarios() {
        /*
        Hibernate
        Usuario es nombre de la Clase en el package Models

        Se agrega filtro eliminado = 0
        Osea ver los no "eliminado"
        */
        String query = "FROM Usuario WHERE eliminado = 0";
        return entityManagerPersistenceContext.createQuery(query).getResultList();
    } // public List<Usuario> getUsuarios()









    @Override
    @Transactional
    public Usuario getUsuario(Long id) {
        /* sin filtros
        return entityManagerPersistenceContext.find(Usuario.class, id);
        */
        Usuario userTmp = entityManagerPersistenceContext.find(Usuario.class, id);
        if( userTmp.getEliminado().equals("1") ){
            /*
            1 eliminado
            0 activo normal recuperado habilitado
            */
            return null;
        }
        return userTmp;

    } /* getUsuario */









    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuarioDelete = entityManagerPersistenceContext.find(Usuario.class, id);

        /* eliminar real */
        /*
        entityManagerPersistenceContext.remove(usuarioDelete);
        */

        /* eliminar fake */
        /*
        1 es "eliminar"
        0 es existe o recuperado o re-habilitado
        */
        usuarioDelete.setEliminado("1");
        entityManagerPersistenceContext.merge( usuarioDelete );
        /* eliminar fake */

    } /* deleteUsuario */









    @Override
    @Transactional
    public void createUsuario(Usuario newUser) {
        /*
        Hay error, si el correo ya existe en la base de datos,
        en ese caso se debe recuperar la cuenta.
        Cambiando el campo eliminado de "1" a "0"
        eliminado = "0"
        */
        entityManagerPersistenceContext.merge(newUser);
    } /* createUsuario */









    @Override
    //@Transactional
    public Usuario obtenerUsuarioPorCredenciales(Usuario infoUser) {
        /*
        Se agrego filtro para buscar usuarios no "eliminados"
        */
        String query = "FROM Usuario WHERE correo = :correo AND eliminado = 0";
        List<Usuario> listaUsuarios = entityManagerPersistenceContext.createQuery(query)
                .setParameter("correo", infoUser.getCorreo())
                .getResultList();

        if (listaUsuarios.isEmpty()) {
            return null;
        }
        /*
        proceso para comprobar hash de texto
        vs el hash en la base de datos
        */
        String passwordHashed = listaUsuarios.get(0).getContrasena();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if (argon2.verify(passwordHashed, infoUser.getContrasena())) {
            return listaUsuarios.get(0);
        }
        /*
        proceso para comprobar hash de texto
        vs el hash en la base de datos
        */
        return null;
    } /* obtenerUsuarioPorCredenciales */









} // public class UsuarioDaoImp
