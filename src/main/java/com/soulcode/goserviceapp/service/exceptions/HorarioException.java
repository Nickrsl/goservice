package com.soulcode.goserviceapp.service.exceptions;

public class HorarioException extends RuntimeException {

    public HorarioException() { super("Escolha outro horário! O prestador não está disponível nesse momento."); }
    public HorarioException(String aviso) { super(aviso); }
}