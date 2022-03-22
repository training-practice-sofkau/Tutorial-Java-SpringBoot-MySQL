package com.sofka.contactos.service;

import com.sofka.contactos.domain.Contacto;
import com.sofka.contactos.domain.Telefono;
import com.sofka.contactos.repository.ContactoRepository;
import com.sofka.contactos.repository.TelefonoRepository;
import com.sofka.contactos.service.interfaces.ILibreta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;

@Service
public class LibretaService implements ILibreta {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getList() {
        return contactoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> getList(String field, Sort.Direction order) {
        return contactoRepository.findAll(Sort.by(order, field));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contacto> searchContacto(String dataToSearch) {
        var contacto1 = contactoRepository.findByNombreOrApellidoStartingWith(dataToSearch);
        var contacto2 = contactoRepository.findByNombreOrApellidoContains(dataToSearch);
        var contacto3 = contactoRepository.findByNombreOrApellidoEndingWith(dataToSearch);
        var answer = new HashSet<Contacto>();
        answer.addAll(contacto1);
        answer.addAll(contacto2);
        answer.addAll(contacto3);
        return answer.stream().toList();
    }

    @Override
    @Transactional
    public Contacto createContacto(Contacto contacto) {
        contacto.setCreatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    @Override
    @Transactional
    public Telefono createTelefono(Telefono telefono) {
        telefono.setCreatedAt(Instant.now());
        return telefonoRepository.save(telefono);
    }

    @Override
    @Transactional
    public Contacto updateContacto(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        return contactoRepository.save(contacto);
    }

    @Override
    @Transactional
    public Contacto updateNombre(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        contactoRepository.updateNombre(id, contacto.getNombre());
        return contacto;
    }

    @Override
    @Transactional
    public Contacto updateApellidos(Integer id, Contacto contacto) {
        contacto.setId(id);
        contacto.setUpdatedAt(Instant.now());
        contactoRepository.updateApellido(id, contacto.getApellido());
        return contacto;
    }

    @Override
    @Transactional
    public Telefono updateTelefono(Integer id, Telefono telefono) {
        telefono.setId(id);
        telefono.setUpdatedAt(Instant.now());
        telefonoRepository.save(telefono);
        return telefono;
    }

    @Override
    @Transactional
    public Telefono updateOnlyTelefono(Integer id, Telefono telefono) {
        telefono.setId(id);
        telefono.setUpdatedAt(Instant.now());
        telefonoRepository.updateTelefono(id, telefono.getTelefono());
        return telefono;
    }

    @Override
    @Transactional
    public Contacto deleteContacto(Integer id) {
        var contacto = contactoRepository.findById(id);
        if (contacto.isPresent()) {
            contactoRepository.delete(contacto.get());
            return contacto.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public Telefono deleteTelefono(Integer id) {
        var telefono = telefonoRepository.findById(id);
        if (telefono.isPresent()) {
            telefonoRepository.delete(telefono.get());
            return telefono.get();
        } else {
            return null;
        }
    }
}
