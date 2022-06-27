package com.example.bancCard.exception;

public class UserAlreadyExistException extends Exception{
  public UserAlreadyExistException(String message) {
    super(message);
  }
}
