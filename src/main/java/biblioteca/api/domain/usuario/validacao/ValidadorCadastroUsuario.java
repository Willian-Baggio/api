package biblioteca.api.domain.usuario.validacao;

import biblioteca.api.domain.usuario.DadosCadastroUsuarioLivro;

public interface ValidadorCadastroUsuario {

    void validarCpf(DadosCadastroUsuarioLivro dados);
}
