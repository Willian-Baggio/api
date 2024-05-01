package biblioteca.api.domain.usuario;

import biblioteca.api.domain.usuario.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuarioLivro(

        @NotNull
        Long id,
        String nomeDoUsuario,
        String email,
        String telefone,
        DadosEndereco endereco
) {
}
