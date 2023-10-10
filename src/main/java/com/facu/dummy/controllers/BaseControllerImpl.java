package com.facu.dummy.controllers;

import com.facu.dummy.entities.Base;
import com.facu.dummy.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente mas tarde.\"}");

        }
    }

    //Implementacion de Metodo Paginacion
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente mas tarde.\"}");

        }
    }


    @GetMapping("/{id}") //Declaracion del tipo de request
    public  ResponseEntity<?> getOne(@PathVariable Long id){    //quiere decir que es una variable a la cual se purde acceder desde e Path o la URL
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.finById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, porfavor intente mas tarde.\"}");

        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){ //declaramos que se encuentra dentro del body del Request
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, porfavor intente mas tarde.\"}");

        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, porfavor intente mas tarde.\"}");

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id)); //NO_CONTENT : no tiene contenido la respuesta
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, porfavor intente mas tarde.\"}");

        }
    }

}
