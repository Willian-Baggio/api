package biblioteca.api.domain.livro;

import biblioteca.api.domain.emprestimo.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "livro")
@Entity(name = "Livro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Integer numeroDePaginas;
    private LocalDateTime anoDaPublicacao;
    private String genero;
    private String editora;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Boolean ativo;

    public Livro(DadosCadastroLivros dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.numeroDePaginas = dados.numeroDePaginas();
        this.anoDaPublicacao = dados.anoDaPublicacao();
        this.genero = dados.genero();
        this.editora = dados.editora();
        this.status = Status.valueOf(dados.status());
    }

    public void atualizarInformacoes(DadosAtualizacaoLivro dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
        if (dados.numeroDePaginas() != null) {
            this.numeroDePaginas = dados.numeroDePaginas();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
