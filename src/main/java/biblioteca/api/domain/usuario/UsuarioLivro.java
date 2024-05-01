package biblioteca.api.domain.usuario;

import biblioteca.api.domain.usuario.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "usuario_livro")
@Entity(name = "UsuarioLivro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoUsuario;
    private String email;
    private String telefone;
    private String cpf;
    private LocalDateTime dataDeRegistro;

    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public UsuarioLivro(DadosCadastroUsuarioLivro dados) {
        this.ativo = true;
        this.nomeDoUsuario = dados.nomeDoUsuario();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.dataDeRegistro = dados.dataDeRegistro();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuarioLivro dados) {
        if (dados.nomeDoUsuario() != null) {
            this.nomeDoUsuario = dados.nomeDoUsuario();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
