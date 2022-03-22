package com.sofka.contactos.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_id", nullable = false)
    private Integer id;

    @Column(name = "cnt_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "cnt_apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "cnt_created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "cnt_updated_at")
    private Instant updatedAt;

    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Telefono.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Telefono> telefonos = new ArrayList<>();

}