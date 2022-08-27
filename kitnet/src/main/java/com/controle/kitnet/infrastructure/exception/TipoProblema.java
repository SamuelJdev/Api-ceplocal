package com.controle.kitnet.infrastructure.exception;

import lombok.Getter;

@Getter
public enum TipoProblema {

    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontra", "Entidade não encontrada");

    private String titulo;

    private String uri;

    private TipoProblema(String path, String titulo) {
        this.uri = "https://kitnet" + path;
        this.titulo = titulo;
    }
}
