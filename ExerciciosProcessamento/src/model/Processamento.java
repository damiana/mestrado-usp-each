package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

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

	public BufferedImage getBufferedAplicarFiltros2(int option) {
		Color pixel;
		BufferedImage b = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_BYTE_GRAY);  

		for( int w = 0; w < imagem.getBufferedImage().getWidth(); w++ )
		{
			for( int h = 0; h < imagem.getBufferedImage().getHeight(); h++ )
			{
				switch(option)
				{
				case 1:
					pixel = getImageMoreThanMedia(imagem.getPixel(w, h));
					break;
				case 2:
					//pixel = getImageGreaterOrEqualThanMediana(imagem.getPixel(w, h));
					pixel = new Color (ProcessarImagemMediana(imagem.getBufferedImage()).getRGB(w, h));
					break;
					/*case 3:
	                        pixel = getImageGreaterOrEqualThanMediana(imagem.getPixel(w, h));
	                        break;
	                    case 4:
	                        pixel = getImageLessThanMedia(imagem.getPixel(w, h));
	                        break;
	                    case 5:
	                        pixel = getImageGreaterThenAndLessThan(imagem.getPixel(w, h));
	                        break;*/
				default:
					pixel = new Color((int)imagem.getPixel(w, h),(int)imagem.getPixel(w, h),(int)imagem.getPixel(w, h));
				}
				b.setRGB(w, h, pixel.getRGB());
			}
		}
		return b;
	}

	public BufferedImage getBufferedAplicarFiltros(int option) {
		
		BufferedImage b = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_BYTE_GRAY); 
		
		switch(option)
		{
		case 1:
			b = imagem.getBufferedImage();
			break;
		case 2:
			//pixel = getImageGreaterOrEqualThanMediana(imagem.getPixel(w, h));
			b = ProcessarImagemMediana(imagem.getBufferedImage());
			break;
			/*case 3:
                    pixel = getImageGreaterOrEqualThanMediana(imagem.getPixel(w, h));
                    break;
                case 4:
                    pixel = getImageLessThanMedia(imagem.getPixel(w, h));
                    break;
                case 5:
                    pixel = getImageGreaterThenAndLessThan(imagem.getPixel(w, h));
                    break;*/
		default:
			b = imagem.getBufferedImage();
		}
		return b;
	}

	// Método para Cálculo da Mediana de um vetor de npts pontos
	public static double CalcularMediana(int npts, int []v){

		int aux;

		// Ordena em ordem crescente os elementos do vetor

		for(int i=0; i<npts-1; i++)
			for(int j=i+1; j<npts; j++)
				if(v[i] > v[j]){
					aux = v[i]; v[i]=v[j]; v[j]=aux;
				}

		// Define o valor da mediana
		if((npts%2)==0)
			return((double)v[npts/2]);
		else
			return((double)((v[npts/2]+v[npts/2+1])/2.));
	}

	
	  // Método para Ler uma janela 3x3 de uma banda de uma imagem de entrada num vetor v.
	  // (x,y) representa a coluna e a linha central da janela

	    public static void LeJanela3x3(Raster raster, int []v, int x, int y, int banda){


	                v[0] = raster.getSample(x-1,y-1,banda);
	                v[1] = raster.getSample(x  ,y-1,banda);
	                v[2] = raster.getSample(x+1,y-1,banda);
	                v[3] = raster.getSample(x-1,y  ,banda);
	                v[4] = raster.getSample(x  ,y  ,banda);
	                v[5] = raster.getSample(x+1,y  ,banda);
	                v[6] = raster.getSample(x-1,y+1,banda);
	                v[7] = raster.getSample(x  ,y+1,banda);
	                v[8] = raster.getSample(x+1,y+1,banda);

	                return;
	    }

	    public static BufferedImage ProcessarImagemMediana (BufferedImage ima_in) {
	    	
	    	BufferedImage ima_out  = new BufferedImage(ima_in.getWidth(),ima_in.getHeight(),ima_in.getType());
	    	
	    	 // Recupera matriz das imagens de entrada e saida
	        Raster raster = ima_in.getRaster(); // declara e instancia objeto raster soh para leitura
	        WritableRaster wraster = ima_out.getRaster(); // declara e instancia objeto raster para escrita

	    // Processa valores da imagem de entrada e armazena na imagem de saida
	        
	        double valornr, valorng, valornb;
	        int[] v = new int[9];

	        for(int y=1; y<ima_in.getHeight()-1; y++)
	            for(int x=1; x<ima_in.getWidth()-1; x++){

	            	// Aplica Filtro de Mediana 3x3

	                LeJanela3x3(raster,v,x,y,0);
	                valornr = CalcularMediana(9,v);

	                LeJanela3x3(raster,v,x,y,1);
	                valorng = CalcularMediana(9,v);

	                LeJanela3x3(raster,v,x,y,2);
	                valornb = CalcularMediana(9,v);

	                wraster.setSample(x,y,0,(int)(valornr+.5));
	                wraster.setSample(x,y,1,(int)(valorng+.5));
	                wraster.setSample(x,y,2,(int)(valornb+.5));

	            }
	        
			return ima_out;
	    	
	    }
	// a) Valores maiores ou iguais a media recebem 200
	private Color getImageMoreThanMedia(double pixelValue) {
		if(pixelValue >= imagem.getMedia()) {
			return new Color(200, 200, 200);
		}
		else
		{
			return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
		}
	}
	// c) Valores maiores ou iguais a mediana recebem 200.
	private Color getImageGreaterOrEqualThanMediana(double pixelValue)
	{
		if(pixelValue >= imagem.getMediana() )
		{
			return new Color(200,200,200);
		}
		else
		{
			return new Color((int)pixelValue, (int)pixelValue, (int)pixelValue);
		}
	}
}
