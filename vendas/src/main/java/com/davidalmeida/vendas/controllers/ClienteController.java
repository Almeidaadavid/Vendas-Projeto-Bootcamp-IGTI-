package com.davidalmeida.vendas.controllers;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.entities.Cliente;
import com.davidalmeida.vendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Classe terá endpoints
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> lista = clienteService.findAll();
        return ResponseEntity.ok(lista);
    }
}
