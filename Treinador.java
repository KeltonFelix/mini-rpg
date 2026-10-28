/** Treinador: luta com 3 monstros em sequência. */
public class Treinador extends Entidade {

    private final Monstro[] monstros;
    private int atual = 0;

    public Treinador(int x, int y) {
        super("Treinador", x, y);
        monstros = new Monstro[] {
            new Slime(x, y),
            new Slime(x, y),
            new Dragao(x, y)
        };
    }

    @Override
    public void interagir(Jogador jogador) {
        System.out.println("[Treinador] \"Você ousa me desafiar? Enfrente meus 3 monstros!\"");

        while (atual < monstros.length && jogador.estaVivo()) {
            Monstro m = monstros[atual];
            System.out.println("\n--- Monstro " + (atual + 1) + " de 3: " + m.getNome() + " ---");
            m.interagir(jogador);

            if (m.ativa()) {
                // monstro ainda vivo → jogador perdeu o desafio
                break;
            }
            atual++;
        }

        if (atual >= monstros.length) {
            System.out.println("\n[Treinador] \"Impressionante! Você derrotou todos!\"");
            jogador.ganharOuro(40);
            System.out.println("Você ganhou 40 de ouro de recompensa!");
        }
    }

    @Override
    public char simbolo() {
        return 'T';
    }

    @Override
    public boolean ativa() {
        return atual < monstros.length;
    }
}