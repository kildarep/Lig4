package Lig4;

public class Tabuleiro {
    //Array de posicao
    private int [][] tabuleiro;

    //Getter e Setter
    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    //Construtor
    public Tabuleiro(int[][] i) {
        tabuleiro = i;
    }
    
    //Exibicao do tabuleiro
    public void mostrar(){
        System.out.println("\n (0) (1) (2) (3) (4) (5) (6)");
        //Para cada linha
        for(int i = 0; i < 6; i++){
            System.out.println("|---.---.---.---.---.---.---|");
            //Para cada coluna
            for(int j = 0; j < 7; j++){
                String valor = " ";
                //Verifique se ha uma pe�a
                if (tabuleiro[i][j] == 1) {
                    valor = "1";
                } else if (tabuleiro[i][j] == 2){
                    valor = "2";
                }
                //Mostre o valor da pe�a ou um espa�o vazio
                System.out.print("| " + valor + " ");
            }
            System.out.println("|");
        }
        System.out.println("|===.===.===.===.===.===.===|\n");
    }
    
    //Posicionamento de pe�as
    public int posicionar(int x, int num){
        //Verifique se ha uma pe�a na coluna de baixo para cima
        for (int i = 5; i >= 0; i--){
            //Caso a posi��o esteja vazia
            if (tabuleiro[i][x] == 0){
                //Posicione a pe�a
                tabuleiro[i][x] = num;
                return i;
            }
        }
        //Coluna cheia
        return -1;
    }
}
