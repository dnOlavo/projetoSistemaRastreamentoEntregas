package iftm.edu.br.dnolavo.rastreamentoentregas.repository;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteRepository extends JpaRepository<Pacote, String> {
}
