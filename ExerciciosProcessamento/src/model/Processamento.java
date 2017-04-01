package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Processamento {

	  private BufferedImage bufferImage;
	    private Imagem imagem;
	    
	    public Processamento(Imagem imagem) {
	        this.imagem = imagem;
	    }
	    
	    public BufferedImage getPBImage() {        
	        bufferImage = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_BYTE_GRAY);  
	        for( int w = 0; w < imagem.getBufferedImage().getWidth(); w++ ) {
	            for( int h = 0; h < imagem.getBufferedImage().getHeight(); h++ )
	            {
	                bufferImage.setRGB(w, h, imagem.getBufferedImage().getRGB(w, h));
	            }
	        }
	        return bufferImage;
	    }

	    public BufferedImage getPBImage(BufferedImage imagem) {        
	        bufferImage = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);  
	        for( int w = 0; w < imagem.getWidth(); w++ ) {
	            for( int h = 0; h < imagem.getHeight(); h++ ) {
	                bufferImage.setRGB(w, h, imagem.getRGB(w, h));
	            }
	        }
	        return bufferImage;
	    }
	    
	    public BufferedImage getResizeImagem(BufferedImage imagem, int width, int height) {
	    	Double novaImgLargura = (double) imagem.getWidth();  
	        Double novaImgAltura = (double) imagem.getHeight();
	        		//resize(BufferedImage imagem, Integer imgLargura, Integer imgAltura) 
	        Double imgProporcao;  
	        if (novaImgLargura >= width) { 
	            imgProporcao = (novaImgAltura / novaImgLargura);  
	            novaImgLargura = (double) width;  
	            novaImgAltura = (novaImgLargura * imgProporcao);  

	            while (novaImgAltura > height) {  
	                novaImgLargura = (double) (--width);  
	                novaImgAltura = (novaImgLargura * imgProporcao);  
	            }
	        } 
	        else if (novaImgAltura >= height) 
	        {  
	            imgProporcao = (novaImgLargura / novaImgAltura);  
	            novaImgAltura = (double) height;  
	            while (novaImgLargura > width) {  
	                novaImgAltura = (double) (--height);  
	                novaImgLargura = (novaImgAltura * imgProporcao);  
	            }  
	        }  
	        
	        BufferedImage novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), imagem.getType());  
	        
	        Graphics g = novaImagem.getGraphics();  
	        g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), Image.SCALE_SMOOTH), 0, 0, null);  
	        g.dispose(); 
	        
	        return novaImagem;
	    }
}
