package iftm.edu.br.dnolavo.rastreamentoentregas.controller;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Endereco;
import iftm.edu.br.dnolavo.rastreamentoentregas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    @PostMapping
    public Endereco adicionar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }
}

