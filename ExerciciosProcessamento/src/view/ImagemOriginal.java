package view;

import java.awt.Container;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImagemOriginal extends JFrame {

	private static final long serialVersionUID = 1L;

	public ImagemOriginal(BufferedImage imagem) {

		int width  = imagem.getWidth();
        int height = imagem.getHeight();

        setTitle("Imagem Original");
        setBounds(0, 0, width, height);

        Container content = getContentPane();
        JLabel lblImagem = new JLabel(new ImageIcon(imagem));
        lblImagem.setBounds(0, 0, width, height);
        content.add(lblImagem);
        
        setLayout(null);
        setLocationRelativeTo(null);
        
        setResizable( false );
        setVisible( true );
        setDefaultCloseOperation( HIDE_ON_CLOSE );

	}
}
