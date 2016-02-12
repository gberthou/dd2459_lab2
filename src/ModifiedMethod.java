public class ModifiedMethod {

	/*
	 * Versions:
	 * - 0 Without error
	 * - 1 binarySearch initialized with l=1 instead of l=0
	 * - 2 sort from l=1 instead of l=0
	 * - 3 integration error, test if result binary search > 0 instead
	 * 		of >=0
	 */
	
	public static void sort(int[] array, int version){
		if (version == 2){
			quickSort(array, 1, array.length-1, version);
		} else {
			quickSort(array, 0, array.length-1, version);
		}
		
	}
	
	private static void quickSort(int[] array, int left, int right, int version) {
        int i = left;
        int j = right;
        int pivot = array[(i+j)/2];
        while (i <= j) {
        	while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
            i++;
            j--;
        }
        if (left < j)
            quickSort(array, left, j, version);
        if (i < right)
            quickSort(array, i, right, version);
    }
	
	private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static int binarySearch(int[] array, int key, int version){
    	int x, l, r;
    	if (version ==1){
    		l=1;
    	} else {
    		l=0;
    	}
    	r = array.length-1;
    	do {
    		x = (l+r)/2;
        	if (key < array[x]){
        		r=x-1;
        	} else {
        		l=x+1;
        	}
    	} while (key != array[x] && l <= r);
    	if (key==array[x]){
    		return x;
    	} else {
    		return -1;
    	}
    }
    
    public static boolean membership(int[] array, int key, int version){
    	sort(array, version);
    	if (version == 3){
    		return binarySearch(array, key, version) > 0;
    	} else
    		return binarySearch(array, key, version) >=0;
    }
}
