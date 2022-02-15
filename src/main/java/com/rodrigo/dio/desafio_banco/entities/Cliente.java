package com.rodrigo.dio.desafio_banco.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Cliente {

    private static int SEQUENCIAL = 1;

    private int id = SEQUENCIAL++;
    @NonNull
    private String nome;

}
