package com.facu.dummy.controllers;

import com.facu.dummy.entities.Persona;
import com.facu.dummy.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")    //Brinda o permite el acceso a nuestra API desde distintos origenes
@RequestMapping(path = "api/v1/personas")    // indicamos la URL para acceder a los recursos
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage()+ "\"}"));
        }
    }


    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro , Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage()+ "\"}"));
        }
    }
}
