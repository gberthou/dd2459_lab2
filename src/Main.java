
public class Main {
	
	public static void printArray(int[] array){
		if (array == null){
			System.out.println("The array is empty.");
		}
		else {
			System.out.print("[" + array[0]);
			for (int i = 1; i < array.length; i++){
				System.out.print(";" + array[i]);
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,1,3,5,4};
		printArray(array);
		Method.sort(array);
		printArray(array);
		int key = 6;
		System.out.println("Binary Search for " + key + ": " +
				Method.binarySearch(array, key));
	}

}
