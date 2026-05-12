package pekan6_2511531008;

public class PenelurusanDLL_2511531008 {
	static void forwardTraversal_1008(NodeDLL_2511531008 head_1008) {
		NodeDLL_2511531008 curr_1008 = head_1008;
		//lanjutkan sampai akhir
		while(curr_1008 != null) {
			//print data
			System.out.print(curr_1008.data_1008 + " <-> ");
			//curr_1008.pindah ke node berikutnya
			curr_1008 = curr_1008.next_1008;
		}
		//print spasi
		System.out.println();
		
	}
	// fungsi penelusuran mundur
	static void backwardTraversal_1008(NodeDLL_2511531008 tail_1008) {
		//mulai dari akhir
		NodeDLL_2511531008 curr_1008 = tail_1008;
		// lanjut sampai head
		while(curr_1008 != null) {
			//cetak data
			System.out.print(curr_1008.data_1008 + " <-> ");
			//pindah ke node sebelumnya
			curr_1008 = curr_1008.prev_1008;
		}
		// cteka spasi
		System.out.println();
	}
	public static void main(String[] args) {
		// cetak DLL
		NodeDLL_2511531008 head_1008= new NodeDLL_2511531008(1);
		NodeDLL_2511531008 second_1008 = new NodeDLL_2511531008(2);
		NodeDLL_2511531008 third_1008 = new NodeDLL_2511531008(3);
		
		head_1008.next_1008 = second_1008;
		second_1008.prev_1008 = head_1008;
		second_1008.next_1008 = third_1008;
		third_1008.prev_1008 = second_1008;
		
		System.out.println("Penulusran maju    : ");
		forwardTraversal_1008(head_1008);
		System.out.println("penelusuran mundur : ");
		backwardTraversal_1008(third_1008);
		
	}

}
