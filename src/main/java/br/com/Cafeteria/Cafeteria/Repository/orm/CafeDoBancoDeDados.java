package br.com.Cafeteria.Cafeteria.Repository.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "cafe")
public class CafeDoBancoDeDados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoCafe;
    private double valor;

    public Long getId() {
        return id;
    }

    public String getTipoCafe() {
        return tipoCafe;
    }

    public void setTipoCafe(String tipocafe) {
        this.tipoCafe = tipocafe;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "id=" + id +
                ", tipoCafe='" + tipoCafe + '\'' +
                ", valor=" + valor +
                '}';
    }
}
