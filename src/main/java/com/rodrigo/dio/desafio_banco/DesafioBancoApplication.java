package com.rodrigo.dio.desafio_banco;

import com.rodrigo.dio.desafio_banco.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBancoApplication.class, args);

		Banco banco = new Banco();
		banco.setNome("BancoDoBrasil");

		Cliente rodrigo = new Cliente("Rodrigo");

		Conta cc = new ContaCorrente(rodrigo);
		banco.addConta(cc);

		cc.depositar(100);

		Conta poupanca = new ContaPoupanca(rodrigo);
		banco.addConta(poupanca);

		Cliente samuel = new Cliente("Samuel");
		Conta cppSamuel = new ContaPoupanca(samuel);
		banco.addConta(cppSamuel);

		cc.transferir(100, cppSamuel);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		banco.listaClientes();
	}

}
