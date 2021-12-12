/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodogalo;

import java.util.Scanner;

/**
 *
 * @author Mário Seabra
 */
public class JogoDoGalo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        JogoGalo jogo = new JogoGalo();
        MatrixFixa fixa= new MatrixFixa();// tentar copiar matriz
        String posisao; 
        int posisaoCpu;
        int valido = 0, jogadas = 0, escolha;
        do { 
            System.out.println("Jogo do Galo");
            System.out.println("1 - Jogador vs Jogador");
            System.out.println("2 - Jogador vs CPU");
            System.out.println("0 - Sair");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.println("Nao e um numero. Por favor tenta outra vez!!!");
            }
            escolha = ler.nextInt();

            switch (escolha) {
                case 1:
                    while (true) {
                        System.out.println("---------------JOGO DO GALO---------------");
                        jogo.Mostrar();

                        do {//jogador 1
                            System.out.println("Jogador 1, informe a posicao que quer jogar: ");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.err.println("Nao e um numero. Por favor tenta outra vez!!!");
                            }
                            posisao = ler.next();

                            while (!jogo.Verificar(posisao)) {
                                System.out.println("Jogada Invalida, tente novamente");
                                System.out.println("Jogador 1, informe a posicao que quer jogar: ");
                                posisao = ler.next();
                                valido = 0;
                            }
                            jogo.Jogada(posisao, "X");
                            valido = 1;
                        } while (valido == 0);
                        jogo.Mostrar();
                        jogadas++;
                        valido = 0;

                        if (!jogo.Ganhou(jogadas).equals("null")) {
                            break;
                        }

                        do {//jogador 2
                            System.out.println("Jogador 2, informe a posicao que quer jogar: ");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.err.println("Nao e um numero. Por favor tenta outra vez!!!");
                            }
                            posisao = ler.next();

                            while (!jogo.Verificar(posisao)) {
                                System.out.println("Jogada Invalida, tente novamente");
                                System.out.println("Jogador 2, informe a posicao que quer jogar: ");
                                posisao = ler.next();
                                valido = 0;
                            }
                            jogo.Jogada(posisao, "O");
                            valido = 1;
                        } while (valido == 0);
                        jogadas++;
                        valido = 0;
                        if (!jogo.Ganhou(jogadas).equals("null")) {
                            break;
                        }
                    }
                    System.out.println("O " + jogo.Ganhou(jogadas));
                    jogo.Mostrar();
                    
                    break;
                case 2:
                    while (true) {
                        System.out.println("---------------JOGO DO GALO---------------");
                        jogo.Mostrar();

                        do {//jogador 1
                            System.out.println("Jogador 1, informe a posicao que quer jogar: ");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.err.println("Nao e um numero. Por favor tenta outra vez!!!");
                            }
                            posisao = ler.next();

                            while (!jogo.Verificar(posisao)) {
                                System.out.println("Jogada Invalida, tente novamente");
                                System.out.println("Jogador 1, informe a posicao que quer jogar: ");
                                posisao = ler.next();
                                valido = 0;
                            }
                            jogo.Jogada(posisao, "X");
                            valido = 1;
                        } while (valido == 0);
                        jogo.Mostrar();
                        jogadas++;
                        valido = 0;

                        if (!jogo.Ganhou(jogadas).equals("null")) {
                            break;
                        }

                        do {//jogador CPU
                            System.out.println("Jogador 2, CPU escolheu: ");
                            posisaoCpu = jogo.Random();

                            while (!jogo.Verificar(Integer.toString(posisaoCpu))) {
                                posisaoCpu = jogo.Random();
                                valido = 0;
                            }
                            jogo.Jogada(Integer.toString(posisaoCpu), "O");
                            valido = 1;
                        } while (valido == 0);
                        jogadas++;
                        valido = 0;
                        if (!jogo.Ganhou(jogadas).equals("null")) {
                            break;
                        }
                    }
                    System.out.println("O " + jogo.Ganhou(jogadas));
                    jogo.Mostrar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Essa escolha nao existe");
                    break;
            }
        } while (escolha != 0);
    }

}
