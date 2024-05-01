package biblioteca.api.domain.livro;

import biblioteca.api.domain.emprestimo.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DadosCadastroLivros(

        @NotBlank
        String titulo,

        @NotBlank
        String autor,

        @NotNull
        Integer numeroDePaginas,

        LocalDateTime anoDaPublicacao,

        @NotBlank
        String genero,

        @NotBlank
        String editora,

        @Valid
        @NotBlank
        @Pattern
        (regexp = "DISPONIVEL|EMPRESTADO|DEVOLVIDO|INDISPONIVEL|ATRASADO") String status
        ) {
}
