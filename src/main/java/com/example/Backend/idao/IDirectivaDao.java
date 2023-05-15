package com.example.Backend.idao;

import com.example.Backend.model.Directiva;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IDirectivaDao extends Repository<Directiva, Integer> {

    List<Directiva> findAll();

    Directiva findById(int codigo);

    Directiva save(Directiva directiva);

    void delete(Directiva directiva);
}
