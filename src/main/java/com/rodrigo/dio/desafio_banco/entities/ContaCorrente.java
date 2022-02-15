package com.rodrigo.dio.desafio_banco.entities;

import lombok.NonNull;

public class ContaCorrente extends Conta{

    public ContaCorrente(@NonNull Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
