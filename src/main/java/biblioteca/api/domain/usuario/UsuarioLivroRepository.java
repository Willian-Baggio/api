package biblioteca.api.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLivroRepository extends JpaRepository<UsuarioLivro, Long> {
    Page<UsuarioLivro> findAllByAtivoTrue(Pageable paginacao);

    boolean existsByCpf(String cpf);
}
