package com.sofka.contactos.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "telefono")
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tel_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Contacto.class, optional = false)
    @JoinColumn(name = "tel_contacto_id", nullable = false)
    @JsonBackReference
    private Contacto contacto;

    @Column(name = "tel_telefono", nullable = false, length = 30)
    private String telefono;

    @Column(name = "tel_created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "tel_updated_at")
    private Instant updatedAt;

}