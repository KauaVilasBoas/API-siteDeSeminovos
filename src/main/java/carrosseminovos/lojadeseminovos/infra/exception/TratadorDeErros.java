package carrosseminovos.lojadeseminovos.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErroDeEntidadeNaoEncontrada(){
        return ResponseEntity.badRequest().body("Entidade não encontrada");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity tratarErroDeTipoDeArgumento(){
        return ResponseEntity.badRequest().body("Verifique se os dados do parametro estão corretos");
    }

}
