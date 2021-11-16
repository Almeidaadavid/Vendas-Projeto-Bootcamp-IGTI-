package com.davidalmeida.vendas.repositories;

import com.davidalmeida.vendas.entities.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Integer> {

}
