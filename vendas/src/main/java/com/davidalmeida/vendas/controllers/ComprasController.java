package com.davidalmeida.vendas.controllers;

import com.davidalmeida.vendas.DTO.ClienteDTO;
import com.davidalmeida.vendas.DTO.ComprasDTO;
import com.davidalmeida.vendas.entities.Cliente;
import com.davidalmeida.vendas.entities.Compras;
import com.davidalmeida.vendas.services.ClienteService;
import com.davidalmeida.vendas.services.ComprasService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseBody
    public ResponseEntity<ComprasDTO> saveCliente(@RequestBody ComprasDTO comprasDTO) {
        Compras entidade = comprasService.fromDTO(comprasDTO);
        comprasService.saveCompras(entidade);
        return new ResponseEntity<>(comprasDTO, HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    @ResponseBody
    public ResponseEntity<ComprasDTO> updateCliente(@PathVariable Integer id, @RequestBody ComprasDTO comprasDTO) {
        Compras entidade = comprasService.fromDTO(comprasDTO);
        if(comprasService.updateCompras(id, entidade) != null) {
            return new ResponseEntity<>(comprasDTO, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }
}
