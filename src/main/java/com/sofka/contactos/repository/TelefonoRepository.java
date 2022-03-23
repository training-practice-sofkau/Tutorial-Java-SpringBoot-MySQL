package com.sofka.contactos.repository;

import com.sofka.contactos.domain.Contacto;
import com.sofka.contactos.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repositorio para la entidad Telefono
 *
 * @version 1.0.0 2022-03-20
 * @author Julian Lasso <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {

    /**
     * Actualiza solamente el teléfono basado en el identificador de la tupla
     *
     * @param id
     * @param telefono
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    @Modifying
    @Query(value = "update Telefono tel set tel.telefono = :telefono, tel.updatedAt = CURRENT_TIMESTAMP where tel.id = :id")
    public void updateTelefono(@Param(value = "id") Integer id, @Param(value = "telefono") String telefono);

    /**
     * Selecciona los teléfonos de un contacto en específico
     *
     * @param contacto Objeto del contacto
     * @return Listado de teléfonos encontrados
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    @Query(value = "SELECT tel FROM Telefono tel WHERE tel.contacto = :contacto")
    public List<Telefono> findAllByContacto(@Param(value = "contacto") Contacto contacto);
}