package com.adi.equityDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.equityDemo.entities.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer>{

}
