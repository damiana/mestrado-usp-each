package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagem {

	private File imagem;
	
    private BufferedImage bufferedImage;
    private double imagemPixel[][];
    private int imagemPixelRGB[];
    private double histograma[] = new double[256];
    private double imagemPixelInline[];

    //private int variancia;
    private boolean escalaCinza;
    
    
    public Imagem(File imagem)
    {
        this.imagem = imagem;
        
        setBufferedImage();
        escalaCinza = escalaCinza();
        
        build();
    }
    
    private boolean escalaCinza() {
        for (int w = 0; w < bufferedImage.getWidth(); w++) {
            for (int h = 0; h < bufferedImage.getHeight(); h++) {
                Color c = new Color(bufferedImage.getRGB(w, h));
                if( (c.getRed() == c.getBlue() && c.getRed() == c.getGreen()) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void setBufferedImage() {
        BufferedImage buffered = null;
        try {
            buffered = ImageIO.read(this.imagem);
        } catch( IOException e ) {
            System.out.println(e.getMessage());
        }
        
        imagemPixelRGB = buffered.getRGB(0, 0, buffered.getWidth(), buffered.getHeight(), null, 0, buffered.getWidth());
        this.bufferedImage = buffered;
    }
    
    private void build() {
        imagemPixelInline = new double[bufferedImage.getWidth() * bufferedImage.getHeight()];
        imagemPixel       = new double[bufferedImage.getWidth()][bufferedImage.getHeight()];
        int i = 0;

        try {
            Raster raster = bufferedImage.getRaster();

            for (int w = 0; w < bufferedImage.getWidth(); w++) {
                for (int h = 0; h < bufferedImage.getHeight(); h++) {
                    if( escalaCinza == false )
                    {
                        int[] pixel = new int[3];
                        for (int k = 0; k < 3; k++) 
                        {
                            pixel[k] = raster.getSample(w, h, k);
                        }
                        imagemPixel[w][h] = getPixelPB(pixel);
                    }
                    else
                    {
                        imagemPixel[w][h] = raster.getSample(w, h, 0);
                    }
                    
                    imagemPixelInline[i++] = imagemPixel[w][h];				
                }
            }

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
        gerarHistograma();
    }

    private void gerarHistograma() {
        for (int w = 0; w < bufferedImage.getWidth(); w++) {
            for (int h = 0; h < bufferedImage.getHeight(); h++) {
                histograma[(int)imagemPixel[w][h]]++;
            }
        }
    }
        
    public static int getPixelPB(int[] vetRGB) {
        long px;
    
        px = Math.round((0.3 * vetRGB[0]) + (0.59 * vetRGB[1]) + (0.11 * vetRGB[2]));
        return (int) px;
    }
    
    public double[] getImagePixelInline() {
        return imagemPixelInline;
    }

    public double getPixel(int x, int y) {
        return imagemPixel[x][y];
    }
    
    public double[] getHistograma() {
        return histograma;
    }
    
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}
