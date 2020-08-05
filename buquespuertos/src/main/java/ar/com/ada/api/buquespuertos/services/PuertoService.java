package ar.com.ada.api.buquespuertos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.buquespuertos.entities.Puerto;
import ar.com.ada.api.buquespuertos.repositories.PuertoRepositoy;

@Service
public class PuertoService {

    @Autowired
    PuertoRepositoy puertoRepositoy;

    public boolean crearPuerto(Puerto puerto) {

        puertoRepositoy.save(puerto);

        if (puerto.get_id() == null) {

            return false;
        }
        return true;
    }

    public List<Puerto> listarPuertos() {
        return puertoRepositoy.findAll();
    }
}