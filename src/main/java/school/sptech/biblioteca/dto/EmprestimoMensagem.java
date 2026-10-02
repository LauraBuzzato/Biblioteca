package school.sptech.biblioteca.dto;

import java.time.LocalDate;

public class EmprestimoMensagem {

    private Long emprestimoId;
    private String nomeLivro;
    private String nomeCliente;
    private String emailCliente;
    private LocalDate dataEmprestimo;

    public EmprestimoMensagem() {
    }

    public EmprestimoMensagem(Long emprestimoId,
                              String nomeLivro,
                              String nomeCliente,
                              String emailCliente,
                              LocalDate dataEmprestimo) {

        this.emprestimoId = emprestimoId;
        this.nomeLivro = nomeLivro;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Long getEmprestimoId() {
        return emprestimoId;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
}
