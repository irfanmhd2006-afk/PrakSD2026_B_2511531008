package pekan8_2511531008;

public class MergeSort_2511531008 {
	void merge_1008(int arr_1008[], int l_1008, int m_1008, int r_1008) {
		// find sizes of two subarrays to be merged
		int n1_1008 = m_1008 - l_1008 + 1;
		int n2_1008 = r_1008 - m_1008;
		
		// Create temp arrays 
		int L[] = new int[n1_1008];
		int R[] = new int[n2_1008];
		
		// copy data to temp arrays
		for(int i_1008 = 0; i_1008 < n1_1008; ++i_1008) {
			L[i_1008] = arr_1008[l_1008 + i_1008];
		}
		
		for(int j_1008 = 0;  j_1008 < n2_1008; ++j_1008) {
			R[j_1008] = arr_1008[m_1008 + 1 + j_1008];
		}
		
		int i_1008 = 0, j_1008 = 0;
		// initial index of merged subarray array
		int k_1008 = l_1008;
		while(i_1008 < n1_1008 && j_1008 < n2_1008) {
			if (L[i_1008] <= R[j_1008]) {
				arr_1008[k_1008] = L[i_1008];
				i_1008++;
			} else {
				arr_1008[k_1008] = R[j_1008];
				j_1008++;
			}
			k_1008++;
		}
		
		// copy remaining elements of L[] if any 
		while (i_1008 < n1_1008) {
			arr_1008[k_1008] = L[i_1008];
			i_1008++;
			k_1008++;
		}
		// copy remaining elements of R[] if any
		while (j_1008 < n2_1008) {
			arr_1008[k_1008] = R[j_1008];
			j_1008++;
			k_1008++;
		}
	}
    
	void sort(int arr[], int l, int r) {
		if(l < r) {
			// find the middle point
			int m = (l + r) / 2;
			// sort first and second halves
			sort(arr, l, m);
			
			sort(arr, m + 1, r);
			// merge the sorted halves
			merge_1008(arr, l, m, r);
		}
	}
    
	static void printArray_1008(int arr[]) {
		int n = arr.length;
		for(int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
    
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		System.out.println("Sebelum terurut");
		printArray_1008(arr);
		
		MergeSort_2511531008 ob = new MergeSort_2511531008();
		ob.sort(arr, 0, arr.length - 1);
		
		System.out.println("\nSesudah Terurut menggunakan merge sort");
		printArray_1008(arr);
	}
}