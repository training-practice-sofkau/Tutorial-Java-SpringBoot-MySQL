package com.sofka.contactos.service.interfaces;

import com.sofka.contactos.domain.Contacto;
import com.sofka.contactos.domain.Telefono;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILibreta {

    @Transactional(readOnly = true)
    public List<Contacto> getList();

    @Transactional(readOnly = true)
    public List<Contacto> getList(String field, Sort.Direction order);

    @Transactional(readOnly = true)
    public List<Contacto> searchContacto(String dataToSearch);

    @Transactional
    public Contacto createContacto(Contacto contacto);

    @Transactional
    public Telefono createTelefono(Telefono telefono);

    @Transactional
    Contacto updateContacto(Integer id, Contacto contacto);

    @Transactional
    public Contacto updateNombre(Integer id, Contacto contacto);

    @Transactional
    public Contacto updateApellidos(Integer id, Contacto contacto);

    @Transactional
    public Telefono updateTelefono(Integer id, Telefono telefono);

    @Transactional
    public Telefono updateOnlyTelefono(Integer id, Telefono telefono);

    @Transactional
    Contacto deleteContacto(Integer id);

    @Transactional
    Telefono deleteTelefono(Integer id);
}
