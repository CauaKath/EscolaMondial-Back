package br.com.senai.aluno.domain.services;

import br.com.senai.aluno.domain.entities.Aluno;
import br.com.senai.aluno.domain.exceptions.ExceptionTratement;
import br.com.senai.aluno.domain.repositories.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public Aluno cadastrar(Aluno aluno) throws Exception {
        try {
            return alunoRepository.save(aluno);
        } catch (Exception ex) {
            throw new ExceptionTratement("Erro ao cadastrar aluno");
        }
    }

    public Optional<Aluno> buscar(long matricula) throws Exception {
        try {
            return alunoRepository.findById(matricula);
        } catch (Exception ex) {
            throw new ExceptionTratement("Erro ao buscar aluno");
        }
    }

    public Optional<Aluno> buscarPorNome(String nome) throws Exception {
        try {
            return alunoRepository.findByNome(nome);
        } catch (Exception ex) {
            throw new ExceptionTratement("Erro ao buscar aluno");
        }
    }

    public List<Aluno> listar() throws Exception {
        try {
            return alunoRepository.findAll();
        } catch (Exception ex) {
            throw new ExceptionTratement("Erro ao listar alunos");
        }
    }

    public Aluno editar(long matricula, Aluno aluno) throws Exception {
        try {
            aluno.setMatricula(matricula);

            return alunoRepository.save(aluno);
        } catch (Exception ex) {
            throw new ExceptionTratement("Erro ao editar aluno");
        }
    }

    public void remover(long matricula) throws Exception {
        try {
            alunoRepository.deleteById(matricula);
        } catch (Exception ex) {
            throw new ExceptionTratement("Erro ao remover aluno");
        }
    }

}
