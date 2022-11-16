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



    private String theSalt = "AretPasgteUsdorgon$-2Faon2ctnewU&seyArFdeuarioar.ssworlectory";






    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        // Hibernate
        // Usuario es nombre de la Clase en el package Models
        String query = "FROM Usuario";
        return entityManagerPersistenceContext.createQuery( query ).getResultList();
    } // public List<Usuario> getUsuarios()






    @Override
    @Transactional
    public Usuario getUsuario(Long id) {
        return entityManagerPersistenceContext.find( Usuario.class, id );
    }


    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuarioDelete = entityManagerPersistenceContext.find( Usuario.class, id );
        entityManagerPersistenceContext.remove( usuarioDelete );
    }





    @Override
    @Transactional
    public void createUsuario(Usuario newUser) {
        entityManagerPersistenceContext.merge( newUser );
    }







    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario infoUser) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> listaUsuarios = entityManagerPersistenceContext.createQuery( query )
                .setParameter( "email", infoUser.getCorreo() )
                .getResultList();

        if ( listaUsuarios.isEmpty() ){
            return null;
        }
        String passwordHashed = listaUsuarios.get(0).getContrasena();
        Argon2 argon2 = Argon2Factory.create( Argon2Factory.Argon2Types.ARGON2id );

        //if( argon2.verify( passwordHashed, infoUser.getPassword() + theSalt ) ){
        if( argon2.verify( passwordHashed, infoUser.getContrasena() ) ){
            return listaUsuarios.get(0);
        }
        return null;
    }






} // public class UsuarioDaoImp
