package biblioteca.api.controller;

import biblioteca.api.domain.emprestimo.AgendaEmprestimo;
import biblioteca.api.domain.emprestimo.DadosEmprestimoLivro;
import biblioteca.api.domain.livro.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

    @Autowired
    private AgendaEmprestimo emprestimo;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity emprestar(@RequestBody @Valid DadosEmprestimoLivro dados) {
        var dto = emprestimo.emprestar(dados);
        return ResponseEntity.ok(dto);
    }
}
