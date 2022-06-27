package com.example.bancCard.entity;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull
  private String username;
  @NotNull
  @Size(min = 16, max = 16, message = "ERROR: The number of card numbers must be 16 numbers")
  private String cardNumber;
  @NotNull
  @Size(min = 5, max = 5, message = "ERROR: Invalid date format")
  private String expireDate;
  private String balance;
}
