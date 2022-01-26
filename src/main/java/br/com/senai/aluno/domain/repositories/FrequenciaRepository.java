package br.com.senai.aluno.domain.repositories;

import br.com.senai.aluno.domain.entities.Frequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FrequenciaRepository extends JpaRepository<Frequencia, Long> {

    @Query("SELECT f FROM Frequencia f WHERE f.aluno_matricula = ?1")
    Optional<Frequencia> findByAlunoMatricula(long matricula);

}
