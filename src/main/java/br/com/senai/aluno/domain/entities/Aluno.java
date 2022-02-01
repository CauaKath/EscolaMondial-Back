package br.com.senai.aluno.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/***
 * Entidade Aluno relacionada a tabela alunos do BD
 */

@Getter
@Setter
@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    private long matricula;

    private String nome;

    private LocalDate nascimento;

}
