package iftm.edu.br.dnolavo.rastreamentoentregas.repository;

import iftm.edu.br.dnolavo.rastreamentoentregas.model.Rastreamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RastreamentoRepository extends JpaRepository<Rastreamento, Long> {
}
