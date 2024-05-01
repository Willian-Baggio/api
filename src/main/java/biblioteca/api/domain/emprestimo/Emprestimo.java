package biblioteca.api.domain.emprestimo;

import biblioteca.api.domain.livro.Livro;
import biblioteca.api.domain.usuario.UsuarioLivro;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Table(name = "emprestimo")
@Entity(name = "Emprestimo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioLivro usuario;

    private LocalDateTime dataDeEmprestimo;
    private LocalDateTime dataDeDevolucao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Emprestimo(Livro livro, UsuarioLivro usuario, LocalDateTime localDateTime, LocalDateTime localDateTime1) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataDeEmprestimo = localDateTime;
        this.dataDeDevolucao = localDateTime1;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
