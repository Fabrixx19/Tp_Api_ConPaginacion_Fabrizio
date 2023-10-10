package com.facu.dummy.controllers;

import com.facu.dummy.entities.Localidad;
import com.facu.dummy.services.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")    //Brinda o permite el acceso a nuestra API desde distintos origenes
@RequestMapping(path = "api/v1/localidades")    // indicamos la URL para acceder a los recursos
public abstract class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{
}
