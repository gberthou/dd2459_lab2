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
		/* args format:
		 * java Main <version> <arraySize> <array> <key>
		 *
		 * Output: 0 if key in array
		 *         1 if key not in array
		 */
		
		if(args.length < 4)
			System.out.println("Usage: java Main <version> <arraySize> <array> <key>");
		else
		{
			int version = Integer.parseInt(args[0]);
			int arraySize = Integer.parseInt(args[1]);
			if(args.length < arraySize + 3)
				System.out.println("Too few commandline arguments");
			else
			{
				int[] array = new int[arraySize];
				int key = Integer.parseInt(args[2 + arraySize]);
				for(int i = 0; i < arraySize; ++i)
				{
					array[i] = Integer.parseInt(args[2 + i]);
				}

				boolean result = ModifiedMethod.membership(array, key, version);
				System.out.println(result ? "1" : "0");
			}
		}
	}

}
