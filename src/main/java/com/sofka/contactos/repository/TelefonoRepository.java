package com.sofka.contactos.repository;

import com.sofka.contactos.domain.Contacto;
import com.sofka.contactos.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {

    @Modifying
    @Query(value = "update Telefono tel set tel.telefono = :telefono, tel.updatedAt = CURRENT_TIMESTAMP where tel.id = :id")
    public void updateTelefono(@Param(value = "id") Integer id, @Param(value = "telefono") String telefono);

    @Query(value = "SELECT tel FROM Telefono tel WHERE tel.contacto = :contacto")
    public List<Telefono> findAllByContacto(@Param(value = "contacto") Contacto contacto);
}