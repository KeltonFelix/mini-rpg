/**
 * ATIVIDADE DOS ALUNOS (parte 1):
 * O Curandeiro cura o jogador de graca na primeira vez e depois cobra 5 de ouro.
 *
 * Passos:
 *  1. Faca esta classe estender Entidade (ja esta).
 *  2. Implemente interagir(): use jogador.curar(...) e jogador.gastarOuro(...).
 *  3. Sobrescreva simbolo() para devolver 'C'.
 *  4. Descomente a linha do Curandeiro em Jogo.java e teste.
 */
public class Curandeiro extends Entidade {

    private boolean primeiraVez = true;

    public Curandeiro(int x, int y) {
        super("Curandeiro", x, y);
    }

    @Override
    public void interagir(Jogador jogador) {
        // TODO: implementar a cura (gratis na primeira vez, 5 de ouro depois)
        System.out.println("[Curandeiro] (ainda nao implementado)");
    }

    // TODO: sobrescrever simbolo() para devolver 'C'
}
