package com.facu.dummy.services;

import com.facu.dummy.entities.Base;
import com.facu.dummy.entities.Persona;
import com.facu.dummy.repository.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional  //Esto significa que nuestros metodos haran transacciones con la base de datos
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();   //Esto lo que hace es obtener de la BD todas las personas que tenemos registradas
            return entities; //Retornamos las entidades que obtuvimos
        }catch (Exception e){
            throw new Exception(e.getMessage());  //Lansamos una nueva excepcion donde largamos el mensaje de la excepcion

        }
    }

    // Implementacion de Paginacion
    @Override
    @Transactional  //Esto significa que nuestros metodos haran transacciones con la base de datos
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);   //Esto lo que hace es obtener de la BD todas las personas que tenemos registradas
            return entities; //Retornamos las entidades que obtuvimos
        }catch (Exception e){
            throw new Exception(e.getMessage());  //Lansamos una nueva excepcion donde largamos el mensaje de la excepcion

        }
    }

    @Override
    @Transactional
    public E finById(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);  //Por que no sabemos si en la BD se va a encontrar un objeto con el ID que le larguemos
            return entityOptional.get();    //va a obtener una entidad si es que la encuentra y si no manda la excepcion
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);  //Obtenemos la persona que queremos actualizar
            E entidad = entityOptional.get();
            entidad = baseRepository.save(entity);
            return entidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else {
                //Lanzamos una nueva excepcion
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}