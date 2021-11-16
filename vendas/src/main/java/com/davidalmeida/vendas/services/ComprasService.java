package com.davidalmeida.vendas.services;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.DTO.ComprasDTO;
import com.davidalmeida.vendas.entities.Cliente;
import com.davidalmeida.vendas.entities.Compras;
import com.davidalmeida.vendas.repositories.ClienteRepository;
import com.davidalmeida.vendas.repositories.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComprasService {
    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private ClienteRepository clienteRepository; // Criação de novo atributo;

   public List<ComprasDTO> findAll() {
       clienteRepository.findAll(); // Find All;
       List<Compras> res= comprasRepository.findAll();
       return res.stream().map(c -> new ComprasDTO(c)).collect(Collectors.toList());
   }

    public Compras saveCompras(Compras compras) {
        return comprasRepository.save(compras);
    }

    public Compras fromDTO(ComprasDTO comprasDTO) {
        Compras entidade = new Compras(0,comprasDTO.getTotalCompra(),comprasDTO.getDataCompra(),new Cliente(comprasDTO.getCliente().getId(),null,null));
        return entidade;
    }
}
