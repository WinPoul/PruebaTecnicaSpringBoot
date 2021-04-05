package com.altioracorp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altioracorp.model.Articulo;

public interface ArticuloDao extends JpaRepository<Articulo, Integer> {

}
