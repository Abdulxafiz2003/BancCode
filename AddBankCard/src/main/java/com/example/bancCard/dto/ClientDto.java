package com.example.bancCard.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ClientDto {
    @Null
    private Integer id;
    @NotNull
    private String userName;
    @NotNull
    @Size(min = 16, max = 16, message = "ERROR: The number of card numbers must be 16 numbers")
    private String cardNumber;
    @NotNull
    @Size(min = 5, max = 5, message = "ERROR: Invalid date format")
    private String expireDate;
    private String balance;
}
