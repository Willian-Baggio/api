package biblioteca.api.domain.usuario;

import biblioteca.api.domain.usuario.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DadosCadastroUsuarioLivro(
    @NotBlank
    String nomeDoUsuario,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telefone,

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
    String cpf,

    @NotNull
    LocalDateTime dataDeRegistro,

    @NotNull @Valid
    DadosEndereco endereco
) {

    public String getCpf() {
        return cpf;
    }
}
