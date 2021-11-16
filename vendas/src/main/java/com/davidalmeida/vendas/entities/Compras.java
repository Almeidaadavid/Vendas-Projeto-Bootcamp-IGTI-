package com.davidalmeida.vendas.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "tb_compras") // create table tb_compras
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento
    private int id;
    private Double totalCompra;
    private LocalDate dataCompra;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;// relacionadas a um cliente


    public Compras() {

    }

    public Compras(int id, Double totalCompra, LocalDate dataCompra) {
        this.id = id;
        this.totalCompra = totalCompra;
        this.dataCompra = dataCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}
