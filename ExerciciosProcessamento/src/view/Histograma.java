package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Imagem;
import model.Processamento;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Histograma extends ApplicationFrame {

	private static final long serialVersionUID = 1L;
	Imagem imagem;
	private BufferedImage imagemFiltro;
	private HistogramDataset dataset;
	private XYBarRenderer renderer;
	private static final int BINS = 256;

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


	public Histograma(BufferedImage imagem) {
		super("Histograma de Filtros");
		this.imagemFiltro = imagem;
	}

	private ChartPanel createChartPanel() {

		dataset = new HistogramDataset();
		Raster raster = this.imagemFiltro.getRaster();
		final int w = this.imagemFiltro.getWidth();
		final int h = this.imagemFiltro.getHeight();
		double[] r = new double[w * h];

		// vetor de pixels da imagem. Tirado do BufferedImage
		int pixelsImage []  = this.imagemFiltro.getRGB(0, 0, w, h, null, 0, w);
		// pegando o histograma
		double[] histogram = Processamento.getMatrixHistogramGrayScale(pixelsImage, h, w);

		r = raster.getSamples(0, 0, w, h, 0, r);
		dataset.addSeries("Vermelho", r, BINS);

		r = raster.getSamples(0, 0, w, h, 1, r);
		dataset.addSeries("Verde", r, BINS);

		r = raster.getSamples(0, 0, w, h, 2, r);
		dataset.addSeries("Azul", r, BINS);

		System.out.println("aaaaaaaaa " + histogram);
		
		//dataset.addSeries("Pixels", imagem.getImagePixelInline(), 256,0.0,256.0);
		
		// chart
		JFreeChart chart = ChartFactory.createHistogram(
				"Histograma de Filtros", 
				"Pixels",
				"Quantidade",
				dataset, 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false);


		XYPlot plot = (XYPlot) chart.getPlot();
		renderer = (XYBarRenderer) plot.getRenderer();
		renderer.setBarPainter(new StandardXYBarPainter());

		// translucent red, green & blue
		Paint[] paintArray = {
				new Color(0x80ff0000, true),
				new Color(0x8000ff00, true),
				new Color(0x800000ff, true)
		};
		plot.setDrawingSupplier(new DefaultDrawingSupplier(
				paintArray,
				DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
				DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
		ChartPanel panel = new ChartPanel(chart);
		panel.setMouseWheelEnabled(true);
		return panel;
	}

	private JPanel createControlPanel() {
		JPanel panel = new JPanel();
		panel.add(new JCheckBox(new VisibleAction(0)));
		panel.add(new JCheckBox(new VisibleAction(1)));
		panel.add(new JCheckBox(new VisibleAction(2)));
		return panel;
	}

	private JFreeChart createChart() {
		HistogramDataset dataset = new HistogramDataset();
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

	private class VisibleAction extends AbstractAction {

		private static final long serialVersionUID = 1L;
		private final int i;

		public VisibleAction(int i) {
			this.i = i;
			this.putValue(NAME, (String) dataset.getSeriesKey(i));
			this.putValue(SELECTED_KEY, true);
			renderer.setSeriesVisible(i, true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			renderer.setSeriesVisible(i, !renderer.getSeriesVisible(i));
		}
	}

	public void display() {
		JFrame f = new JFrame("Histograma de Filtros");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.add(createChartPanel());
		f.add(createControlPanel(), BorderLayout.SOUTH);
		f.add(new JLabel(new ImageIcon(this.imagemFiltro)), BorderLayout.WEST);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}