package com.example.Personal.Finance.Manager.exception;

public class CustomException {
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String id) {
            super("User not found with id: " + id);
        }
    }
    public static class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String id) {
            super("Transaction not found with id: " + id);
        }
    }

}
