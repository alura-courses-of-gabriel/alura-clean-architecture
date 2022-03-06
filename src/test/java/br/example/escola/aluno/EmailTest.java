package br.example.escola.aluno;

import br.example.escola.dominio.aluno.Email;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void naoDeveCriarEmailComEnderecoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("nao-eh-um-email"));
    }

    @Test
    public void deveCriarEmailValido(){
        String enderecoEsperado = "gabriel.menezes@ufms.br";
        Email email = new Email(enderecoEsperado);

        Assertions.assertNotNull(email);
        assertEquals(email.getEndereco(), enderecoEsperado);
    }


}