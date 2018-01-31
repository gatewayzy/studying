package _programming.instance;

public class SortUsingZero {
	public static void main(String[] args) {
		int[] array = new int[]{3,8,2,4,5,0,1,7,9,6};
		sort(array, array.length);
		for (int i : array) {
			System.out.print(i+" ");
		}

	}
	
	 /**
     * 通过调用swapWithZero方法来排
     * 
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public static void sort(int[] array, int len) {
        // 完成这个函数
        // special
        if(null == array || array.length < 2 || len <2){
            return;
        }
        
        // find 0 and swap to index0
        for(int i = 0; i < len; i++){
            if(array[i] == 0){
                array[i] = array[0];
                array[0] = 0;
                break;
            }
        }
        
        // straight selection comparator
        for(int i = 1; i < len; i++){
        	for(int j=i; j < len; j++){
            	if(array[j] == i){
               		swap(array,i,j);
                	j++;
            	}
        	}
        }
        
    }
    
    // use 0 to swap
    public static void swap(int [] array, int i, int j){
        array[0] = array[i];
        array[i] = array[j];
        array[j] = array[0];
        array[0] = 0;
        return;
    }
	
}
