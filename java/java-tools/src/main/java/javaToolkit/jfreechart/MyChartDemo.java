package javaToolkit.jfreechart;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

/**
 * jfreechart支持将饼图散点图柱状图等输出为swing、图片、pdf等多种格式的文件<br>
 * 官网上的examples下载为.jnlp，使用java可执行文件方式打开查看各种图示，但是没有源代码<br>
 * 
 * @link http://www.jfree.org/jfreechart/
 */
public class MyChartDemo {
	public static void main(String[] a) throws IOException {
		barChart3D();
		timeSeriesChart();
		pieChart();
	}

	/**
	 * 生成饼状图，显示
	 */
	private static void pieChart() {
		StandardChartTheme sct = new StandardChartTheme("CN");
		sct.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		sct.setRegularFont(new Font("隶书", Font.BOLD, 20));
		sct.setLargeFont(new Font("隶书", Font.BOLD, 20));
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		ChartFactory.setChartTheme(sct);
		JFreeChart jfreechart = ChartFactory.createPieChart3D("水果产量图", dataset, true, true, true);
		ChartFrame frame = new ChartFrame("报表练习", jfreechart);
		frame.setVisible(true);
		frame.pack();
	}

	/**
	 * 时间轴折线图，显示
	 */
	private static void timeSeriesChart() {
		// 首先构造数据
		TimeSeries timeSeries = new TimeSeries("BMI", Month.class);
		// 时间曲线数据集合
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		// 构造数据集合
		timeSeries.add(new Month(1, 2009), 45);
		timeSeries.add(new Month(2, 2009), 46);
		timeSeries.add(new Month(3, 2009), 1);
		timeSeries.add(new Month(4, 2009), 500);
		timeSeries.add(new Month(5, 2009), 43);
		timeSeries.add(new Month(6, 2009), 324);
		timeSeries.add(new Month(7, 2009), 632);
		timeSeries.add(new Month(8, 2009), 34);
		timeSeries.add(new Month(9, 2009), 12);
		timeSeries.add(new Month(10, 2009), 543);
		timeSeries.add(new Month(11, 2009), 32);
		timeSeries.add(new Month(12, 2009), 225);
		lineDataset.addSeries(timeSeries);
		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "date", "bmi", lineDataset, true, true, true);
		// 增加标题
		chart.setTitle(new TextTitle("XXXBMI指数", new Font("隶书", Font.ITALIC, 15)));
		chart.setAntiAlias(true);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setAxisOffset(new RectangleInsets(10, 10, 10, 10));// 图片区与坐标轴的距离
		plot.setOutlinePaint(Color.PINK);
		plot.setInsets(new RectangleInsets(15, 15, 15, 15));// 坐标轴与最外延的距离
		// plot.setOrientation(PlotOrientation.HORIZONTAL);//图形的方向，包括坐标轴。
		AxisSpace as = new AxisSpace();
		as.setLeft(25);
		as.setRight(25);
		plot.setFixedRangeAxisSpace(as);
		chart.setPadding(new RectangleInsets(5, 5, 5, 5));
		chart.setNotify(true);
		// 设置曲线是否显示数据点
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.INSIDE10, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		// 显示
		ChartFrame frame = new ChartFrame("try1", chart);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * 生成3D柱状图，保存和显示
	 * 
	 * @throws IOException
	 */
	private static void barChart3D() throws IOException {
		// 创建主题样式
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		mChartTheme.setExtraLargeFont(new Font("黑体", Font.BOLD, 20));
		// 设置轴向字体
		mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));
		// 设置图例字体
		mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(mChartTheme);

		// 设置数据集
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "java", "1");
		dataset.addValue(200, "js", "1");
		dataset.addValue(200, "C++", "2");
		dataset.addValue(300, "C", "3");
		dataset.addValue(400, "HTML", "4");
		dataset.addValue(400, "CSS", "5");
		// 生成图片
		JFreeChart chart = ChartFactory.createBarChart3D("编程语言统计", "语言", "学习人数", dataset, PlotOrientation.VERTICAL,
				true, false, false);
		// 保存图片
		ChartUtilities.saveChartAsJPEG(new File("src/main/resources/files/jpeg/1.jpeg"), chart, 800, 500);
		ChartUtilities.saveChartAsPNG(new File("src/main/resources/files/png/1.png"), chart, 800, 500);
		System.out.println("3DBar绘制完成");
		ChartFrame frame = new ChartFrame("barChart", chart);
		frame.pack();
		frame.setVisible(true);
	}

}
