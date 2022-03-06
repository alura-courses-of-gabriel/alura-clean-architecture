package br.example.escola.aluno;

import br.example.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void naoDeveCriarTelefoneInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("9", "9999999"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("9999", "9999999999"));
    }

    @Test
    public void deveCriarTelefoneValido(){
        String ddd = "067";
        String numero = "99999999";
        Telefone telefone = new Telefone(ddd, numero);

        Assertions.assertNotNull(telefone);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }

}