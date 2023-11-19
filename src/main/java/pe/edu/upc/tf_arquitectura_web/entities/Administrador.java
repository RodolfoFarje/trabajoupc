package pe.edu.upc.tf_arquitectura_web.entities;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

// crud administrador

@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Users usuarios;


    public Administrador() {
    }

    public Administrador(int id, Users usuarios) {
        this.id = id;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Users usuarios) {
        this.usuarios = usuarios;
    }
}


