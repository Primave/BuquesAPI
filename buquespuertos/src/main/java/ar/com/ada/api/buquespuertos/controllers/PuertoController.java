package ar.com.ada.api.buquespuertos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.buquespuertos.entities.Puerto;
import ar.com.ada.api.buquespuertos.models.GenericResponse;
import ar.com.ada.api.buquespuertos.services.PuertoService;

@RestController
public class PuertoController {

    @Autowired
    PuertoService puertoService;

    @PostMapping("/puertos")
    public ResponseEntity<GenericResponse> crearPuerto (@RequestBody Puerto puerto) {

        boolean creacionOk;
        creacionOk = puertoService.crearPuerto(puerto);

        GenericResponse resp = new GenericResponse();
        if(creacionOk){
            
            resp.isOk = true;
            resp.id = puerto.get_id().toHexString();
            resp.message = "Se creo el Puerto con exito";

            return ResponseEntity.ok(resp);

        }else{
            resp.isOk = false;
            resp.message = "No se pude crear";
        }

        return ResponseEntity.badRequest().body(resp);
    }


    @GetMapping("/puertos")
    public ResponseEntity<List<Puerto>> listarPuertos(){

        List<Puerto> lista = puertoService.listarPuertos();
        return ResponseEntity.ok(lista);
    }
    



}