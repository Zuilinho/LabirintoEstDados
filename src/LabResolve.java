import java.util.LinkedList;

public class LabResolve {

    static int[][] labirinto = {
            { 1, 0, 1, 1, 1, 1 },
            { 1, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 1, 1, 2 }
    };

    /*
     * static int[][] labirinto =
     * {
     * { 1, 0, 2, 1, 1, 1 },
     * { 1, 0, 1, 0, 0, 0 },
     * { 0, 0, 1, 0, 0, 0 },
     * { 0, 0, 1, 0, 0, 0 },
     * { 0, 0, 1, 2, 0, 0 }
     * };
     */

    /*
     * static int[][] labirinto = {
     * { 1, 0, 2, 1, 1, 1 },
     * { 1, 0, 1, 0, 0, 0 },
     * { 0, 0, 1, 0, 0, 0 },
     * { 0, 0, 1, 0, 0, 0 },
     * { 0, 0, 1, 2, 0, 0 }
     * };
     */

    // 0 = parede
    // 1 = caminho
    // 2 = destino
    // para testar o labirinto basta alterar a posicao inicial do caminho

    static LinkedList<Posicao> caminho = new LinkedList<Posicao>();

    public static void main(String[] args) {
        Posicao p = new Posicao(0, 5);

        caminho.push(p);

        while (true) {

            int y = caminho.peek().y;
            int x = caminho.peek().x;
            labirinto[y][x] = 0;

            // baixo
            if (labirinto[y + 1][x] == 2) {
                System.out.println("Para baixo. Você venceu!");
                return;
            } else if (labirinto[y + 1][x] == 1) {
                System.out.println("Para baixo.");
                caminho.push(new Posicao(y + 1, x));
                continue;
            }
            // esquerda
            if (labirinto[y][x - 1] == 2) {
                System.out.println("Para esquerda. Você venceu!");
                return;
            } else if (labirinto[y][x - 1] == 1) {
                System.out.println("Para esquerda.");
                caminho.push(new Posicao(y, x - 1));
                continue;
            }
            // cima
            if (labirinto[y + 1][x] == 2) {
                System.out.println("Para cima. Você venceu!");
                return;
            } else if (labirinto[y - 1][x] == 1) {
                System.out.println("Para cima.");
                caminho.push(new Posicao(y - 1, x));
                continue;
            }
            // direita
            if (labirinto[y][x + 1] == 2) {
                System.out.println("Para direita. Você venceu!");
                return;
            } else if (labirinto[y][x + 1] == 1) {
                System.out.println("Para direita.");
                caminho.push(new Posicao(y, x + 1));
                continue;
            }

            caminho.pop();
            if (caminho.size() < 0) {
                System.out.println("Sem caminho!");
            }

        }
    }
}
