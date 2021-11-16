package com.davidalmeida.vendas.services;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.DTO.ComprasDTO;
import com.davidalmeida.vendas.entities.Compras;
import com.davidalmeida.vendas.repositories.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComprasService {
    @Autowired
    private ComprasRepository comprasRepository;

   public List<ComprasDTO> findAll() {
       List<Compras> res= comprasRepository.findAll();
       return res.stream().map(c -> new ComprasDTO(c)).collect(Collectors.toList());
   }
}
