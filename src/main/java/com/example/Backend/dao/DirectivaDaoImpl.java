package com.example.Backend.dao;

import com.example.Backend.idao.IDirectivaDao;
import com.example.Backend.model.Directiva;
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
public class DirectivaDaoImpl implements DirectivaService {

    @Autowired
    private IDirectivaDao repositorio;

    @Override
    public List<Directiva> listar() {
        return repositorio.findAll();
    }

    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 10000))
    @Override
    public Directiva add(Directiva directiva) {
        return repositorio.save(directiva);
    }

    @Override
    public Directiva listarId(int codigo) {
        return repositorio.findById(codigo);
    }

    @Override
    public Directiva edit(Directiva directiva) {
        return repositorio.save(directiva);
    }

    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 10000))
    @Override
    public Directiva delete(int codigo) {
        Directiva directiva = repositorio.findById(codigo);
        if (directiva != null) {
            repositorio.delete(directiva);
            return directiva;
        } else {
            throw new NoSuchElementException("No se encontró la directiva con codigo " + codigo);
        }
    }
}
