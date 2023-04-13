package com.example.Backend.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "miembro")
public class Miembro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String identificacion;
    @Column
    private String nombre;
    @Column
    private String sexo;


    @Column
    private String fechaNacimiento;
    @Column
    private String direccion;
    @Column
    private String telefono;

    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getidentificacion() {
        return identificacion;
    }

    public void setidentificacion(String identificacion) {
        this.identificacion = identificacion;
    }



    public String getsexo() {
        return sexo;
    }

    public void setsexo(String sexo) {
        this.sexo = sexo;
    }

    public String getfechaNacimiento() {
        return fechaNacimiento;
    }

    public void setfechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public String gettelefono() {
        return telefono;
    }

    public void settelefono(String telefono) {
        this.telefono = telefono;
    }



}
