package com.davidalmeida.vendas.controllers;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.DTO.ComprasDTO;
import com.davidalmeida.vendas.services.ClienteService;
import com.davidalmeida.vendas.services.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Classe terá endpoints
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;
    @GetMapping
    public ResponseEntity<List<ComprasDTO>> findAll() {
        List<ComprasDTO> lista = comprasService.findAll();
        return ResponseEntity.ok(lista);
    }
}
