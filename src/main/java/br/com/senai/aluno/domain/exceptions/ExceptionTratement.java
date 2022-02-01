package br.com.senai.aluno.domain.exceptions;

/***
 * Classe para tratar exception
 */

public class ExceptionTratement extends RuntimeException{

    public ExceptionTratement(String message) { super((message)); }

}