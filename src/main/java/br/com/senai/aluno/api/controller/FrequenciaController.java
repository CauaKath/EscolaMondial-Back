package br.com.senai.aluno.api.controller;

import br.com.senai.aluno.api.model.input.FrequenciaInputDTO;
import br.com.senai.aluno.api.model.output.FrequenciaOutputDTO;
import br.com.senai.aluno.domain.entities.Frequencia;
import br.com.senai.aluno.domain.services.FrequenciaService;
import br.com.senai.aluno.domain.utils.FrequenciaUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/chamadas")
public class FrequenciaController {

    private FrequenciaUtils frequenciaUtils;

    @PutMapping
    public ResponseEntity<List<FrequenciaOutputDTO>> fazerChamada(
            @RequestBody List<FrequenciaInputDTO> frequenciaInputDTOS
    ) throws Exception {
        return ResponseEntity.ok(frequenciaUtils.chamada(frequenciaInputDTOS));
    }

}
