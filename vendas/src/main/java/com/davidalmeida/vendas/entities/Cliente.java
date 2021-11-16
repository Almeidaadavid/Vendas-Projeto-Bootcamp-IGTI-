package com.davidalmeida.vendas.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente") // Create table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // incremento
    private int id;
    private String nome;
    private String dn;

    @OneToMany(mappedBy = "cliente") // um cliente pode fazer varias compras;
    private List<Compras> listaDeCompras = new ArrayList<>();


    public Cliente() {

    }
     public Cliente(int id, String nome, String dn) {
         super();
         this.id = id;
         this.nome = nome;
         this.dn = dn;
     }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getDn() {
        return dn;
    }
}
