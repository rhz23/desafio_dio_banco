package com.rodrigo.dio.desafio_banco.entities;

import com.rodrigo.dio.desafio_banco.Exceptions.SaldoInsuficienteException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 0001;

    private static int SEQUENCIAL = 1;

    protected Cliente cliente;
    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta (Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente, seu saldo atual é: " + this.saldo);
        }else{
            saldo -= valor;
            System.out.println("Operação efetuada com sucesso, seu saldo atual é: " + saldo);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Operação efetuada com sucesso, seu saldo atual é: " + saldo);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor > saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente, seu saldo atual é: " + this.saldo);
        }else{
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Operação efetuada com sucesso!");
            System.out.println("R$ " + valor + " transferido para a conta:" + contaDestino.getNumero() + ", agencia: " + contaDestino.getAgencia() + " de titular: " + contaDestino.cliente.getNome());
        }
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular %s", this.cliente.getNome() ));
        System.out.println(String.format("Agencia %d", this.agencia ));
        System.out.println(String.format("Numero %d", this.numero ));
        System.out.println(String.format("Saldo %.2f", this.saldo ));
    }

    @Override
    public abstract void imprimirExtrato();


}
