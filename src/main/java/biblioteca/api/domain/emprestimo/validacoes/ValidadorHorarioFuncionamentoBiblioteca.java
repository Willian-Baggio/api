package biblioteca.api.domain.emprestimo.validacoes;

import biblioteca.api.domain.ValidacaoException;
import biblioteca.api.domain.emprestimo.DadosEmprestimoLivro;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ValidadorHorarioFuncionamentoBiblioteca implements ValidadorEmprestimoLivro{

    public void validar(DadosEmprestimoLivro dados) {
        var dataEmprestimo = dados.dataDeEmprestimo();

        var antesDaAberturaDaBiblioteca = dataEmprestimo.getHour() < 9;
        var depoisDoEncerramentoDaBiblioteca = dataEmprestimo.getHour() > 19;

        if (antesDaAberturaDaBiblioteca || depoisDoEncerramentoDaBiblioteca) {
            throw new ValidacaoException(HttpStatus.BAD_REQUEST, "Empréstimo fora do horário de funcionamento da biblioteca");
        }
    }
}
