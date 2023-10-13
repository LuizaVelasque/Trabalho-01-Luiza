package testes;

public import entidades.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AscensoristaTest {

    private Elevador elevador;
    private Ascensorista ascensorista;
    private List<Animal> animais;

    @Before
    public void setUp() {
        elevador = new Elevador();
        ascensorista = new Ascensorista();
        animais = new ArrayList<>();
    }

    @Test
    public void testAgirSemTemperatura() {
        Animal animal1 = new Mamifero(1, "Leão", "Felidae", 1, 100, 20);
        Animal animal2 = new Ave(2, "Papagaio", "Psittacidae", 1, 1, 20);
        Animal animal3 = new Peixe(3, "Tubarão", "Selachimorpha", 1, 500, 20);

        animais.add(animal1);
        animais.add(animal2);
        animais.add(animal3);

        ascensorista.agir(elevador, animais);

        assertEquals(3, elevador.getQuantidadeAnimais());
        assertEquals(1, elevador.getAndar());
        assertEquals(20, elevador.getTemperaturaAtual());
        assertEquals(1001, elevador.getPesoAnimais());
    }

    @Test
    public void testAgirComTemperatura() {
        Animal animal1 = new Mamifero(1, "Leão", "Felidae", 1, 100, 10);
        Animal animal2 = new Ave(2, "Papagaio", "Psittacidae", 1, 1, 30);
        Animal animal3 = new Peixe(3, "Tubarão", "Selachimorpha", 1, 500, 15);

        animais.add(animal1);
        animais.add(animal2);
        animais.add(animal3);

        ascensorista.agirComTemperatura(elevador, animais);

        assertEquals(3, elevador.getQuantidadeAnimais());
        assertEquals(1, elevador.getAndar());
        assertEquals(15, elevador.getTemperaturaAtual());
        assertEquals(601, elevador.getPesoAnimais());
    }
}
 {
    
}
