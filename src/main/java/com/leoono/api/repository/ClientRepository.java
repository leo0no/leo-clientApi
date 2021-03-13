package com.leoono.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leoono.api.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
