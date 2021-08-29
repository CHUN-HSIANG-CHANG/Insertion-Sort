import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

//jdkª©¥»:jdk-15
//ÃB¥~®M¥ó:jfreechart-1.5.3

public class Main {  

	  public static void main(String[] args) throws InterruptedException{  
		   
		    SwingUtilities.invokeLater(() -> {  
		      DrawScatterPlot example = new DrawScatterPlot("Algorithm_HW");  
		      example.setSize(800, 800);  
		      example.setLocationRelativeTo(null);  
		      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
		      example.setVisible(true); 
		    } );  
		  }  

}
