package com.example.Backend.idao;

import com.example.Backend.model.Finanza;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface IFinanzasDao extends Repository<Finanza, Integer> {

    List<Finanza> findAll();

    Finanza findById(int id);

    Finanza save(Finanza f);

    void delete(Finanza f);
}
