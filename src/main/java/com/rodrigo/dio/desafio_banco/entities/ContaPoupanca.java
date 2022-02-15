package com.rodrigo.dio.desafio_banco.entities;

import lombok.NonNull;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(@NonNull Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
