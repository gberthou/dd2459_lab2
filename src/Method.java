public class Method {

	public static void sort(int[] array){
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int left, int right) {
        
        int i = left;
        int j = right;
        int pivot = array[(i+j)/2];
        
        // Divide into two arrays
        while (i <= j) {
        	// If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (array[i] < pivot) {
                i++;
            }
            
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (array[j] > pivot) {
                j--;
            }
            
            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            if (i < j) {
                swap(array, i, j);
            }
                //move index to next position on both sides
            i++;
            j--;
        }
        // call quickSort() method recursively
        if (left < j)
            quickSort(array, left, j);
        if (i < right)
            quickSort(array, i, right);
    }
 
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static int binarySearch(int[] array, int key){
    	int x, l, r;
    	l=0;
    	r = array.length-1;
    	do {
    		x = (l+r)/2;
        	if (key < array[x]){
        		r=x-1;
        	} else {
        		l = x+1;
        	}
    	} while (key != array[x] && l <= r);
    	if (key==array[x]){
    		return x;
    	} else {
    		return -1;
    	}
    }
    
    public static int membership(int[] array, int key){
    	sort(array);
    	if (binarySearch(array, key) >=0){
    		return 1;
    	} else {
    		return 0;
    	}
    }
}
