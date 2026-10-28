/** Interface que define o contrato de interação. */
public interface Interagivel {
    void interagir(Jogador jogador);
    char simbolo();
    boolean ativa();
}