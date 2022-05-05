package com.br.alura.loja.repositories;

import com.br.alura.loja.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Order, Long> {
}
