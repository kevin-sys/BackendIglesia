package com.example.Backend.idao;

import com.example.Backend.model.Miembro;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface IMiembroDao extends Repository<Miembro, Integer> {

    List<Miembro> findAll();

    Miembro findByIdentificacion(String identificacion);

    Miembro save(Miembro m);

    void delete(Miembro m);
}
