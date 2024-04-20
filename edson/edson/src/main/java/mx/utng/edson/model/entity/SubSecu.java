package mx.utng.edson.model.entity;
/**
 * @correo Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class SubSecu { 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Column(length = 40)
    private String nombre;//nombre

    @NotEmpty
    @Column(length = 60)
    private String correo;//correo

    @NotNull(message = "No puede estar vacio")
    private Integer likes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recorAt; 

    @PrePersist
    public void PrePersist(){
        recorAt = new Date();
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getRecorAt() {
        return recorAt;
    }

    public void setRecorAt(Date recorAt) {
        this.recorAt = recorAt;
    }

    
}
