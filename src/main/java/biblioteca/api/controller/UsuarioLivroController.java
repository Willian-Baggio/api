package biblioteca.api.controller;

import biblioteca.api.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario-livro")
public class UsuarioLivroController {

    @Autowired
    UsuarioLivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuarioLivro dados, UriComponentsBuilder uriBuilder) throws BadRequestException {

        if (repository.existsByCpf(dados.getCpf())) {
            throw new BadRequestException("CPF já cadastrado");
        }

        var usuarioLivro = new UsuarioLivro(dados);
        repository.save(usuarioLivro);

        var uri = uriBuilder.path("/usuario-livro/{id}").buildAndExpand(usuarioLivro.getId()).toUri();
        var dto = new DadosDetalhamentoUsuarioLivro(usuarioLivro);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarioLivro>> listar(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuarioLivro::new);;
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuarioLivro dados) {
        var usuarioLivro = repository.getReferenceById(dados.id());
        usuarioLivro.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoUsuarioLivro(usuarioLivro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var usuarioLivro = repository.getReferenceById(id);
        usuarioLivro.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var usuarioLivro = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoUsuarioLivro(usuarioLivro));
    }
}
