package com.davidalmeida.vendas.services;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.entities.Cliente;
import com.davidalmeida.vendas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public List<ClienteDTO> findAll() {
        List<Cliente> res=clienteRepository.findAll();
        return res.stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
    }
}

