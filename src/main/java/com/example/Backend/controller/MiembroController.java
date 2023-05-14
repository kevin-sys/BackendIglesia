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

    @GetMapping(path = {"/{identificacion}"})
    public Miembro listarId(@PathVariable("identificacion") String identificacion) {
        return service.listarId(identificacion);
    }

    @PutMapping(path = {"/{identificacion}"})
    public Miembro editar(@RequestBody Miembro m, @PathVariable("identificacion") String identificacion) {
        m.setId(identificacion);
        return service.edit(m);
    }

    @DeleteMapping(path = {"/{identificacion}"})
    public Miembro delete(@PathVariable("identificacion") String identificacion) {
        return service.delete(identificacion);
    }
}




