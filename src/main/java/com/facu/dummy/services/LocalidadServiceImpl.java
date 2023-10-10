package com.facu.dummy.services;

import com.facu.dummy.entities.Localidad;
import com.facu.dummy.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository){
        super(baseRepository);
    }
}
