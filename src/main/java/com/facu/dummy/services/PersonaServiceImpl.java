package com.facu.dummy.services;

import com.facu.dummy.entities.Persona;
import com.facu.dummy.repository.BaseRepository;
import com.facu.dummy.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Una manera de aplicar la inyeccion de dependencia es con el @Autowired y la otra es haciendo el constructor

    public PersonaService (PersonaRepository personaRepository){
    this.personaRepository = personaRepository;
}
*/
    /*
    Dentro de cada metodo usaremso un try catch para el manejo de excpciones

    */
    @Service
    public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{
        @Autowired
        private PersonaRepository personaRepository;
    /*
    Una manera de aplicar la inyeccion de dependencia es con el @Autowired y la otra es haciendo el constructor

        public PersonaService (PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    */
    /*
    Dentro de cada metodo usaremso un try catch para el manejo de excpciones

    */
        public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
            super(baseRepository);
            this.personaRepository = personaRepository;
        }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //filtra personas por nombre
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //Filtra personas que empiezan con "" ej; "a"
            //List<Persona> personas = personaRepository.search(filtro);
            return personas;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //filtra personas por nombre
            Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro,pageable);
            //Filtra personas que empiezan con "" ej; "a"
            //Page<Persona> personas = personaRepository.search(filtro, pageable);
            return personas;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

}