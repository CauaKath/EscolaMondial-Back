package br.com.senai.aluno.api.controller;

import br.com.senai.aluno.api.assembler.AlunoAssembler;
import br.com.senai.aluno.api.model.input.AlunoInputDTO;
import br.com.senai.aluno.api.model.output.AlunoOutputDTO;
import br.com.senai.aluno.domain.entities.Aluno;
import br.com.senai.aluno.domain.services.AlunoService;
import br.com.senai.aluno.domain.utils.AlunoUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Classe responsável pelas rotas relacionadas a
 * entidade Aluno
 */

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoAssembler alunoAssembler;
    private AlunoService alunoService;
    private AlunoUtils alunoUtils;

    @PostMapping
    public ResponseEntity<AlunoOutputDTO> cadastrar(
            @RequestBody AlunoInputDTO alunoInputDTO
    ) throws Exception {
        if (!alunoUtils.verificaCadastrar(alunoInputDTO)) {
            return ResponseEntity.badRequest().build();
        }

        Aluno novoAluno = alunoAssembler.toEntity(alunoInputDTO);

        Aluno aluno = alunoUtils.cadastrar(novoAluno);

        return ResponseEntity.ok(alunoAssembler.toModel(aluno));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoOutputDTO> buscar(
            @PathVariable long matricula
    ) throws Exception {
        if (alunoService.buscar(matricula).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                alunoAssembler.toModel(alunoService.buscar(matricula).get())
        );
    }

    @GetMapping
    public ResponseEntity<List<AlunoOutputDTO>> listar() throws Exception {
        return ResponseEntity.ok(
                alunoAssembler.toCollectionModel(alunoService.listar())
        );
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<AlunoOutputDTO> editar(
            @RequestBody AlunoInputDTO alunoInputDTO,
            @PathVariable long matricula
    ) throws Exception {
        if (!alunoUtils.verificaEditar(alunoInputDTO)) {
            return ResponseEntity.badRequest().build();
        }

        Aluno novoAluno = alunoAssembler.toEntity(alunoInputDTO);

        Aluno aluno = alunoService.editar(matricula, novoAluno);

        return ResponseEntity.ok(alunoAssembler.toModel(aluno));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<AlunoOutputDTO> remover(
            @PathVariable long matricula
    ) throws Exception {
        if (alunoService.buscar(matricula).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        alunoUtils.remover(matricula);

        return ResponseEntity.ok().build();
    }

}
