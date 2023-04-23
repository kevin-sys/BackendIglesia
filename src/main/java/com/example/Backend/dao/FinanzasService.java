package com.example.Backend.dao;

import com.example.Backend.model.Finanza;
import java.util.List;

public interface FinanzasService {

    List<Finanza> listar();

    Finanza listarId(int id);

    Finanza add(Finanza f);

    Finanza edit(Finanza f);

    Finanza delete(int id);
}
