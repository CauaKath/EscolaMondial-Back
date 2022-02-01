package br.com.senai.aluno.api.model.input;

import lombok.Getter;
import lombok.Setter;

/***
 * DTO para input de dados da chamada
 */

@Getter
@Setter
public class FrequenciaInputDTO {

    private String nome;

    private boolean status;

}
