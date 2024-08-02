package iftm.edu.br.dnolavo.rastreamentoentregas.service;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Pacote;
import iftm.edu.br.dnolavo.rastreamentoentregas.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {
    @Autowired
    private PacoteRepository pacoteRepository;

    public List<Pacote> listarTodos() {
        return pacoteRepository.findAll();
    }

    public Optional<Pacote> buscarPorId(String id) {
        return pacoteRepository.findById(id);
    }

    public Pacote salvar(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public void deletarPorId(String id) {
        pacoteRepository.deleteById(id);
    }
}

