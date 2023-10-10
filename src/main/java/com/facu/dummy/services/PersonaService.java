package com.facu.dummy.services;

import com.facu.dummy.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{

    List<Persona> search(String filtro) throws Exception;
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;

}