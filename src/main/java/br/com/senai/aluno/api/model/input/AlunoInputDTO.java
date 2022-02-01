package br.com.senai.aluno.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/***
 * DTO para input de dados do Aluno
 */

@Getter
@Setter
public class AlunoInputDTO {

    private long matricula;

    private String nome;

    private LocalDate nascimento;

}
