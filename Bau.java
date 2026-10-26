/** Bau: da ouro uma unica vez. */
public class Bau extends Entidade {

    private int ouro;
    private boolean aberto = false;

    public Bau(int x, int y, int ouro) {
        super("Bau", x, y);
        this.ouro = ouro;
    }

    @Override
    public void interagir(Jogador jogador) {
        System.out.println("Voce abriu o bau e encontrou " + ouro + " de ouro!");
        jogador.ganharOuro(ouro);
        aberto = true;
    }

    @Override
    public char simbolo() {
        return 'B';
    }

    @Override
    public boolean ativa() {
        return !aberto;
    }
}
