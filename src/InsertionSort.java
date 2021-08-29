import org.jfree.chart.plot.XYPlot;

public class InsertionSort {
	public void Sort(int[] Array, XYPlot plot) {
		//insertionSort 
       	int n = Array.length;  
        for (int j = 1; j < n; j++) {  
            int key = Array[j];  
            int i = j-1;  
            while ( (i > -1) && ( Array[i] > key ) ) {  
                Array[i+1] = Array[i];  
                i--;  
            }  
            Array[i+1] = key;
            
            plot.setDataset(DrawScatterPlot.createDataset(Array));  //更新Dataset，即更新圖
            try {
				Thread.sleep(10);    // 暫停0.01秒
			} 
            catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } 
        System.out.print("\nAfterSort\n");  //印出來檢查是否排序成功
        for (int j = 0; j < n; j++) {    
      	  System.out.print(Array[j] +" ");
        }  
	}
}
