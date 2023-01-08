package com.attornatus.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    SYSTEM_ERROR("/erro-de-sistema", "Erro de sistema"),
    INVALID_PARAMETER("/parametro-invalido", "Parâmetro inválido"),
    INCOMPREENSIVEL_MESSAGE("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RESOURCE_NOT_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    INVALID_DATA("/dados-invalidos", "Dados inválidos");

    private final String title;
    private final String uri;

    ProblemType(String path, String title) {
        this.uri = "https://attornatus.com.br" + path;
        this.title = title;
    }
}
