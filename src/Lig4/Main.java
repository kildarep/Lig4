package Lig4;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //Instanciando entrada
        Scanner entrada = new Scanner(System.in);

        //Vari√°veis de fluxo
        String nome;
        int pos, i;
        Jogador jogador1, jogador2;
        boolean emAndamento = true;

        //Instanciando jogadores e partida
        System.out.print("Insira o nome do primeiro jogador: ");
        nome = entrada.nextLine();
        jogador1 = new Jogador(nome, 1);
        System.out.print("Insira o nome do segundo jogador: ");
        nome = entrada.nextLine();
        jogador2 = new Jogador(nome, 2);
        Partida partida = new Partida(jogador1, jogador2);

        //Mostrando informacoes iniciais
        System.out.println("\n" + jogador1 + "\n" + jogador2);
        partida.getTabuleiro().mostrar();

        //Repeticao principal
        do {
            //Perguntar a posi√ß√£o desejada ao jogador
            System.out.print(partida.getJogadorAtual().getNome() + ", insira a posiÁ„o desejada: ");
            pos = Integer.parseInt(entrada.nextLine());
            
            //Tentar fazer a jogada
            i = partida.fazerJogada(pos);

            //Exibir tabuleiro
            partida.getTabuleiro().mostrar();
            
            //Finalizar jogo em caso de empate ou vitoria
            if (i == 0){
                emAndamento = false;
            }
        } while (emAndamento);
    }

}
