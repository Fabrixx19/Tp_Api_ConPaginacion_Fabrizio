package com.facu.dummy.controllers;

import com.facu.dummy.entities.Autor;
import com.facu.dummy.services.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")    //Brinda o permite el acceso a nuestra API desde distintos origenes
@RequestMapping(path = "api/v1/autores")    // indicamos la URL para acceder a los recursos
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{
}
