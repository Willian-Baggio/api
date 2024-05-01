package biblioteca.api.domain.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosEmprestimoLivro(
        @NotNull
        Long idLivro,

        @NotNull
        Long idUsuario,

        @NotNull
        @Future
        LocalDateTime dataDeEmprestimo,

        @NotNull
        @Future
        LocalDateTime dataDeDevolucao,

        @NotNull
        Status status

        ) {
}
