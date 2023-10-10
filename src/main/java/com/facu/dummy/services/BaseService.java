package com.facu.dummy.services;

import com.facu.dummy.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

// <E> hace referencia a que es  una clase generica
public interface BaseService <E extends Base, ID extends Serializable>{
    public List<E> findAll() throws  Exception; //Nos traera una lista de las personas que se encuentran en nuestra BD
    public E finById(ID id) throws Exception; // Trae un objeto segun el ID que le pasamos
    public E save(E entity) throws Exception;   // cera una una nueva entidad, y para eso le envia una nueva entidad al Repositorio
    public E update(ID id, E entity) throws Exception;    // recibe 2 parametros, el de la entidad actualizada y el de la que se quiere actualizar
    public boolean delete(ID id) throws Exception;    //Lo que hace es eliminar los registros de la BD
    public Page<E> findAll(Pageable pageable) throws Exception;// Metodo Paginacion

}
