package biblioteca.api.domain.emprestimo;

import biblioteca.api.domain.ValidacaoException;
import biblioteca.api.domain.emprestimo.validacoes.ValidadorEmprestimo;
import biblioteca.api.domain.livro.LivroRepository;
import biblioteca.api.domain.usuario.UsuarioLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaEmprestimo {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioLivroRepository usuarioLivroRepository;

    @Autowired
    private List<ValidadorEmprestimo> validadores;

    public DadosDetalhamentoEmprestimo emprestar(DadosEmprestimoLivro dados) {

        if (!livroRepository.existsById(dados.idLivro())) {
            throw new ValidacaoException(HttpStatus.BAD_REQUEST, "id do livro informado não existe");
        }

        if (!usuarioLivroRepository.existsById(dados.idUsuario())) {
            throw new ValidacaoException(HttpStatus.BAD_REQUEST, "id do usuário informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));

        validadores.forEach(v -> v.alteraStatusLivro(dados.idLivro()));

        var livro = livroRepository.findById(dados.idLivro()).get();
        var usuario = usuarioLivroRepository.findById(dados.idUsuario()).get();
        var emprestimo = new Emprestimo(livro, usuario, dados.dataDeEmprestimo(),
                dados.dataDeDevolucao());

        emprestimoRepository.save(emprestimo);
        return new DadosDetalhamentoEmprestimo(emprestimo);
    }
}
