package biblioteca.api.domain.emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("""
            SELECT e
            FROM Emprestimo e
            WHERE e.livro.id = :idLivro
            AND e.status IN ('EMPRESTADO', 'ATRASADO')
            """)
    List<Emprestimo> findEmprestimosByLivroIdAndStatus(Long idLivro);
}
