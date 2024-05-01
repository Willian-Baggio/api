package biblioteca.api.domain.usuario;

public record DadosListagemUsuarioLivro(Long id, String nomeDoUsuario, String email, String telefone,
                                        String cpf) {

    public DadosListagemUsuarioLivro(UsuarioLivro usuarioLivro) {
        this(usuarioLivro.getId(), usuarioLivro.getNomeDoUsuario(), usuarioLivro.getEmail(),
                usuarioLivro.getTelefone(), usuarioLivro.getCpf());
    }
}
