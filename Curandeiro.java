/**
 * ATIVIDADE DOS ALUNOS (parte 1):
 * O Curandeiro cura o jogador de graca na primeira vez e depois cobra 5 de ouro.
 */
public class Curandeiro extends Entidade {

    private boolean primeiraVez = true;

    public Curandeiro(int x, int y) {
        super("Curandeiro", x, y);
    }

    @Override
    public void interagir(Jogador jogador) {
        if (primeiraVez) {
            // Cura grátis na primeira visita
            System.out.println("[Curandeiro] \"Primeira consulta é de graça!\"");
            jogador.curar(15);
            primeiraVez = false;
        } else {
            // A partir da segunda visita cobra 5 de ouro
            System.out.println("[Curandeiro] \"Custa 5 de ouro para curar.\"");
            if (jogador.gastarOuro(5)) {
                jogador.curar(15);
                System.out.println("Você foi curado!");
            } else {
                System.out.println("Você não tem ouro suficiente!");
            }
        }
    }

    @Override
    public char simbolo() {
        return 'C';
    }
}