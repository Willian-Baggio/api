package biblioteca.api.domain.usuario;

import biblioteca.api.domain.usuario.endereco.Endereco;

public record DadosDetalhamentoUsuarioLivro(Long id, String nomeDoUsuario, String email,
                                            String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoUsuarioLivro(UsuarioLivro usuarioLivro) {
        this(usuarioLivro.getId(), usuarioLivro.getNomeDoUsuario(), usuarioLivro.getEmail(),
                usuarioLivro.getTelefone(), usuarioLivro.getCpf(), usuarioLivro.getEndereco());
    }
}
