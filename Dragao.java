/** Dragao: sobrescreve atacar() e as vezes cospe fogo (dano dobrado). */
public class Dragao extends Monstro {

    private int turno = 0;

    public Dragao(int x, int y) {
        super("Dragao", x, y, 35, 4, 50);
    }

    @Override
    public int atacar() {
        turno++;
        if (turno % 3 == 0) {
            System.out.println("  O Dragao cospe FOGO!");
            return ataque * 2;
        }
        return ataque;
    }

    @Override
    public char simbolo() {
        return 'D';
    }
}
