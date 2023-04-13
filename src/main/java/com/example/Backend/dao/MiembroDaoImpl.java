package com.example.Backend.dao;

import com.example.Backend.idao.IMiembroDao;
import com.example.Backend.model.Miembro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiembroDaoImpl implements MiembroService {

    @Autowired
    private IMiembroDao repositorio;

    @Override
    public List<Miembro> listar() {
        return repositorio.findAll();
    }

    @Override
    public Miembro add(Miembro m) {
        return repositorio.save(m);
    }

    @Override
    public Miembro listarId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Miembro edit(Miembro m) {
        return repositorio.save(m);
    }

    @Override
    public Miembro delete(int id) {
        Miembro m = repositorio.findById(id);
        if (m != null) {
            repositorio.delete(m);
        }
        return m;
    }
}
