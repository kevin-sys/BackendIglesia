package com.example.Backend.dao;

import com.example.Backend.model.Directiva;
import java.util.List;

public interface DirectivaService {

    List<Directiva> listar();

    Directiva listarId(int id);

    Directiva add(Directiva directiva);

    Directiva edit(Directiva directiva);

    Directiva delete(int id);
}
