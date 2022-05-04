package com.sofka.contactos.service.interfaces;

import com.sofka.contactos.domain.Contacto;
import com.sofka.contactos.domain.Telefono;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Interface para el servicio de Libreta
 *
 * @version 1.0.0 2022-03-20
 * @author Julian Lasso <julian.lasso@sofka.com.co>
 * @since 1.0.0
 */
public interface ILibreta {

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema
     *
     * @return
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public List<Contacto> getList();

    /**
     * Devuelve una lista de Contactos con todos contactos del sistema ordenados por el campo indicado
     * (nombre o apellido) ya sea ascendente o descendente
     *
     * @param field campo por el cual ordenar
     * @param order método de ordenado ASC o DESC
     * @return Lista de contactos
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public List<Contacto> getList(String field, Sort.Direction order);

    /**
     * Busca un dato dado entre el nombre y/o los apellidos en un contacto
     *
     * @param dataToSearch Dato a buscar
     * @return Lita de contactos
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public List<Contacto> searchContacto(String dataToSearch);

    /**
     * Crea un contacto en el sistema
     *
     * @param contacto Objeto del contacto a crear
     * @return Objeto del contacto creado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public Contacto createContacto(Contacto contacto);

    /**
     * Crea un teléfono en el sistema a nombre de un contacto
     *
     * @param telefono Objeto del teléfono a crear
     * @return Objeto del teléfono creado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public Telefono createTelefono(Telefono telefono);

    /**
     * Actualiza una tupla completa de un contacto
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    Contacto updateContacto(Integer id, Contacto contacto);

    /**
     * Actualiza el nombre de un contacto basado en su identificador
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public Contacto updateNombre(Integer id, Contacto contacto);

    /**
     * Actualiza el apellido de un contacto basado en su identificador
     *
     * @param id Identificador del contacto a actualizar
     * @param contacto Objeto del contacto a actualizar
     * @return Objeto del contacto actualizado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public Contacto updateApellidos(Integer id, Contacto contacto);

    /**
     * Actualiza la tupla completa de un teléfono en el sistema basado en su identificador
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public Telefono updateTelefono(Integer id, Telefono telefono);

    /**
     * Actualiza solamente el teléfono de un contacto a partir del ID de la tupla del teléfono
     *
     * @param id Identificador del teléfono a actualizar
     * @param telefono Objeto del teléfono a actualizar
     * @return Objeto del teléfono actualizado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    public Telefono updateOnlyTelefono(Integer id, Telefono telefono);

    /**
     * Borra un contacto del sistema basado en su identificador
     *
     * @param id Identificación del contacto a borrar
     * @return Objeto del contacto borrado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    Contacto deleteContacto(Integer id);

    /**
     * Borra un teléfono del sistema basado en su identificador
     *
     * @param id Identificación del teléfono a borrar
     * @return Objeto del teléfono borrado
     *
     * @author Julian Lasso <julian.lasso@sofka.com.co>
     * @since 1.0.0
     */
    Telefono deleteTelefono(Integer id);
}
