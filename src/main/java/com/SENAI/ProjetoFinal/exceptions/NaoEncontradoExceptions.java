package com.SENAI.ProjetoFinal.exceptions;

public class NaoEncontradoExceptions extends RuntimeException {

    private static final long serialVersionUID = 1l;

    public NaoEncontradoExceptions(String msg) {
        super(msg);
    }
}