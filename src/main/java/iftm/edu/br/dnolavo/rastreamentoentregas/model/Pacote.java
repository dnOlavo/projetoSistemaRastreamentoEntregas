package iftm.edu.br.dnolavo.rastreamentoentregas.model;

import javax.persistence.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pacote {
    @Id
    private String id;
    private String destinatario;
    private String status;

    @ManyToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL)
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    public Pacote() {}

    public Pacote(String id, String destinatario, Endereco endereco, String status) {
        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.status = status;
    }

    // Getters e Setters

    public void atualizarStatus(String novoStatus, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento(new Date(), novoStatus, localizacao, this);
        this.rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n")
          .append("Destinatário: ").append(destinatario).append("\n")
          .append("Endereço: ").append(endereco.getEnderecoCompleto()).append("\n")
          .append("Status: ").append(status).append("\n")
          .append("Rastreamentos: \n");

        for (Rastreamento rastreamento : rastreamentos) {
            sb.append(rastreamento.getResumo()).append("\n");
        }
        return sb.toString();
    }
}
