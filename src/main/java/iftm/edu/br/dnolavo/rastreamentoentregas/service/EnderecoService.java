package iftm.edu.br.dnolavo.rastreamentoentregas.service;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Endereco;
import iftm.edu.br.dnolavo.rastreamentoentregas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}

