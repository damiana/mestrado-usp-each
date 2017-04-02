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
	public BufferedImage getBufferedAplicarFiltros(int option) {

		BufferedImage b = new BufferedImage(imagem.getBufferedImage().getWidth(), imagem.getBufferedImage().getHeight(), BufferedImage.TYPE_BYTE_GRAY); 

		switch(option)
		{
		case 1:
			b = processarImagemMedia(imagem.getBufferedImage());
			break;
		case 2:
			//pixel = getImageGreaterOrEqualThanMediana(imagem.getPixel(w, h));
			b = processarImagemMediana(imagem.getBufferedImage());
			break;
		case 3:
			b = processarImagemPassaAlta(imagem.getBufferedImage(), "sobel");
			break;
		case 4:
			b = processarImagemPassaAlta(imagem.getBufferedImage(), "roberts");
			break;
			/*  case 5:
                    pixel = getImageGreaterThenAndLessThan(imagem.getPixel(w, h));
                    break;*/
		default:
			b = getPBImage();
		}
		return b;
	}

	// M�todo para C�lculo da Mediana de um vetor de npts pontos
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


	// M�todo para Ler uma janela 3x3 de uma banda de uma imagem de entrada num vetor v.
	// (x,y) representa a coluna e a linha central da janela

	public static void lerJanela3x3(Raster raster, int []v, int x, int y, int banda){


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

	public static BufferedImage processarImagemMediana (BufferedImage ima_in) {

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

				lerJanela3x3(raster,v,x,y,0);
				valornr = CalcularMediana(9,v);

				lerJanela3x3(raster,v,x,y,1);
				valorng = CalcularMediana(9,v);

				lerJanela3x3(raster,v,x,y,2);
				valornb = CalcularMediana(9,v);

				wraster.setSample(x,y,0,(int)(valornr+.5));
				wraster.setSample(x,y,1,(int)(valorng+.5));
				wraster.setSample(x,y,2,(int)(valornb+.5));

			}

		return ima_out;

	}

	public static BufferedImage processarImagemMedia (BufferedImage ima_in) {

		BufferedImage ima_out  = new BufferedImage(ima_in.getWidth(),ima_in.getHeight(),ima_in.getType());

		Raster raster = ima_in.getRaster(); // declara e instancia objeto raster soh para leitura
		WritableRaster wraster = ima_out.getRaster(); // declara e instancia objeto raster para escrita

		int r;
		double valornr, valorng, valornb;
		double p[][]=new double[3][3];

		for(int i=0;i<3;i++)
			for(int j=0; j<3; j++)
				p[i][j]=1.0/9.0;

		for(int y=1; y<ima_in.getHeight()-1; y++)
			for(int x=1; x<ima_in.getWidth()-1; x++){

				r = raster.getSample(x,y,0);  // le dado da banda 0 da imagem de entrada


				//	Filtro de m�dia

				valornr = p[0][0]*(double)raster.getSample(x-1,y-1,0) + p[0][1]*(double)raster.getSample(x,y-1,0) +
						p[0][2]*(double)raster.getSample(x+1,y-1,0) +
						p[1][0]*(double)raster.getSample(x-1,y,0) + p[1][1]*(double)raster.getSample(x,y,0) +
						p[1][2]*(double)raster.getSample(x+1,y,0) +
						p[2][0]*(double)raster.getSample(x-1,y+1,0) + p[2][1]*(double)raster.getSample(x,y+1,0) +
						p[2][2]*(double)raster.getSample(x+1,y+1,0);

				valorng = p[0][0]*(double)raster.getSample(x-1,y-1,1) + p[0][1]*(double)raster.getSample(x,y-1,1) +
						p[0][2]*(double)raster.getSample(x+1,y-1,1) +
						p[1][0]*(double)raster.getSample(x-1,y,1) + p[1][1]*(double)raster.getSample(x,y,1) +
						p[1][2]*(double)raster.getSample(x+1,y,1) +
						p[2][0]*(double)raster.getSample(x-1,y+1,1) + p[2][1]*(double)raster.getSample(x,y+1,1) +
						p[2][2]*(double)raster.getSample(x+1,y+1,1);

				valornb = p[0][0]*(double)raster.getSample(x-1,y-1,2) + p[0][1]*(double)raster.getSample(x,y-1,2) +
						p[0][2]*(double)raster.getSample(x+1,y-1,2) +
						p[1][0]*(double)raster.getSample(x-1,y,2) + p[1][1]*(double)raster.getSample(x,y,2) +
						p[1][2]*(double)raster.getSample(x+1,y,2) +
						p[2][0]*(double)raster.getSample(x-1,y+1,2) + p[2][1]*(double)raster.getSample(x,y+1,2) +
						p[2][2]*(double)raster.getSample(x+1,y+1,2);


				wraster.setSample(x,y,0,(int)(valornr+.5));
				wraster.setSample(x,y,1,(int)(valorng+.5));
				wraster.setSample(x,y,2,(int)(valornb+.5));

				//					if(y<=3 && x<=3)
				//						System.out.println(y+" "+x+"  Valores "+r+"  "+g+"  "+b+" "+valorn);

			}
		return ima_out;

	}

	public BufferedImage processarImagemPassaAlta(BufferedImage ima_in, String filtro) {

		BufferedImage ima_out  = new BufferedImage(ima_in.getWidth(),ima_in.getHeight(),ima_in.getType());

		Raster raster = ima_in.getRaster(); // declara e instancia objeto raster soh para leitura
		WritableRaster wraster = ima_out.getRaster(); // declara e instancia objeto raster para escrita

		// Processa valores da imagem de entrada e armazena na imagem de saida

		double valornr, valorng, valornb;
		int[] v = new int[9];
		double minr, ming, minb, maxr, maxg, maxb;
		minr = ming = minb = 1.0e30;
		maxr = maxg = maxb = -1.0e30;

		for(int y=1; y<ima_in.getHeight()-1; y++)
			for(int x=1; x<ima_in.getWidth()-1; x++){

				//Aplica Filtro

				lerJanela3x3(raster,v,x,y,0);

				valornr = (filtro.equals("sobel")) ? CalcularSobel(9,v) : CalcularRoberts(9,v);
				//valornr = CalcularSobel(9,v);

				if((valornr+=(double)v[4])>255.)valornr = 255.;

				if(valornr < minr) minr = valornr;
				if(valornr > maxr) maxr = valornr;


				lerJanela3x3(raster,v,x,y,1);
				//valorng = CalcularSobel(9,v);
				valorng = (filtro.equals("sobel")) ? CalcularSobel(9,v) : CalcularRoberts(9,v);

				if((valorng+=(double)v[4])>255.)valorng = 255.;

				if(valorng < ming) ming = valorng;
				if(valorng > maxg) maxg = valorng;


				lerJanela3x3(raster,v,x,y,2);
				//valornb = CalcularSobel(9,v);
				valornb = (filtro.equals("sobel")) ? CalcularSobel(9,v) : CalcularRoberts(9,v);

				if((valornb+=(double)v[4])>255.)valornb = 255.;

				if(valornb < minb) minb = valornb;
				if(valornb > maxb) maxb = valornb;

				wraster.setSample(x,y,0,(int)(valornr+.5));
				wraster.setSample(x,y,1,(int)(valorng+.5));
				wraster.setSample(x,y,2,(int)(valornb+.5));

			}
		return ima_out;
	};

	private double CalcularSobel(int npts, int []v){

		double dx2, dy2, m1, m2, result;

		m1 = ((double)v[0]+ 2.0*(double)v[3]+ (double)v[6])/4.;
		m2 = ((double)v[2]+ 2.0*(double)v[5]+ (double)v[8])/4.;

		dx2 = Math.pow((m2-m1),2.);

		m1 = ((double)v[0]+ 2.0*(double)v[1]+ (double)v[2])/4.;
		m2 = ((double)v[6]+ 2.0*(double)v[7]+ (double)v[8])/4.;

		dy2 = Math.pow((m2-m1),2.);

		result = Math.sqrt(dx2+dy2);

		result*=1.5;

		return result;
	}

	public double CalcularRoberts(int npts, int []v){

		double da2, db2, m1, m2, result;

		m1 = (double)v[4] - (double)v[0];

		da2 = Math.pow(m1,2.);

		m2 = (double)v[4] - (double)v[2];

		db2 = Math.pow(m2,2.);

		result = Math.sqrt(da2+db2);

		result*=1.4;

		return result;

	}
}
