import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Mini-RPG de mundo aberto em modo texto.
 * Mova-se com W A S D (e Enter). Ande ate uma entidade para interagir com ela.
 * Digite Q para sair.
 */
public class Jogo {

    private static final int LARGURA = 12;
    private static final int ALTURA = 8;

    private final List<Entidade> mundo = new ArrayList<>();
    private final Jogador jogador = new Jogador("Ash", 0, 0);

    public Jogo() {
        // Tudo e guardado como "Entidade": o tipo real so aparece na hora de interagir.
        mundo.add(new Npc("Prof. Carvalho", 2, 1, "Cuidado com o Dragao la no canto!"));
        mundo.add(new Bau(5, 2, 15));
        mundo.add(new Bau(9, 6, 30));
        mundo.add(new Slime(4, 4));
        mundo.add(new Slime(8, 1));
        mundo.add(new Dragao(11, 7));
        mundo.add(new Curandeiro(1, 5));

        // ===== ATIVIDADE 2 =====
        mundo.add(new Armadilha(3, 3));      // Fácil
        mundo.add(new Mercador(6, 4));       // Médio
        mundo.add(new Chefe(10, 6));         // Médio
        mundo.add(new Treinador(7, 5));      // Bônus
    }

    public void jogar() {
        System.out.println("=== MINI RPG: POLIMORFISMO ===");
        System.out.println("Mova com W/A/S/D + Enter. Q para sair.\n");

        // try-with-resources: o Scanner e fechado automaticamente ao sair do bloco
        try (Scanner entrada = new Scanner(System.in)) {
            while (jogador.estaVivo()) {
                desenharMapa();
                System.out.println(jogador.status());
                System.out.print("> ");
                if (!entrada.hasNextLine()) {
                    break;
                }
                String comando = entrada.nextLine().trim().toLowerCase();
                if (comando.equals("q")) {
                    break;
                }
                mover(comando);

                if (!temInimigoVivo()) {
                    System.out.println("\nVoce derrotou todos os monstros! VITORIA!");
                    return;
                }
            }
        }
        if (!jogador.estaVivo()) {
            System.out.println("\nVoce foi derrotado... GAME OVER.");
        }
    }

    private void mover(String comando) {
        int dx = 0;
        int dy = 0;
        switch (comando) {
            case "w": dy = -1; break;
            case "s": dy = 1; break;
            case "a": dx = -1; break;
            case "d": dx = 1; break;
            default:
                System.out.println("Comando invalido.");
                return;
        }
        int novoX = jogador.getX() + dx;
        int novoY = jogador.getY() + dy;
        if (novoX < 0 || novoX >= LARGURA || novoY < 0 || novoY >= ALTURA) {
            System.out.println("Voce nao pode sair do mapa.");
            return;
        }
        jogador.setPosicao(novoX, novoY);

        Entidade alvo = entidadeEm(novoX, novoY);
        if (alvo != null) {
            // >>> O MOMENTO DO POLIMORFISMO <<<
            alvo.interagir(jogador);
            System.out.println();
        }
    }

    private Entidade entidadeEm(int x, int y) {
        for (Entidade e : mundo) {
            if (e.ativa() && e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }

    private boolean temInimigoVivo() {
        for (Entidade e : mundo) {
            if (e instanceof Monstro && e.ativa()) {
                return true;
            }
        }
        return false;
    }

    private void desenharMapa() {
        for (int y = 0; y < ALTURA; y++) {
            StringBuilder linha = new StringBuilder();
            for (int x = 0; x < LARGURA; x++) {
                char c = '.';
                Entidade e = entidadeEm(x, y);
                if (e != null) {
                    c = e.simbolo();
                }
                if (jogador.getX() == x && jogador.getY() == y) {
                    c = '@';
                }
                linha.append(c).append(' ');
            }
            System.out.println(linha);
        }
    }

    public static void main(String[] args) {
        new Jogo().jogar();
    }
}