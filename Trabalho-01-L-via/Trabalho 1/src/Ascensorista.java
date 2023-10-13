package entidades;

import java.util.List;

/**
 * Classe que define o comportamento do Ascensorista.
 * <br><br>
 * O Ascensorista coordena as ações do elevador e dos animais, verificando as
 * condições e tomando decisões adequadas.
 * <br><br>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Ascensorista {

    /**
     * Método que coordena as ações do Ascensorista.
     * 
     * @param elevador O elevador
     * @param animais  Lista de animais para transportar
     */
    public void agir(Elevador elevador, List<Animal> animais) {
        if (elevador.getQuantidadeAnimais() == 0) {
            elevador.alagar();
        }

        for (Animal animal : animais) {
            try {
                if (elevador.condicoesSatisfatorias(animal)) {
                    if (elevador.podeEntrar(animal)) {
                        elevador.embarcar(animal);
                    }
                }
            } catch (Exception e) {
                System.out.println("Animal #" + animal.getId() + " não pôde entrar: " + e.getMessage());
            }
        }

        if (elevador.getQuantidadeAnimais() > 0) {
            elevador.drenar();
        }

        elevador.mover();
    }

    /**
     * Método que coordena as ações do Ascensorista com ajuste de temperatura.
     * 
     * @param elevador O elevador
     * @param animais  Lista de animais para transportar
     */
    public void agirComTemperatura(Elevador elevador, List<Animal> animais) {
        if (elevador.getQuantidadeAnimais() == 0) {
            elevador.alagar();
        }

        for (Animal animal : animais) {
            int diferencaTemperatura = Math.abs(elevador.getTemperaturaAtual() - animal.getTemperaturaIdeal());

            if (diferencaTemperatura > 15) {
                elevador.ajustarTemperatura(animal.getTemperaturaIdeal());
            }

            try {
                if (elevador.condicoesSatisfatorias(animal)) {
                    if (elevador.podeEntrar(animal)) {
                        elevador.embarcar(animal);
                    }
                }
            } catch (Exception e) {
                System.out.println("Animal #" + animal.getId() + " não pôde entrar: " + e.getMessage());
            }
        }

        if (elevador.getQuantidadeAnimais() > 0) {
            elevador.drenar();
        }

        elevador.mover();
    }
}
