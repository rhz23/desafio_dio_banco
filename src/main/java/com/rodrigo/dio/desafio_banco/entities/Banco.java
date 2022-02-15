package com.rodrigo.dio.desafio_banco.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Banco {

    @Getter
    @Setter
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public void listaClientes(){
        System.out.println("Clientes: ");
        HashMap<Integer, Cliente> clientes = new HashMap();
        int maxId = 0;
        for(Conta conta : contas){
            clientes.put(conta.getCliente().getId(), conta.getCliente());
            if(conta.getCliente().getId() > maxId){
                maxId = conta.getCliente().getId();
            }
        }
        for(int i= 1; i <= maxId; i++ ){
            if(clientes.containsKey(i)){
                System.out.println(clientes.get(i));
            }
        }
        System.out.println("Fim da lista =====");
    }

    public void addConta(Conta conta){
        contas.add(conta);
    }

    public void removeConta(Conta conta){
        boolean existe = false;
        for (Conta cta : contas){
            if (conta == cta){
                contas.remove(cta);
            }
        }
        if (existe == false){
            System.out.println("Conta informada não existe!");
        }else{
            System.out.println("Operação executada com sucesso, conta " + conta + "excluída!");
        }
    }
}
