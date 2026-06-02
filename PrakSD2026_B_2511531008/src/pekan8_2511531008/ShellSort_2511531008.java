package pekan8_2511531008;

public class ShellSort_2511531008 {

	public static void ShellSort(int[] A_1008) {
		int n_1008 = A_1008.length;
		int gap_1008 = n_1008 /2;
		while(gap_1008 > 0) {
			for(int i_1008 = gap_1008; i_1008 < n_1008; i_1008++) {
				int temp = A_1008[i_1008];
				int j = i_1008;
				while( j >= gap_1008 && A_1008[j-gap_1008] > temp ) {
					A_1008[j] = A_1008[j-gap_1008];
					j = j-gap_1008;
				}
				A_1008[j]= temp;
			}
			gap_1008 = gap_1008/2;
		}
	}
	public static void main (String[] args) {
		int[] data_1008 = {3,10,4,6,8,9,7,2,1,5};
		System.out.print("Sebelum: ");
		printarray(data_1008);
		ShellSort(data_1008);
		System.out.print("Sesudah (shell Sort): ");
		printarray(data_1008);
	}
	public static void printarray(int[] arr_1008) {
		for(int i : arr_1008) System.out.print(i + " ");
		System.out.println();
	}
}
