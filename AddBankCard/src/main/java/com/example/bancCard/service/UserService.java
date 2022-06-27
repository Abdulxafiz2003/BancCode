package com.example.bancCard.service;

import com.example.bancCard.entity.Client;
import com.example.bancCard.exception.UserAlreadyExistException;
import com.example.bancCard.exception.UserNotFoundException;
import com.example.bancCard.repository.UserRepository;
import com.example.bancCard.util.Helper;
import com.example.bancCard.util.Mapping;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Mapping mapping;

    public UserService(UserRepository userRepository, Mapping mapping) {
        this.userRepository = userRepository;
        this.mapping = mapping;
    }

    public void registration(Client client) throws UserAlreadyExistException {
        mapping.mapToProductDto(client);
        if (userRepository.findByCardNumber(client.getCardNumber()) != null) {
            throw new UserAlreadyExistException("Пользователь с такой картой уже сущуствеут");
        }
        userRepository.save(client);
    }

    public Client getOne(Integer id) throws UserNotFoundException {
        userRepository.findById(id).ifPresent(client -> client.setCardNumber(Helper.maskedCard(client.getCardNumber(),"####********####")));
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Client client) throws UserNotFoundException, UserAlreadyExistException {
        if (userRepository.findByCardNumber(client.getCardNumber()) != null) {
            throw new UserAlreadyExistException("Пользователь с такой картой уже сущуствеут");
        }else if (userRepository.findById(client.getId()).isEmpty()){
            throw new UserNotFoundException("User not found!");
        }
        userRepository.save(client);
    }
}