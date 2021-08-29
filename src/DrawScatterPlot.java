import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;
  
public class DrawScatterPlot extends JFrame{	   
  private static final long serialVersionUID = 6294689542092367723L;
  
  public DrawScatterPlot(String title) {  
    super(title);  
    
  //�����H���B�����ƪ�200�Ӷü�   
    int[] numArr = new int[200];
    System.out.print("CreateNum\n");
	  for(int i = 0; i < numArr.length; i++)
	    {
	       numArr[i] = i + 1;
	       System.out.print(numArr[i]+" ");
	    }
	  
	  int[] randArr;
	  randArr = getRandom(numArr);             //�N�����ƪ��Ʀr����
	  System.out.print("\nBeforeSort\n");
	  for(int i = 0; i < 200; i++)
       {System.out.print(randArr[i] + " ");}
  
    // Create dataset  
    XYDataset dataset = createDataset(randArr);  
  
    // Create chart  
    JFreeChart chart = ChartFactory.createScatterPlot(  
        "Algo_HW_InsertionSort", "Array index(0-199)", "int - value(1-200)", dataset);  
        
    //Changes background color  
    XYPlot plot = (XYPlot)chart.getPlot();  
    plot.setBackgroundPaint(new Color(255,228,196)); 
    
    //�N�쥻������I�ഫ����Ϊ��I
    XYItemRenderer renderer = plot.getRenderer();
    renderer.setSeriesPaint(0, Color.red);
    renderer.setSeriesShape(0,new Ellipse2D.Double(-2.0, -2.0, 6.0, 6.0));
   
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    panel.setLayout(null);     //This will set your content panel to use absolute layout. This means you'd always have to set your component's bounds explicitly by using setBounds method.
    setContentPane(panel);
    
    //����sort�����s
    JButton b=new JButton("sort");
    b.setBounds(100,// location x 
    		    725,// location y
    		    60,// size width
    		    20); // size height
    
    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Thread(()->{       //()->{} �Y�� new Runnable{public void run(){}}�A�ҥH�g�b()->{}�j�A���������e�Y���쥻�n�g�brun�������e
        		InsertionSort insertionSort = new InsertionSort();
        		insertionSort.Sort(randArr, plot);
      	    }).start();  
        }
    });
    add(b);
  }  
  
  protected static XYDataset createDataset(int[] Array ) {  
    XYSeriesCollection dataset = new XYSeriesCollection();  
 
   //series    
    XYSeries series1 = new XYSeries("Algo_HW");  
    for(int i = 0; i < 200; i++) {
    series1.add(i,Array[i] );  
    }
    dataset.addSeries(series1);  
  
    return dataset;  
  }  
  
  public static int[] getRandom(int[] num)
  {
      int[] arr = new int[200];
      int n;
      for(int i = 0; i < arr.length; i++)
      {
          n = (int)(Math.random()*(200-i));  //Math.random()�|�H�����ͥX0~1�������p��  //��i�O�]���C����@���j��Anum�}�C�������N�|��֤@�ӡA�Ӳ��ͪ�n���i�H��num�}�C�ѤU���̤j��index�٤j
          arr[i] = num[n];
          for(int j = n; j < num.length - 1; j++)
          {
              num[j] = num[j+1];             //��bindex�bn�᭱�����������e�h�@��A�ҥHnum�}�C��index��n�������|�����A�C������o�Ӱj���A�쥻��num�}�C�N�|�֤@�Ӥ���
          }
      }
      return arr;
  }
}  
