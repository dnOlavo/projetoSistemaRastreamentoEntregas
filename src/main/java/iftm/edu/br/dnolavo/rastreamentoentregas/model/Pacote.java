package iftm.edu.br.dnolavo.rastreamentoentregas.model;

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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Rastreamento> getRastreamentos() {
        return rastreamentos;
    }

    public void setRastreamentos(List<Rastreamento> rastreamentos) {
        this.rastreamentos = rastreamentos;
    }

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
