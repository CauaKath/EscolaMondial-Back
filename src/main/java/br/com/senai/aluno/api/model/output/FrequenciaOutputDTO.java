package br.com.senai.aluno.api.model.output;

import lombok.Getter;
import lombok.Setter;

/***
 * DTO para output de dados da chamada
 */

@Getter
@Setter
public class FrequenciaOutputDTO {

    private String nome;

    private boolean status;

}
