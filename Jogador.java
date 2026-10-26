public class Jogador {

    private String nome;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int ouro;
    private int x;
    private int y;

    public Jogador(String nome, int x, int y) {
        this.nome = nome;
        this.vidaMaxima = 30;
        this.vida = vidaMaxima;
        this.ataque = 6;
        this.ouro = 0;
        this.x = x;
        this.y = y;
    }

    public void receberDano(int dano) {
        vida = Math.max(0, vida - dano);
    }

    public void curar(int quantidade) {
        vida = Math.min(vidaMaxima, vida + quantidade);
    }

    public void ganharOuro(int quantidade) {
        ouro += quantidade;
    }

    public boolean gastarOuro(int quantidade) {
        if (ouro >= quantidade) {
            ouro -= quantidade;
            return true;
        }
        return false;
    }

    public void aumentarAtaque(int quantidade) {
        ataque += quantidade;
    }

    public boolean estaVivo() { return vida > 0; }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void setPosicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque() { return ataque; }
    public int getOuro() { return ouro; }
    public int getX() { return x; }
    public int getY() { return y; }

    public String status() {
        return nome + " | Vida: " + vida + "/" + vidaMaxima
                + " | Ataque: " + ataque + " | Ouro: " + ouro;
    }
}
