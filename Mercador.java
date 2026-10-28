/** Mercador: vende +3 de ataque por 10 de ouro. */
public class Mercador extends Entidade {

    public Mercador(int x, int y) {
        super("Mercador", x, y);
    }

    @Override
    public void interagir(Jogador jogador) {
        System.out.println("[Mercador] \"Quer +3 de ataque? Custa 10 de ouro.\"");
        if (jogador.gastarOuro(10)) {
            jogador.aumentarAtaque(3);
            System.out.println("Você comprou! Ataque atual: " + jogador.getAtaque());
        } else {
            System.out.println("Você não tem ouro suficiente!");
        }
    }

    @Override
    public char simbolo() {
        return 'R';
    }
}