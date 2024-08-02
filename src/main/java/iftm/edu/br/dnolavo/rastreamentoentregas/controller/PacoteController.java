package iftm.edu.br.dnolavo.rastreamentoentregas.controller;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Pacote;
import iftm.edu.br.dnolavo.rastreamentoentregas.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {
    @Autowired
    private PacoteService pacoteService;

    @GetMapping
    public List<Pacote> listarTodos() {
        return pacoteService.listarTodos();
    }

    @PostMapping
    public Pacote adicionar(@RequestBody Pacote pacote) {
        return pacoteService.salvar(pacote);
    }

    @GetMapping("/{id}")
    public Pacote buscarPorId(@PathVariable String id) {
        return pacoteService.buscarPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pacote atualizar(@PathVariable String id, @RequestBody Pacote pacote) {
        return pacoteService.salvar(pacote);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        pacoteService.deletarPorId(id);
    }
}
