package br.com.senai.aluno.api.model.output;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/***
 * DTO para output de dados do Aluno
 */

@Getter
@Setter
public class AlunoOutputDTO {

    private long matricula;

    private String nome;

    private LocalDate nascimento;

}
