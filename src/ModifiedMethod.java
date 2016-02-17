public class ModifiedMethod {

	/*
	 * Versions:
	 * - 0 Without error
	 * - 1 quickSort, forget to swap values equal to pivot
	 * - 2 quickSort, forget to put the pivot at its final place
	 * - 3 sort from l=1 instead of l=0
	 * - 4 binarySearch initialized with l=1 instead of l=0
	 * - 5 integration error, test if result binary search > 0 instead of >=0
	 * - 6 integration error, forget to sort the array before calling binarySearch
	 */
	
	public static void sort(int[] array, int version){
		if (version == 3){
			quickSort(array, 1, array.length-1, version);
		} else {
			quickSort(array, 0, array.length-1, version);
		}
		
	}
	
	private static void quickSort(int[] array, int left, int right, int version) {
		if (left < right) {
		    int pivot = array[right];
		    //i: final position of pivot
		    int i = left;
		    for(int j = left; j < right; ++j)
			{
		    	if (version == 1){
		    		if(array[j] < pivot)
						swap(array, i++, j);
		    	} else {
		    		if(array[j] <= pivot)
		    			swap(array, i++, j);
		    	}
		    }
		    if (version != 2){
		    	swap(array, i, right);
		    }
		    quickSort(array, left, i - 1, version);
		    quickSort(array, i + 1, right, version);
		}
    }
	
	private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static int binarySearch(int[] array, int key, int version){
    	int x, l, r;
    	if (version == 4){
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
    	if (version != 6){
    		sort(array, version);
    	}
    	if (version == 5){
    		return binarySearch(array, key, version) > 0;
    	} else
    		return binarySearch(array, key, version) >=0;
    }
}
