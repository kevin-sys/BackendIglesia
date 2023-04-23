package com.example.Backend.dao;

import com.example.Backend.idao.IFinanzasDao;
import com.example.Backend.model.Finanza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanzasDaoImpl implements FinanzasService {

    @Autowired
    private IFinanzasDao repositorio;

    @Override
    public List<Finanza> listar() {
        return repositorio.findAll();
    }

    @Override
    public Finanza add(Finanza f) {
        return repositorio.save(f);
    }

    @Override
    public Finanza listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Finanza edit(Finanza f) {
        return repositorio.save(f);
    }

    @Override
    public Finanza delete(int id) {
        Finanza f = repositorio.findById(id);
        if (f != null) {
            repositorio.delete(f);
        }
        return f;
    }
}
