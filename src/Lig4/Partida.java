package Lig4;
//Classe responsavel pelas verificacoes da partida
public class Partida {

    //Atributos de Partida
    private Jogador jogador1, jogador2, jogadorAtual;
    private Tabuleiro tabuleiro;
    //Booleana para definir se o jogo ainda estÃ¡ acontecendo
    private boolean emProgresso = true;
    //"vencedor" define se hÃ¡ um vencedor e quem
    //"atual" define quem serÃ¡ o prÃ³ximo a jogar
    private int vencedor = 0, atual = 1;

    //Getters e Setters
    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean isEmProgresso() {
        return emProgresso;
    }

    public void setEmProgresso(boolean emProgresso) {
        this.emProgresso = emProgresso;
    }

    public int getVencedor() {
        return vencedor;
    }

    public void setVencedor(int vencedor) {
        this.vencedor = vencedor;
    }

    public int getAtual() {
        return atual;
    }

    public void setAtual(int atual) {
        this.atual = atual;
    }

    //Construtor
    public Partida(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        jogadorAtual = jogador1;
        //Instanciando o tabuleiro com o array em branco
        tabuleiro = new Tabuleiro(new int[6][7]);
    }

    //Método para realizar a jogada na posição recebida
    public int fazerJogada(int x) {
        if (x >= 0 && x <= 6) {
            //Posicionar a peça do jogador "atual" na posicao "x"
            int y = tabuleiro.posicionar(x, atual);
            
            //Se a posição for válida
            if (y != -1) {
                //Verificar se há um ganhador
                int i = verificar(x, y);

                //Informar em caso de empate ou vitória
                if (i == -1) {
                    System.out.println("Jogo empatado.");
                    return 0;
                } else {
                    if (i == atual) {
                        System.out.println("\nVitÃ³ria de " + jogadorAtual.getNome());
                        return 0;
                    }
                }

                //Alternar entre os jogadores
                if (atual == 1) {
                    atual++;
                    jogadorAtual = jogador2;
                } else {
                    atual--;
                    jogadorAtual = jogador1;
                }
                return 1;
            } else {
                //Informar caso a coluna esteja ocupada
                System.out.println("\nJogador " + atual + ", a coluna " + x + " estÃ¡ cheia.");
                return -1;
            }
        } else {
            //Informar caso a entrada seja invÃ¡lida
            System.out.println("\nPor favor, insira um nÃºmero de 0 a 6");
            return -1;
        }
    }

    //Metodo para verificar o status do jogo
    public int verificar(int xi, int yi) {
        int[][] tab = tabuleiro.getTabuleiro();
        int x = xi, y = yi, cont = 1;

        //Verificar vertical cima
        do {
            if (y > 0 && tab[y - 1][x] == atual) {
                y--;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        //Verificar vertical baixo
        do {
            if (y < 5 && tab[y + 1][x] == atual) {
                y++;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        if (cont < 4) {
            cont = 0;
        }
        
        //Verificar horizontal direita
        do {
            if (x < 6 && tab[y][x + 1] == atual) {
                x++;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        //Verificar horizontal esquerda
        do {
            if (x > 0 && tab[y][x - 1] == atual) {
                x--;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        if (cont < 4) {
            cont = 0;
        }
        
        //Verificar diagonal superior direita
        do {
            if (x < 6 && y > 0 && tab[y - 1][x + 1] == atual) {
                y--;
                x++;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        //Verificar diagonal inferior esquerda
        do {
            if (x > 0 && y < 5 && tab[y + 1][x - 1] == atual) {
                y++;
                x--;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        if (cont < 4) {
            cont = 0;
        }
        
        //Verificar diagonal superior esquerda
        do {
            if (x > 0 && y > 0 && tab[y - 1][x - 1] == atual) {
                y--;
                x--;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        //Verificar diagonal inferior direita
        do {
            if (x < 6 && y < 5 && tab[y + 1][x + 1] == atual) {
                y++;
                x++;
                cont++;
            } else {
                x = xi;
                y = yi;
                break;
            }
        } while (cont < 4);

        if (cont == 4) {
            return atual;
        }
        return empate();
    }

    //Metodo para verificar se o tabuleiro esta cheio
    public int empate() {
        int[][] tab = tabuleiro.getTabuleiro();
        //Percorrendo o tabuleiro
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[1].length; j++) {
                //Se houver uma posiÃ§Ã£o 0, o jogo ainda estÃ¡ em andamento.
                if (tab[i][j] == 0) {
                    return 0;
                }
            }
        }
        //Caso todas as posicoes estejam ocupadas, declarar empate
        return -1;
    }
}
