package iftm.edu.br.dnolavo.rastreamentoentregas.service;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Rastreamento;
import iftm.edu.br.dnolavo.rastreamentoentregas.repository.RastreamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RastreamentoService {
    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Rastreamento> listarTodos() {
        return rastreamentoRepository.findAll();
    }

    public Rastreamento salvar(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }
}

