package biblioteca.api.domain;

import org.springframework.http.HttpStatus;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(HttpStatus badRequest, String mensagem) {
        super(mensagem);
    }
}
