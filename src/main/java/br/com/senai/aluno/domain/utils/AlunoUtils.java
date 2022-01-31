package br.com.senai.aluno.domain.utils;

import br.com.senai.aluno.api.model.input.AlunoInputDTO;
import br.com.senai.aluno.domain.entities.Aluno;
import br.com.senai.aluno.domain.entities.Frequencia;
import br.com.senai.aluno.domain.exceptions.ExceptionTratement;
import br.com.senai.aluno.domain.services.AlunoService;
import br.com.senai.aluno.domain.services.FrequenciaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    public boolean verificaCadastrar(AlunoInputDTO alunoInputDTO) throws Exception {
        if (alunoService.buscar(alunoInputDTO.getMatricula()).isPresent()) {
            throw new ExceptionTratement("Matrícula já cadastrada");
        }

        if (alunoService.buscarPorNome(alunoInputDTO.getNome()).isPresent()) {
            throw new ExceptionTratement("Nome já cadastrado");
        }

        if (alunoInputDTO.getNascimento().getYear() > LocalDate.now().minusYears(5).getYear()) {
            throw new ExceptionTratement("Data de nascimento inválida");
        }

        return true;
    }

    public boolean verificaEditar(AlunoInputDTO alunoInputDTO) throws Exception {
        if (alunoService.buscar(alunoInputDTO.getMatricula()).isEmpty()) {
            throw new ExceptionTratement("Aluno não existe");
        }

        if (alunoService.buscarPorNome(alunoInputDTO.getNome()).isPresent()) {
            throw new ExceptionTratement("Nome já cadastrado");
        }

        if (alunoInputDTO.getNascimento().getYear() > LocalDate.now().minusYears(5).getYear()) {
            throw new ExceptionTratement("Data de nascimento inválida");
        }

        return true;
    }

    public void remover(long matricula) throws Exception {
        Frequencia frequencia = frequenciaService.buscarPorAluno(matricula).get();

        frequenciaService.remover(frequencia.getId());

        alunoService.remover(matricula);
    }

}
