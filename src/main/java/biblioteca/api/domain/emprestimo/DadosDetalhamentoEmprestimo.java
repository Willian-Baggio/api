package biblioteca.api.domain.emprestimo;

import java.time.LocalDateTime;

public record DadosDetalhamentoEmprestimo(Long id, Long idLivro, Long idUsuario,
                                          LocalDateTime dataDeEmprestimo, LocalDateTime dataDeDevolucao,
                                          Status status
) {
    public DadosDetalhamentoEmprestimo(Emprestimo emprestimo) {
        this(emprestimo.getId(), emprestimo.getLivro().getId(), emprestimo.getUsuario().getId(),
                emprestimo.getDataDeEmprestimo(), emprestimo.getDataDeDevolucao(),
                emprestimo.getStatus());
    }
}
