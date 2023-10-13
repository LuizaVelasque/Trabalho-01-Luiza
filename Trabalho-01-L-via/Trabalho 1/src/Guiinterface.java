import entidades.Elevador;
import entidades.Animal;

import java.util.List;

public interface Guiinterface {

    void mostrarStatusElevador(Elevador elevador);

    void mostrarStatusAnimais(List<Animal> animais);

    void mostrarMensagem(String mensagem);

    List<Animal> obterListaAnimais();

    int obterAndarDesejado();

    int obterTemperaturaIdeal();

    Object clone() throws CloneNotSupportedException;

    boolean equals(Object obj);

    void finalize() throws Throwable;

    int hashCode();

    String toString();
}
