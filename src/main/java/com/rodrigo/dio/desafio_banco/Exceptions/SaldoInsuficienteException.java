package com.rodrigo.dio.desafio_banco.Exceptions;

public class SaldoInsuficienteException extends IndexOutOfBoundsException{
    public SaldoInsuficienteException(String message){
        super(message);
    }
}
