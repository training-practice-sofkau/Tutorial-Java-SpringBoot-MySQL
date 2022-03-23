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

/**
 * Entidad del Contacto
 *
 * @version 1.0.0 2022-03-20
 * @author Julian Lasso <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_id", nullable = false)
    private Integer id;

    /**
     * Nombre del contacto
     */
    @Column(name = "cnt_nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * Apellidos del contacto
     */
    @Column(name = "cnt_apellido", nullable = false, length = 100)
    private String apellido;

    /**
     * Fecha y hora en que la tupla ha sido creada
     */
    @Column(name = "cnt_created_at", nullable = false, updatable = false)
    private Instant createdAt;

    /**
     * Fecha y hora en que la tupla ha sido actualizada por última vez
     */
    @Column(name = "cnt_updated_at")
    private Instant updatedAt;

    /**
     * Punto de enlace entre la entidad del Contacto y Teléfono (un contacto puede tener muchos números de teléfono)
     */
    @OneToMany(
            fetch = FetchType.EAGER,
            targetEntity = Telefono.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "contacto"
    )
    @JsonManagedReference
    private List<Telefono> telefonos = new ArrayList<>();

}