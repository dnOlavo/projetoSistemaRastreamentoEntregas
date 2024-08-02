package iftm.edu.br.dnolavo.rastreamentoentregas.controller;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Rastreamento;
import iftm.edu.br.dnolavo.rastreamentoentregas.service.RastreamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
public class RastreamentoController {
    @Autowired
    private RastreamentoService rastreamentoService;

    @GetMapping
    public List<Rastreamento> listarTodos() {
        return rastreamentoService.listarTodos();
    }
}

