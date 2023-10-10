package com.facu.dummy.repository;

import com.facu.dummy.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    //Anotacion Metodo de Query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Ver si existe una persona
   //boolean existByDni(int dni);

    //Anotaciones con JPQL
   //@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    //List<Persona> search(String filtro);


    //Anotaciones parametros nombrados JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    List<Persona> search(@Param("filtro") String filtro);

    //notacion con QueryNativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%:filtro%' OR persona.apellido LIKE '%:filtro%'",
           nativeQuery = true)
    List<Persona> searchNativo(String filtro);

    //Paginacion

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    //notacion con QueryNativo
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%:filtro%' OR persona.apellido LIKE '%:filtro%'",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true)
    Page<Persona> searchNativo(String filtro, Pageable pageable);


}

