package com.example.bancCard.util;

import com.example.bancCard.dto.ClientDto;
import com.example.bancCard.entity.Client;
import org.springframework.stereotype.Service;
@Service
public class Mapping {
        //из entity в dto
        public ClientDto mapToProductDto(Client entity){
            ClientDto dto = new ClientDto();
            dto.setId(entity.getId());
            dto.setUserName(entity.getUsername());
            dto.setCardNumber(entity.getCardNumber());
            dto.setExpireDate(entity.getExpireDate());
            return dto;
        }
        //из dto в entity
        public Client mapToProductEntity(ClientDto dto){
            Client entity = new Client();
            entity.setId(dto.getId());
            entity.setUsername(dto.getUserName());
            entity.setCardNumber(dto.getCardNumber());
            entity.setExpireDate(dto.getExpireDate());
            return entity;
        }
    }

