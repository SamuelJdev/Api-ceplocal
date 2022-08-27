package com.controle.kitnet.infrastructure.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(EntidadeNotFoundException.class)
    public ResponseEntity<?> tratarEntidadeNaoEncontradaException(
            EntidadeNotFoundException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        TipoProblema tipoProblema  = TipoProblema.ENTIDADE_NAO_ENCONTRADA;

        Problema problema = createProblemaBuilder(status, tipoProblema, ex.getMessage())
                .mensagemUsuario(ex.getMessage())
                .build();

        return handleExceptionInternal(ex, problema, new HttpHeaders(),
                status, request);
    }

    private Problema.ProblemaBuilder createProblemaBuilder(HttpStatus status, TipoProblema tipoProblema, String detail) {
        return Problema.builder().status(status.value())
                .dataHora(OffsetDateTime.now())
                .status(status.value())
                .type(tipoProblema.getUri())
                .title(tipoProblema.getTitulo())
                .detail(detail);
    }

}
