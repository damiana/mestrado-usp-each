package controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;

import model.Imagem;
import model.Processamento;
import view.Main;

public class Controller {

	 private Main view;
	 private Imagem imagem;
	 private Processamento processamento;
	 
	    public Controller(Main view, File arqImagem)
	    {
	        this.view   = view;
	        this.imagem = new Imagem(arqImagem);
	        this.processamento = new Processamento(this.imagem);

	        view.fieldImagemPath.setText(arqImagem.getAbsolutePath());

	        setValores();
	        setImagemOriginal();
	        setPBImage();
	    }
	    
	    private void setValores() 
	    {        
	        //view.lblModa.setText(String.valueOf(imagem.getModa()));
	        //view.lblVariancia.setText(String.valueOf(imagem.getVariancia()));
	        //view.lblMedia.setText(String.valueOf(imagem.getMedia()));
	        //view.lblMediana.setText(String.valueOf(imagem.getMediana()));
	    }
	    
	    private void setImagemOriginal() 
	    {
	        BufferedImage bf;

	        bf = processamento.getResizeImagem(imagem.getBufferedImage(), view.lblResizebleImage.getWidth(), view.lblResizebleImage.getHeight());
	        view.lblResizebleImage.setIcon( new ImageIcon(bf) );
	    }
	    
	    
	    public void setPBImage(){
	    	setProcessarImagem(processamento.getPBImage());
	    }
	    
	    private void setProcessarImagem(BufferedImage imagem) {
	        view.lblProcessedImage.setIcon(new ImageIcon(processamento.getResizeImagem(imagem, view.panelProcessedImage.getWidth(), 
	        		view.panelProcessedImage.getHeight()) ));
	    }
	    
	    public Imagem getImagem() {
	        return imagem;
	    }
}
