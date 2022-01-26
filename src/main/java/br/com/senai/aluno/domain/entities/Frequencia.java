package br.com.senai.aluno.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "frequencias")
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long aluno_matricula;

    private boolean status;

}
