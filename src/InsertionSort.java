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
            
            plot.setDataset(DrawScatterPlot.createDataset(Array));  //��sDataset�A�Y��s��
            try {
				Thread.sleep(10);    // �Ȱ�0.01��
			} 
            catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } 
        System.out.print("\nAfterSort\n");  //�L�X���ˬd�O�_�ƧǦ��\
        for (int j = 0; j < n; j++) {    
      	  System.out.print(Array[j] +" ");
        }  
	}
}
