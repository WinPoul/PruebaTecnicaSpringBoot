package com.altioracorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altioracorp.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}
