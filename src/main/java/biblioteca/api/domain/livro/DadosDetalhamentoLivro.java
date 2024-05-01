package biblioteca.api.domain.livro;

public record DadosDetalhamentoLivro(Long id, String titulo, String autor, Integer numeroDePaginas) {
    public DadosDetalhamentoLivro(Livro livro) {
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getNumeroDePaginas());
    }
}
