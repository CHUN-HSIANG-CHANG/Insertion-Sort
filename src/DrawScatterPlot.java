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
    
  //產生隨機且不重複的200個亂數   
    int[] numArr = new int[200];
    System.out.print("CreateNum\n");
	  for(int i = 0; i < numArr.length; i++)
	    {
	       numArr[i] = i + 1;
	       System.out.print(numArr[i]+" ");
	    }
	  
	  int[] randArr;
	  randArr = getRandom(numArr);             //將不重複的數字打亂
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
    
    //將原本的方形點轉換成圓形的點
    XYItemRenderer renderer = plot.getRenderer();
    renderer.setSeriesPaint(0, Color.red);
    renderer.setSeriesShape(0,new Ellipse2D.Double(-2.0, -2.0, 6.0, 6.0));
   
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    panel.setLayout(null);     //This will set your content panel to use absolute layout. This means you'd always have to set your component's bounds explicitly by using setBounds method.
    setContentPane(panel);
    
    //產生sort的按鈕
    JButton b=new JButton("sort");
    b.setBounds(100,// location x 
    		    725,// location y
    		    60,// size width
    		    20); // size height
    
    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	new Thread(()->{       //()->{} 即為 new Runnable{public void run(){}}，所以寫在()->{}大括號內的內容即為原本要寫在run中的內容
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
          n = (int)(Math.random()*(200-i));  //Math.random()會隨機產生出0~1之間的小數  //減i是因為每執行一次迴圈，num陣列的元素就會減少一個，而產生的n不可以比num陣列剩下的最大的index還大
          arr[i] = num[n];
          for(int j = n; j < num.length - 1; j++)
          {
              num[j] = num[j+1];             //把在index在n後面的元素都往前搬一格，所以num陣列中index為n的元素會消失，每次執行這個迴圈後，原本的num陣列就會少一個元素
          }
      }
      return arr;
  }
}  
