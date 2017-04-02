package view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import controller.Controller;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	/** Criado um novo form  */
	public Main() {
		initComponents();
		getContentPane().setBackground(Color.WHITE); 
		setLocationRelativeTo(null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {

		btnEscolherImagem = new JButton();
		fieldImagemPath = new JTextField();
		panelValues = new JPanel();
		btnHistograma = new JButton();
		lblImagemOriginal = new JLabel();
		lblImagemProcessada = new JLabel();
		jPainel = new JPanel();
		lblTitleTrabalho1 = new JLabel();
		comboFiltros = new JComboBox();
		lblTitleTrabalho2 = new JLabel();
		comboAngulo = new JSpinner();
		btnContrasteIn = new JButton();
		btnContrasteOut = new JButton();
		btnHistogramaFiltro = new JButton();
		btnOriginal = new JButton();
		lblResizebleImage = new JLabel();
		panelProcessedImage = new JScrollPane();
		lblProcessedImage = new JLabel();
		btnVerOriginal = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Processamento Gráfico");
		setBackground(new Color(255, 255, 255));
		setName("mainFrame"); // NOI18N
		setResizable(false);

		btnEscolherImagem.setBackground(new java.awt.Color(251, 252, 252));
		btnEscolherImagem.setForeground(new java.awt.Color(35, 44, 44));
		btnEscolherImagem.setText("Escolher Imagem");
		btnEscolherImagem.setToolTipText("Ao clicar, escolha uma imagem a partir de seu computador");
		btnEscolherImagem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btImageChooserActionPerformed(evt);
			}
		});

		fieldImagemPath.setEnabled(false);
		fieldImagemPath.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fieldImagePathActionPerformed(evt);
			}
		});

		panelValues.setOpaque(false);

		btnHistograma.setText("Histograma");
		btnHistograma.setEnabled(false);
		btnHistograma.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnHistogramaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout panelValuesLayout = new javax.swing.GroupLayout(panelValues);
		panelValues.setLayout(panelValuesLayout);
		panelValuesLayout.setHorizontalGroup(
				panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelValuesLayout.createSequentialGroup()
						.addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnHistograma)
						.addContainerGap())
				);
		panelValuesLayout.setVerticalGroup(
				panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelValuesLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnHistograma))
						.addContainerGap())
				);

		lblImagemOriginal.setText("Imagem Original em tamanho redimensionado");
		lblImagemProcessada.setText("Imagem Processada");

		jPainel.setOpaque(false);

		lblTitleTrabalho1.setText("Filtros");

		comboFiltros.setModel(new DefaultComboBoxModel(new String[] { "P e B", "Media", "Mediana", "Equalização","Sobel", "Roberts" }));
		comboFiltros.setEnabled(false);
		comboFiltros.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboTrabalho1ActionPerformed(evt);
			}
		});

		lblTitleTrabalho2.setText("Contraste");

		comboAngulo.setEnabled(false);
		comboAngulo.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				comboAnguloStateChanged(evt);
			}
		});
		comboAngulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
			public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
				comboAnguloInputMethodTextChanged(evt);
			}
			public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
			}
		});

		btnContrasteIn.setText("+");
		btnContrasteIn.setEnabled(false);
		btnContrasteIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnContrasteInActionPerformed(evt);
			}
		});

		btnContrasteOut.setText("-");
		btnContrasteOut.setEnabled(false);
		btnContrasteOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnContrasteOutActionPerformed(evt);
			}
		});

		btnHistogramaFiltro.setText("Histograma Filtro");
		btnHistogramaFiltro.setEnabled(false);
		btnHistogramaFiltro.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEspelharActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPainel);
		jPainel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblTitleTrabalho1)
								.addComponent(comboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(21, 21, 21)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblTitleTrabalho2)
								.addComponent(btnHistogramaFiltro))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(comboAngulo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnContrasteIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnContrasteOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTitleTrabalho1)
								.addComponent(lblTitleTrabalho2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(comboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(comboAngulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnContrasteIn)
								.addComponent(btnContrasteOut)
								.addComponent(btnHistogramaFiltro))
				.addContainerGap())
				);

		lblResizebleImage.setBorder(null);

		panelProcessedImage.setBackground(new java.awt.Color(255, 255, 255));
		panelProcessedImage.setBorder(null);
		panelProcessedImage.setForeground(new java.awt.Color(255, 255, 255));
		panelProcessedImage.setViewportBorder(null);

		lblProcessedImage.setBackground(new java.awt.Color(255, 255, 255));
		lblProcessedImage.setBorder(null);
		lblProcessedImage.setOpaque(true);
		lblProcessedImage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblProcessedImageMouseEntered(evt);
			}
		});
		panelProcessedImage.setViewportView(lblProcessedImage);

		btnVerOriginal.setText("Ver Original");
		btnVerOriginal.setEnabled(false);
		btnVerOriginal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnVerOriginalActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnEscolherImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(fieldImagemPath))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(lblImagemOriginal)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btnVerOriginal))
												.addComponent(panelValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblResizebleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(layout.createSequentialGroup()
																		.addGap(47, 47, 47)
																		.addComponent(jPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(layout.createSequentialGroup()
																		.addGap(18, 18, 18)
																		.addComponent(lblImagemProcessada)))
														.addGap(80, 92, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
														.addGap(12, 12, 12)
														.addComponent(panelProcessedImage)))))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnEscolherImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldImagemPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblImagemOriginal)
								.addComponent(lblImagemProcessada)
								.addComponent(btnVerOriginal))
						.addGap(2, 2, 2)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblResizebleImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelProcessedImage, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);

		pack();
	}

	private void btImageChooserActionPerformed(java.awt.event.ActionEvent evt) {

		JFileChooser fileChooser =  new JFileChooser();

		fileChooser.setDialogTitle("Abrir Imagem");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int r = fileChooser.showOpenDialog(this);

		if (r != 1) {
			controller = new Controller(this, fileChooser.getSelectedFile());
			btnHistogramaFiltro.setEnabled(true);
			btnHistograma.setEnabled(true);
			btnOriginal.setEnabled(false);
			btnVerOriginal.setEnabled(true);
			btnContrasteIn.setEnabled(false);
			btnContrasteOut.setEnabled(false);
			comboFiltros.setEnabled(true);
			comboAngulo.setEnabled(false);
		}
	}

	private void fieldImagePathActionPerformed(java.awt.event.ActionEvent evt) {}

	private void btnHistogramaActionPerformed(java.awt.event.ActionEvent evt) {
		(new Histograma(controller.getImagem())).setVisible(true);
	}

	private void comboTrabalho1ActionPerformed(java.awt.event.ActionEvent evt) {

		if( comboFiltros.getSelectedIndex() >= 0 && comboFiltros.getSelectedIndex() < 6) {
			controller.aplicarFiltros(comboFiltros.getSelectedIndex());
		}   
	}

	private void lblProcessedImageMouseEntered(java.awt.event.MouseEvent evt) {}

	private void comboAnguloInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {}

	private void comboAnguloStateChanged(javax.swing.event.ChangeEvent evt) {}

	private void btnContrasteInActionPerformed(java.awt.event.ActionEvent evt) { /*TODO implementar contraste */ }

	private void btnContrasteOutActionPerformed(java.awt.event.ActionEvent evt) { /*TODO implementar contraste */ }

	private void btnEspelharActionPerformed(java.awt.event.ActionEvent evt) {

		if( comboFiltros.getSelectedIndex() >= 0 && comboFiltros.getSelectedIndex() < 6)
		{
			controller.aplicarHistogramaFiltros(comboFiltros.getSelectedIndex());
		}
	}

	private void btnVerOriginalActionPerformed(java.awt.event.ActionEvent evt) {
		new ImagemOriginal(controller.getImagem().getBufferedImage());
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* exibicao do form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});


	}

	private javax.swing.JButton btnEscolherImagem;
	private javax.swing.JButton btnHistogramaFiltro;
	private javax.swing.JButton btnHistograma;
	private javax.swing.JButton btnOriginal;
	private javax.swing.JButton btnVerOriginal;
	private javax.swing.JButton btnContrasteIn;
	private javax.swing.JButton btnContrasteOut;
	private javax.swing.JSpinner comboAngulo;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox comboFiltros;
	public javax.swing.JTextField fieldImagemPath;
	private javax.swing.JPanel jPainel;
	private javax.swing.JLabel lblImagemOriginal;
	private javax.swing.JLabel lblImagemProcessada;
	public javax.swing.JLabel lblMedia;
	public javax.swing.JLabel lblMediana;
	public javax.swing.JLabel lblModa;
	public javax.swing.JLabel lblProcessedImage;
	public javax.swing.JLabel lblResizebleImage;
	private javax.swing.JLabel lblTitleTrabalho1;
	private javax.swing.JLabel lblTitleTrabalho2;
	public javax.swing.JScrollPane panelProcessedImage;
	private javax.swing.JPanel panelValues;

}
