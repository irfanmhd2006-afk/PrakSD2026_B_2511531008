package pekan7_2511531008;

public class SelectionSort_2511531008 {
	public static void SelectionSort_2511531008(int[] arr_1008) {
		int n_1008= arr_1008.length;
		for(int i_1008 = 0; i_1008 < n_1008; i_1008++) {
			int minIndex_1008 = i_1008 ;
			for(int j_1008 = i_1008 + 1; j_1008 < n_1008; j_1008++) {
				if(arr_1008[j_1008] < arr_1008[minIndex_1008]) {
					minIndex_1008 = j_1008;
				}
			}
			int temp_1008 = arr_1008[i_1008];
			arr_1008[i_1008] = arr_1008[minIndex_1008];
			arr_1008[minIndex_1008] = temp_1008;
		}
	}
	public static void main(String[] args) {
		int arr_1008[] = {23,78,45,8,32,56,1};
		int n_1008 = arr_1008.length;
		System.out.printf("array yang belum terurut : \n" );

		for(int i_1008 = 0; i_1008 < n_1008; i_1008++) {
			System.out.print(arr_1008[i_1008] + " ");
		}
		System.out.println("");
		SelectionSort_2511531008(arr_1008);
		System.out.printf("array yang terurut:\n");
		for(int i_1008 = 0; i_1008 < n_1008; i_1008++) {
			System.out.print(arr_1008[i_1008] + " ");
		}
		System.out.println("");
	}
}
