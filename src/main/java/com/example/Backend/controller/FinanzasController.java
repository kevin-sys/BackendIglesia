package com.example.Backend.controller;

import com.example.Backend.dao.FinanzasService;
import com.example.Backend.model.Finanza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
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
@RequestMapping({"/finanzas"})
public class FinanzasController {

    @Autowired
    FinanzasService service;

    @GetMapping
    public List<Finanza> Listar() {
        return service.listar();
    }

    @PostMapping
    public Finanza Agregar(@RequestBody Finanza f) {
        return service.add(f);
    }

    @GetMapping(path = {"/{id}"})
    public Finanza listarId(@PathVariable("id") int id) {
        return service.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Finanza editar(@RequestBody Finanza f, @PathVariable("id") int id) {
        f.setId(id);
        return service.edit(f);
    }

    @DeleteMapping(path = {"/{id}"})
    public Finanza delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
