package com.example.Backend.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "directiva")
public class Directiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "lider", nullable = false, length = 50)
    private String lider;

    @Column(name = "sublider", nullable = false, length = 50)
    private String sublider;

    @Column(name = "secretario", nullable = false, length = 50)
    private String secretario;

    @Column(name = "tesorero", nullable = false, length = 50)
    private String tesorero;

    @Column(name = "vocal1", nullable = false, length = 50)
    private String vocal1;

    @Column(name = "vocal2", nullable = false, length = 50)
    private String vocal2;

    @Column(name = "vocal3", nullable = false, length = 50)
    private String vocal3;

    @Column(name = "nota", nullable = false, length = 50)
    private String nota;

    // Getter y Setter para el atributo 'codigo'
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getter y Setter para el atributo 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para el atributo 'lider'
    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    // Getter y Setter para el atributo 'sublider'
    public String getSublider() {
        return sublider;
    }

    public void setSublider(String sublider) {
        this.sublider = sublider;
    }

    // Getter y Setter para el atributo 'secretario'
    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    // Getter y Setter para el atributo 'tesorero'
    public String getTesorero() {
        return tesorero;
    }

    public void setTesorero(String tesorero) {
        this.tesorero = tesorero;
    }

    // Getter y Setter para el atributo 'vocal1'
    public String getVocal1() {
        return vocal1;
    }

    public void setVocal1(String vocal1) {
        this.vocal1 = vocal1;
    }

    // Getter y Setter para el atributo 'vocal2'
    public String getVocal2() {
        return vocal2;
    }

    public void setVocal2(String vocal2) {
        this.vocal2 = vocal2;
    }

    // Getter y Setter para el atributo 'vocal3'
    public String getVocal3() {
        return vocal3;
    }

    public void setVocal3(String vocal3) {
        this.vocal3 = vocal3;
    }

    // Getter y Setter para el atributo 'nota'
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
