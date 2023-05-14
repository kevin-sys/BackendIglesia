package com.example.Backend.dao;

import com.example.Backend.idao.IFinanzasDao;
import com.example.Backend.model.Finanza;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Backoff
@Retryable
@Service
public class FinanzasDaoImpl implements FinanzasService {

    @Autowired
    private IFinanzasDao repositorio;

    @Override
    public List<Finanza> listar() {
        return repositorio.findAll();
    }

    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 10000))
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

    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 10000))
    @Override
    public Finanza delete(int id) {
        Finanza f = repositorio.findById(id);
        if (f != null) {
            repositorio.delete(f);
            return f;
        } else {
            throw new NoSuchElementException("No se encontró la finanza con id " + id);
        }
    }
}
