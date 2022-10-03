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
    private EntityManager entityManager;

    private String theSalt = "AretPasgteUsdorgon$-2Faon2ctnewU&seyArFdeuarioar.ssworlectory";


    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario"; // Hibernate
        return entityManager.createQuery( query ).getResultList();
    } // public List<Usuario> getUsuarios()

    @Override
    @Transactional
    public Usuario getUsuario(Long id) {
        return entityManager.find( Usuario.class, id );
    }


    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuarioDelete = entityManager.find( Usuario.class, id );
        entityManager.remove( usuarioDelete );
    }

    @Override
    @Transactional
    public void createUsuario(Usuario newUser) {
        entityManager.merge( newUser );
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario infoUser) {
        String query = "FROM Usuario WHERE email= :email";
        List<Usuario> listaUsuarios = entityManager.createQuery( query )
                .setParameter( "email", infoUser.getEmail() )
                .getResultList();

        if ( listaUsuarios.isEmpty() ){
            return null;
        }

        String passwordHashed = listaUsuarios.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create( Argon2Factory.Argon2Types.ARGON2id );

        if( argon2.verify( passwordHashed, infoUser.getPassword() + theSalt ) ){
            return listaUsuarios.get(0);
        }

        return null;
    }


//@Override
//@Transactional
//public void updateUsuario(Usuario customUser) {
//entityManager.merge( customUser );
//}


} // public class UsuarioDaoImp
