package com.davidalmeida.vendas.services;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.DTO.ComprasDTO;
import com.davidalmeida.vendas.entities.Cliente;
import com.davidalmeida.vendas.entities.Compras;
import com.davidalmeida.vendas.repositories.ClienteRepository;
import com.davidalmeida.vendas.repositories.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Compras updateCompras(Integer id, Compras newCompras){
       return comprasRepository.findById(id).map(c -> {
           c.setTotalCompra(newCompras.getTotalCompra());
           c.setDataCompra(newCompras.getDataCompra());
           Compras atualizado = comprasRepository.save(c);
           return atualizado;
      }).orElse(null);
    }

    public void deleteCompras(Integer id) {
       try{
           if(comprasRepository.findById(id) !=null) {
               comprasRepository.deleteById(id);
           }
       } catch (DataIntegrityViolationException e) {
           throw new Error("Você não pode deletar um CLIENTE");
       }
    }

    public Compras fromDTO(ComprasDTO comprasDTO) {
        Compras entidade = new Compras(0,comprasDTO.getTotalCompra(),comprasDTO.getDataCompra(),new Cliente(comprasDTO.getCliente().getId(),null,null));
        return entidade;
    }
}
