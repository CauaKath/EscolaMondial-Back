package br.com.senai.aluno.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
