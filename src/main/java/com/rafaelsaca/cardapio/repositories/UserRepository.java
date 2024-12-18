package com.rafaelsaca.cardapio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.rafaelsaca.cardapio.models.User;

public interface  UserRepository extends JpaRepository<User,Long>{

  UserDetails findByEmail(String email);
  


}
