package pekan8_2511531008;

public class QuickSort_2511531008 {
	static void swap_1008(int[] arr_1008_1008_1008, int i_1008, int j_1008) {
		int temp_1008 = arr_1008_1008_1008[i_1008];
		arr_1008_1008_1008[i_1008] = arr_1008_1008_1008[j_1008];
		arr_1008_1008_1008[j_1008] =temp_1008;
	}
	static void mediaOfThree_1008 (int[] arr_1008_1008 ,int low_1008_1008,int high_1008_1008) {
		int mid_1008 = low_1008_1008 +(high_1008_1008 - low_1008_1008)/2;
		
		//urutkan elemen low_1008_1008, mid_1008, dan high_1008_1008
		if(arr_1008_1008[low_1008_1008] > arr_1008_1008[mid_1008]) swap_1008(arr_1008_1008,low_1008_1008,mid_1008);
		if(arr_1008_1008[low_1008_1008] > arr_1008_1008[high_1008_1008]) swap_1008(arr_1008_1008,low_1008_1008,high_1008_1008);
		if(arr_1008_1008[mid_1008] > arr_1008_1008[high_1008_1008]) swap_1008(arr_1008_1008,mid_1008,high_1008_1008);
		swap_1008(arr_1008_1008,mid_1008,high_1008_1008);
	}
	
	static int partition(int[] arr_1008_1008, int low_1008_1008, int high_1008_1008) {
		//panggil fungsi mediaOfThree sebelum menentukan pi_1008vot_1008
		mediaOfThree_1008(arr_1008_1008,low_1008_1008,high_1008_1008);
		int pi_1008vot_1008 = arr_1008_1008[high_1008_1008];
		int i_1008 = (low_1008_1008-1);
		
		for(int j_1008 = low_1008_1008; j_1008 <= high_1008_1008-1; j_1008++) {
			//jika elemen saat ini lebih kecil dari atau sama dengan pi_1008vot_1008
			if(arr_1008_1008[j_1008] < pi_1008vot_1008) {
				i_1008++;
				swap_1008(arr_1008_1008,i_1008,j_1008);
			}
		}
		swap_1008(arr_1008_1008,i_1008+1,high_1008_1008);
		return(i_1008+1);
	}
	static void quickSort_1008(int[] arr_1008,int low_1008, int high_1008) {
		if(low_1008 < high_1008) {
			int pi_1008 = partition(arr_1008,low_1008,high_1008);
			quickSort_1008(arr_1008,low_1008,pi_1008-1);
			quickSort_1008(arr_1008,pi_1008+1,high_1008);
		}
	}
	public static void printarr_1008(int[] arr_1008) {
		for(int i_1008 = 0; i_1008 < arr_1008.length;i_1008++) {
			System.out.print(arr_1008[i_1008] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr_1008 = {10, 7, 8,9,1,5};
		int N_1008 = arr_1008.length;
		System.out.print("Data sebelum terurut: ");
		printarr_1008(arr_1008);
		
		quickSort_1008(arr_1008,0,N_1008-1);
		System.out.print("Data terurut quickSort_1008: ");
		printarr_1008(arr_1008);

	}

}
