package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
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
    public boolean verificarEmailPassword(Usuario infoUser) {
        String query = "FROM Usuario WHERE email= :email AND password= :password ";
        List<Usuario> listaUsuarios = entityManager.createQuery( query )
                .setParameter( "email", infoUser.getEmail() )
                .setParameter( "password", infoUser.getPassword() )
                .getResultList();

        return !listaUsuarios.isEmpty();

    }


//@Override
//@Transactional
//public void updateUsuario(Usuario customUser) {
//entityManager.merge( customUser );
//}


} // public class UsuarioDaoImp
