package view;

import java.awt.event.WindowEvent;

import model.Imagem;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Histograma extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	Imagem imagem;

    public Histograma(Imagem imagem) {
    	
        super("Histograma");

        this.imagem = imagem;
        final JFreeChart chart = createChart();

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        setContentPane(chartPanel);

        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
    }

    private JFreeChart createChart() {
        HistogramDataset dataset = new HistogramDataset();
        double[] n = imagem.getImagePixelInline();
        dataset.addSeries("Pixels", imagem.getImagePixelInline(), 256,0.0,256.0);

        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma", // chart title
                "Pixels", // domain axis label
                "Quantidade", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                false, // include legend
                false, // tooltips?
                false // URLs?
        );
        return chart;
    }

    public void windowClosing(final WindowEvent evt) {
        if(evt.getWindow() == this) {
            dispose();
        }
    }
}