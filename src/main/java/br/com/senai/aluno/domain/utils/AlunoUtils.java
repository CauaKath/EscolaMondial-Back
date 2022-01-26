package br.com.senai.aluno.domain.utils;

import br.com.senai.aluno.domain.entities.Aluno;
import br.com.senai.aluno.domain.entities.Frequencia;
import br.com.senai.aluno.domain.services.AlunoService;
import br.com.senai.aluno.domain.services.FrequenciaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AlunoUtils {

    private AlunoService alunoService;
    private FrequenciaService frequenciaService;

    public Aluno cadastrar(Aluno aluno) throws Exception {
        Aluno novoAluno = alunoService.cadastrar(aluno);

        Frequencia frequencia = new Frequencia();

        frequencia.setStatus(true);
        frequencia.setAluno_matricula(novoAluno.getMatricula());

        frequenciaService.cadastrar(frequencia);

        return novoAluno;
    }

    public void remover(long matricula) throws Exception {
        Frequencia frequencia = frequenciaService.buscarPorAluno(matricula).get();

        frequenciaService.remover(frequencia.getId());

        alunoService.remover(matricula);
    }

}
