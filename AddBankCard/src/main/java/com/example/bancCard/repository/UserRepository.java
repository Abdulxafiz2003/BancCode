package com.example.bancCard.repository;

import com.example.bancCard.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer> {
  Client findByCardNumber(String cardNumber);
}
