/** Armadilha: causa 5 de dano ao pisar. */
public class Armadilha extends Entidade {

    public Armadilha(int x, int y) {
        super("Armadilha", x, y);
    }

    @Override
    public void interagir(Jogador jogador) {
        System.out.println("[Armadilha] Você caiu em uma armadilha!");
        jogador.receberDano(5);
        System.out.println("Você perdeu 5 de vida. Vida atual: " + jogador.getVida());
    }

    @Override
    public char simbolo() {
        return 'A';
    }
}