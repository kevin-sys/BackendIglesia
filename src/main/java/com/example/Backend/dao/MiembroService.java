package com.example.Backend.dao;

import com.example.Backend.model.Miembro;
import java.util.List;

public interface MiembroService {

    List<Miembro> listar();

    Miembro listarId(String identificacion);

    Miembro add(Miembro m);

    Miembro edit(Miembro m);

    Miembro delete(String identificacion);
}
