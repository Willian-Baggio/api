package biblioteca.api.domain.usuario.validacao;

import biblioteca.api.domain.usuario.DadosCadastroUsuarioLivro;
import biblioteca.api.domain.usuario.UsuarioLivro;
import biblioteca.api.domain.usuario.UsuarioLivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDeCpf implements ValidadorCadastroUsuario{

    @Autowired
    UsuarioLivroRepository repository;

    public void validarCpf(DadosCadastroUsuarioLivro dados) {
        if (repository.existsByCpf(dados.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        repository.save(new UsuarioLivro(dados));
    }
}
