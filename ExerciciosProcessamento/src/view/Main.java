package view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class Main extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	 
	public Main() {
	        initComponents();
	        getContentPane().setBackground(Color.WHITE); 
	        setLocationRelativeTo(null);
	    }
	 
	public static void main(String[] args) {
		
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new Main().setVisible(true);
	            }
	        });

	}

	private void initComponents() {
		btnEscolherImagem = new JButton();
		btnHistograma = new JButton();
		btnImagemOriginal = new JButton();
		jPainel = new JPanel();
		tfImagemPath = new JTextField();
	    panelImagemProcessada = new JScrollPane();
	    jPanelValues = new JPanel();
	    lblImagemProcessada = new JLabel();
	    lblImagemOriginal = new JLabel();
	    
	    
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Processamento Gráfico");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("mainFrame"); // NOI18N
        setResizable(false);
        
        btnEscolherImagem.setBackground(new Color(251, 252, 252));
        btnEscolherImagem.setForeground(new Color(35, 44, 44));
        btnEscolherImagem.setText("Escolher Imagem");
        btnEscolherImagem.setToolTipText("Ao clicar, escolha uma imagem a partir de seu computador");
        btnEscolherImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnEscolherImagemrActionPerformed(evt);
            }
        });
        
        tfImagemPath.setEnabled(false);
        tfImagemPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	tfImagemPathActionPerformed(evt);
            }
        });
        
        jPanelValues.setOpaque(false);
        
        btnHistograma.setText("Histograma");
        btnHistograma.setEnabled(false);
        btnHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistogramaActionPerformed(evt);
            }
        });
        
        
        GroupLayout panelValuesLayout = new GroupLayout(jPanelValues);
        jPanelValues.setLayout(panelValuesLayout);

        panelValuesLayout.setHorizontalGroup(
                panelValuesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, panelValuesLayout.createSequentialGroup()
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnHistograma)
                    .addContainerGap())
            );
        
        panelValuesLayout.setVerticalGroup(
                panelValuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelValuesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelValuesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnHistograma))
                    .addContainerGap())
            );
        
        lblImagemOriginal.setText("Imagem Original em tamanho redimensionado");
        lblImagemProcessada.setText("Imagem Processada");
        jPainel.setOpaque(false);

        
        panelImagemProcessada.setBackground(new Color(255, 255, 255));
        panelImagemProcessada.setBorder(null);
        panelImagemProcessada.setForeground(new Color(255, 255, 255));
        panelImagemProcessada.setViewportBorder(null);
        
        lblImagemProcessada.setBackground(new Color(255, 255, 255));
        lblImagemProcessada.setBorder(null);
        lblImagemProcessada.setOpaque(true);
        lblImagemProcessada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProcessedImageMouseEntered(evt);
            }
        });
        panelImagemProcessada.setViewportView(lblImagemProcessada);
        
        btnImagemOriginal.setText("Imagem Original");
        btnImagemOriginal.setEnabled(false);
        btnImagemOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnImagemOriginalActionPerformed(evt);
            }
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
        		 layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createSequentialGroup()
                                 .addComponent(btnEscolherImagem, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(tfImagemPath))
                             .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                     .addGroup(layout.createSequentialGroup()
                                         .addComponent(lblImagemOriginal)
                                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                         .addComponent(btnImagemOriginal))
                                     .addComponent(jPanelValues, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                     .addGroup(layout.createSequentialGroup()
                                         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                             .addGroup(layout.createSequentialGroup()
                                                 .addGap(47, 47, 47)
                                                 .addComponent(jPainel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                             .addGroup(layout.createSequentialGroup()
                                                 .addGap(18, 18, 18)
                                                 .addComponent(lblImagemProcessada)))
                                         .addGap(80, 92, Short.MAX_VALUE))
                                     .addGroup(layout.createSequentialGroup()
                                         .addGap(12, 12, 12)
                                         .addComponent(panelImagemProcessada)))))
                         .addContainerGap())
        );
        
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEscolherImagem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfImagemPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblImagemOriginal)
                        .addComponent(lblImagemProcessada)
                        .addComponent(btnImagemOriginal))
                    .addGap(2, 2, 2)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelImagemProcessada, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jPainel, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelValues, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );
        
        pack();
	}

     
	//botao para escolher a imagem
	private void btnEscolherImagemrActionPerformed(java.awt.event.ActionEvent evt) {
	    
	    JFileChooser file =  new JFileChooser();
	    
	    file.setDialogTitle("Abrir Imagem");
	    file.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    
	    int r = file.showOpenDialog(this);
	    
	    if (r != 1)
	    {
	        //zoom = 0;
	        //controller = new MainController(this, fileChooser.getSelectedFile());
	        //btnEspelhar.setEnabled(true);
	        btnHistograma.setEnabled(true);
	        btnImagemOriginal.setEnabled(true);
	        //btnVerOriginal.setEnabled(true);
	        //btnZoomIn.setEnabled(true);
	        //btnZoomOut.setEnabled(true);
	        //comboTrabalho1.setEnabled(true);
	        //comboAngulo.setEnabled(true);
	    }
	}
	
	private void tfImagemPathActionPerformed(java.awt.event.ActionEvent evt) {
		}
	
	private void lblProcessedImageMouseEntered(java.awt.event.MouseEvent evt) {
	}
	
    private void btnImagemOriginalActionPerformed(java.awt.event.ActionEvent evt) {
        
        //controller.setPBImage();
    	btnImagemOriginal.setEnabled(false);
    }
    private void btnHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistogramaActionPerformed
       // (new Histograma(controller.getImagem())).setVisible(true);
    }

    
	//variaveis do form
	private JPanel jPainel;
	private JButton btnEscolherImagem;
	private JButton btnHistograma;
	private JButton btnImagemOriginal;
	private JScrollPane panelImagemProcessada;
	private JTextField tfImagemPath;
	private JPanel jPanelValues;
	private JLabel lblImagemProcessada;
	private JLabel lblImagemOriginal;
	
	
}
