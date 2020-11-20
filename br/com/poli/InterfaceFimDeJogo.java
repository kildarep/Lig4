package br.com.poli;

// Classe fimDeJogo (interface grafica) que estende javax.swing 
public class InterfaceFimDeJogo extends javax.swing.JFrame {

	// Atributos
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;

	// Construtor
	public InterfaceFimDeJogo() {
		initComponents();
	}

	// Inicializacao de cada componente
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Dialog", 1, 52));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Vitória do jogador 1");

		jButton1.setFont(new java.awt.Font("Dialog", 1, 18));
		jButton1.setText("Novo Jogo");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jButton1MousePressed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Dialog", 1, 18));
		jButton2.setText("Sair");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jButton2MousePressed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Dialog", 1, 24));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("(Nome do jogador)");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(120, 120, 120)
						.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2)
						.addGap(51, 51, 51)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
								.addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}

	// Metodo para encerrar o jogo
	private void jButton2MousePressed(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	// Metodo para reiniciar o jogo
	private void jButton1MousePressed(java.awt.event.MouseEvent evt) {
		Lig4.i = 0;
		Lig4.abrirMenu(); // Mostrar menu
	}

	// Metodo principal
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(InterfaceFimDeJogo.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InterfaceFimDeJogo.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InterfaceFimDeJogo.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InterfaceFimDeJogo.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InterfaceFimDeJogo().setVisible(true);
			}
		});
	}

	// Metodo para encerrar a partida
	public void encerrar() {

		// Se a partida terminar em empate
		if (Lig4.partida.empate() != 0) {
			jLabel1.setText("EMPATE!");
			jLabel2.setText("Ninguem venceu");
			Lig4.finalizarJogo();
		}
		// Informar o jogador vencedor
		if (Lig4.i == 1) {
			jLabel1.setText("Vitoria do jogador 1!");
			jLabel2.setText(Lig4.jogador1.getNome());
			Lig4.finalizarJogo();
		} else if (Lig4.i == 2) {
			jLabel1.setText("Vitoria do jogador 2!");
			jLabel2.setText(Lig4.jogador2.getNome());
			Lig4.finalizarJogo();
		}
	}

}
