/** Chefe: versão mais forte do Dragão. */
public class Chefe extends Dragao {

    public Chefe(int x, int y) {
        super(x, y);
        this.nome = "Chefe";
        this.vida = 50;
        this.ataque = 6;
        this.recompensa = 80;
    }

    @Override
    public int atacar() {
        System.out.println("  O Chefe cospe FOGO INFERNAL!");
        return ataque * 2;
    }

    @Override
    public char simbolo() {
        return 'H';
    }
}