package biblioteca.api.domain.emprestimo.validacoes;

import biblioteca.api.domain.emprestimo.DadosEmprestimoLivro;
import biblioteca.api.domain.emprestimo.Emprestimo;
import biblioteca.api.domain.emprestimo.EmprestimoRepository;
import biblioteca.api.domain.emprestimo.Status;
import biblioteca.api.domain.livro.Livro;
import biblioteca.api.domain.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidadorEmprestimo implements ValidadorEmprestimoLivro{

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public void validar(DadosEmprestimoLivro dados) {
        if (dados.idLivro() == null) {
            return;
        }

        Livro livro = livroRepository.getReferenceById(dados.idLivro());

        if (livro.getStatus() != Status.DISPONIVEL) {
            throw new RuntimeException("O livro não está disponível");
        }
    }

    public void alteraStatusLivro(Long idLivro) {
        var livro = livroRepository.getReferenceById(idLivro);
        livro.setStatus(Status.EMPRESTADO);
        livroRepository.save(livro);
    }
}
