/**
 * Superclasse abstrata de tudo que "vive" no mapa do mundo.
 * Cada tipo de entidade reage de um jeito diferente quando o jogador interage com ela.
 * Isso e POLIMORFISMO: mesma chamada (interagir), comportamentos diferentes.
 */
public abstract class Entidade implements Interagivel {

    protected String nome;
    protected int x;
    protected int y;

    public Entidade(String nome, int x, int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    /** Cada subclasse DEVE decidir o que acontece na interacao. */
    public abstract void interagir(Jogador jogador);

    /** Letra mostrada no mapa. Subclasses podem sobrescrever. */
    public char simbolo() {
        return '?';
    }

    /** Se a entidade ja foi "resolvida" (bau aberto, monstro derrotado), some do mapa. */
    public boolean ativa() {
        return true;
    }

    public String getNome() { return nome; }
    public int getX() { return x; }
    public int getY() { return y; }
}