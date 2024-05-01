package biblioteca.api.domain.emprestimo.validacoes;

import biblioteca.api.domain.emprestimo.DadosEmprestimoLivro;

public interface ValidadorEmprestimoLivro {

    void validar(DadosEmprestimoLivro dados);
}
