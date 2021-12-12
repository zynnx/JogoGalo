/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodogalo;

/**
 *
 * @author Mário Seabra
 */
public class JogoGalo {

    String[][] m = {{"1", "2", "3"},
    {"4", "5", "6"},
    {"7", "8", "9"}};

    public static int Random() {
        int p = (int) (Math.random() * 9);
        return p;
    }
    

    public String Mostrar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("  " + m[i][j]);
            }
            System.out.println("");
        }
        return null;
    }

    public boolean Verificar(String posisao) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (m[i][j].equals(posisao)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void Jogada(String posicao, String joga) {
        switch (posicao) {
            case "1":
                m[0][0] = joga;
                break;
            case "2":
                m[0][1] = joga;
                break;
            case "3":
                m[0][2] = joga;
                break;
            case "4":
                m[1][0] = joga;
                break;
            case "5":
                m[1][1] = joga;
                break;
            case "6":
                m[1][2] = joga;
                break;
            case "7":
                m[2][0] = joga;
                break;
            case "8":
                m[2][1] = joga;
                break;
            case "9":
                m[2][2] = joga;
                break;
            default:
                break;
        }
    }

    public String Ganhou(int jogadas) {
        String[] T = new String[8];
        String vencedor = "null";
        if (jogadas == 9) {
            vencedor = "EMPATE!!";
        }

        T[0] = m[0][0] + m[0][1] + m[0][2];
        T[1] = m[1][0] + m[1][1] + m[1][2];
        T[2] = m[2][0] + m[2][1] + m[2][2];

        T[3] = m[0][0] + m[1][0] + m[2][0];
        T[4] = m[0][1] + m[1][1] + m[2][1];
        T[5] = m[0][2] + m[1][2] + m[2][2];

        T[6] = m[0][0] + m[1][1] + m[2][2];
        T[7] = m[0][2] + m[1][1] + m[2][0];

        for (int i = 0; i < T.length; i++) {
            if (T[i].equals("XXX")) {
                vencedor = "Jogador 1 venceu";
            } else if (T[i].equals("OOO")) {
                vencedor = "Jogador 2 venceu";
            }
        }
        return vencedor;
    }
}
