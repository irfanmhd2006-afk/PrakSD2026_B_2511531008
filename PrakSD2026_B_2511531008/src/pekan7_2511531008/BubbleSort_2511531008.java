package pekan7_2511531008;

public class BubbleSort_2511531008 {
	public static void BubbleSort_2511531008(int[] arr_1008) {
		int n_1008 = arr_1008.length;
		for(int i_1008 = 0; i_1008 < n_1008; i_1008++) {
			for(int j_1008 = 0; j_1008 < n_1008-1-i_1008; j_1008++) {
				if(arr_1008[j_1008] > arr_1008[j_1008+1]) {
					int temp_1008 = arr_1008[j_1008];
					arr_1008[j_1008] = arr_1008[j_1008+1];
					arr_1008[j_1008+ 1] = temp_1008; 
					//System.out.prtinln("data :" + arr_1008[j] + " "+ arr_1008[j+1]) 
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr_1008[] = {23,78,45,8,32,56,1};
		int n_1008 = arr_1008.length;
		System.out.printf("arr_1008ay yang belum terurut : \n" );

		for(int i = 0; i < n_1008; i++) {
			System.out.print(arr_1008[i] + " ");
		}
		System.out.println("");
		BubbleSort_2511531008(arr_1008);
		System.out.printf("arr_1008ay yang terurut:\n");
		for(int i = 0; i < n_1008; i++) {
			System.out.print(arr_1008[i] + " ");
		}
		System.out.println("");
	}

}


