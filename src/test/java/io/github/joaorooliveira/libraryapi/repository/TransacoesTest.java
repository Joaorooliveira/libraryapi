package io.github.joaorooliveira.libraryapi.repository;

import io.github.joaorooliveira.libraryapi.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService transacaoService;

    // Commit -> confirma as alteracoes
    // Rollback -> desfaz as alteracoes
    @Test
    void transacaoSimples() {
        transacaoService.executar();
    }
}
