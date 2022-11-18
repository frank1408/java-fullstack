package com.cursojava.curso.models;

//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table( name = "usuarios" )
//@ToString
//@EqualsAndHashCode
public class Usuario {

    @Id
    //@Getter @Setter
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    //@Getter @Setter
    @Column(name = "nombre", nullable = false)
    private String nombre;

    //@Getter @Setter
    @Column(name = "apellido", nullable = false)
    private String apellido;

    //@Getter @Setter
    @Column(name = "correo", unique=true, nullable = false)
    private String correo;

    //@Getter @Setter
    @Column(name = "telefono", unique=true, nullable = false)
    private String telefono;

    //@Getter @Setter
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    //@Getter @Setter
    @Column(name = "eliminado", nullable = false)
    private String eliminado;

    //@Getter @Setter
    @Column(name = "rol", nullable = false)
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
} // public class Usuario
