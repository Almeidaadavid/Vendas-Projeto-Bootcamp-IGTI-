package com.davidalmeida.vendas.DTO;

import com.davidalmeida.vendas.entities.Cliente;
import com.davidalmeida.vendas.entities.Compras;
import java.time.LocalDate;

public class ComprasDTO {
    private int id;
    private Double totalCompra;
    private LocalDate dataCompra;

    private ClienteDTO cliente; // Criação do atributo cliente;


    public ComprasDTO(Compras entidade) {
        this.id = entidade.getId();
        this.totalCompra = entidade.getTotalCompra();
        this.dataCompra = entidade.getDataCompra();
        this.cliente = new ClienteDTO(entidade.getCliente()); // Inicialização cliente;
    }

    public ComprasDTO() { // Construtor vazio;

    }

    public ComprasDTO(int id, Double totalCompra, LocalDate dataCompra, ClienteDTO cliente) { // add param;
        this.id = id;
        this.totalCompra = totalCompra;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
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

    public ClienteDTO getCliente() { // Create get
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) { // Create set
        this.cliente = cliente;
    }
}
