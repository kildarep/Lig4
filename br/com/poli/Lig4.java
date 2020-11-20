package br.com.poli;

// Importacao do pacote lig4
import lig4.*;

// Classe Lig4 (principal)
public class Lig4 {

	// Instanciando interfaces
	public static InterfaceMenu im = new InterfaceMenu();
	public static InterfaceJogo ij = new InterfaceJogo();
	public static InterfaceFimDeJogo ifj = new InterfaceFimDeJogo();

	// Instanciando jogadores e partida
	public static Jogador jogador1, jogador2;
	public static Partida partida;

	// Atributo estatico
	public static int i;

	// Metodo principal
	public static void main(String[] args) {
		im.setVisible(true); // Mostrar menu
	}

	// Metodo que define os jogadores e partidas
	public static void confirmarJogadores(String nome1, String nome2) {
		jogador1 = new Jogador(nome1, 1);
		jogador2 = new Jogador(nome2, 2);
		partida = new Partida(jogador1, jogador2);
	}

	// Metodo para mostrar menu e esconder outras interfaces
	public static void abrirMenu() {
		im.setVisible(true);
		ij.setVisible(false);
		ifj.setVisible(false);
	}

	// Mostrar jogo e esconder outras interfaces
	public static void abrirJogo() {
		im.setVisible(false);
		ij.setVisible(true);
		ifj.setVisible(false);
	}

	// Metodo para mostrar encerramento e esconder outras interfaces
	public static void finalizarJogo() {
		im.setVisible(false);
		ij.setVisible(false);
		ifj.setVisible(true);
	}

}
