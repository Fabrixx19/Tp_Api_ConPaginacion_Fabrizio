package com.facu.dummy.controllers;

import com.facu.dummy.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

//En esta interface vamos a terner todas las operaciones basicas que va a realizar nuestro controlador
public interface BaseController <E extends Base, ID extends Serializable>{
    public ResponseEntity <?> getAll();
    public ResponseEntity <?> getAll(Pageable pageable); //Paginacion
    public ResponseEntity <?> getOne(@PathVariable ID id);
    public ResponseEntity <?> save(@RequestBody E entity);
    public ResponseEntity <?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity <?> delete(@PathVariable ID id);

}
