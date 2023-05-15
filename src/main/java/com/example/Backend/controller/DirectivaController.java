package com.example.Backend.controller;

import com.example.Backend.dao.DirectivaService;
import com.example.Backend.model.Directiva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/directivas")
public class DirectivaController {

    @Autowired
    DirectivaService service;

    @GetMapping
    public List<Directiva> listar() {
        return service.listar();
    }

    @PostMapping
    public Directiva agregar(@RequestBody Directiva directiva) {
        return service.add(directiva);
    }

    @GetMapping("/{codigo}")
    public Directiva listarId(@PathVariable("codigo") int codigo) {
        return service.listarId(codigo);
    }

    @PutMapping("/{codigo}")
    public Directiva editar(@RequestBody Directiva directiva, @PathVariable("codigo") int codigo) {
        directiva.setCodigo(codigo);
        return service.edit(directiva);
    }

    @DeleteMapping("/{codigo}")
    public Directiva eliminar(@PathVariable("codigo") int codigo) {
        return service.delete(codigo);
    }
}
