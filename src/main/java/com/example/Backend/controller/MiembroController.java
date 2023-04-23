package com.example.Backend.controller;

import com.example.Backend.dao.MiembroService;
import com.example.Backend.model.Miembro;
import java.util.List;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/miembros"})
public class MiembroController {
    @Autowired
    MiembroService service;
    @GetMapping
    public List<Miembro> Listar() {
        return service.listar();
    }
    @PostMapping
    public Miembro Agregar(@RequestBody Miembro m) {
        return service.add(m);
    }

    @GetMapping(path = {"/{id}"})
    public Miembro listarId(@PathVariable("id") int id) {
        return service.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Miembro editar(@RequestBody Miembro m, @PathVariable("id") int id) {
        m.setId(id);
        return service.edit(m);
    }

    @DeleteMapping(path = {"/{id}"})
    public Miembro delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}




