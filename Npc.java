/** NPC: so conversa. Nao ataca, nao da nada. */
public class Npc extends Entidade {

    private String fala;

    public Npc(String nome, int x, int y, String fala) {
        super(nome, x, y);
        this.fala = fala;
    }

    @Override
    public void interagir(Jogador jogador) {
        System.out.println("[" + nome + "] \"" + fala + "\"");
    }

    @Override
    public char simbolo() {
        return 'N';
    }
}
