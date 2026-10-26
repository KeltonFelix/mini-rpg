/**
 * Monstro: luta contra o jogador ate um dos dois cair.
 * Possui um metodo "habilidadeEspecial" que as subclasses podem sobrescrever.
 */
public class Monstro extends Entidade {

    protected int vida;
    protected int ataque;
    protected int recompensa;

    public Monstro(String nome, int x, int y, int vida, int ataque, int recompensa) {
        super(nome, x, y);
        this.vida = vida;
        this.ataque = ataque;
        this.recompensa = recompensa;
    }

    /** Dano causado em cada turno do monstro. Subclasses podem mudar o comportamento. */
    public int atacar() {
        return ataque;
    }

    @Override
    public void interagir(Jogador jogador) {
        System.out.println("Um " + nome + " selvagem apareceu! (vida " + vida + ")");
        while (vida > 0 && jogador.estaVivo()) {
            vida -= jogador.getAtaque();
            System.out.println("  Voce atacou " + nome + " (-" + jogador.getAtaque() + ")");
            if (vida <= 0) {
                break;
            }
            int dano = atacar(); // <- chamada polimorfica: cada monstro ataca do seu jeito
            jogador.receberDano(dano);
            System.out.println("  " + nome + " atacou voce (-" + dano + ")  | sua vida: " + jogador.getVida());
        }
        if (vida <= 0) {
            System.out.println(nome + " foi derrotado! Voce ganhou " + recompensa + " de ouro.");
            jogador.ganharOuro(recompensa);
        }
    }

    @Override
    public char simbolo() {
        return 'M';
    }

    @Override
    public boolean ativa() {
        return vida > 0;
    }
}
