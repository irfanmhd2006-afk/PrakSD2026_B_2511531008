package pekan6_2511531008;

public class HapusDLL_2511531008 {
	//fungsi menghapus node awal
	public static NodeDLL_2511531008 delHead_1008(NodeDLL_2511531008 head_1008) {
		if(head_1008 == null) {
			return null;
		}
		
		head_1008 = head_1008.next_1008;
		if(head_1008 != null) {
			head_1008.prev_1008 = null;
		}
		return head_1008;
	}
	// fungsi menghapus di akhir
	public static NodeDLL_2511531008 delLast_1008(NodeDLL_2511531008 head_1008) {
		if(head_1008 == null) {
			return null;
		}
		if(head_1008.next_1008 == null) {
			return null;
		}
		NodeDLL_2511531008 curr_1008 = head_1008;
		while(curr_1008.next_1008 != null) curr_1008 = curr_1008.next_1008;
		//update pointer previous node
		if(curr_1008.prev_1008 != null) curr_1008.prev_1008.next_1008 = null;
		return head_1008;
	}
	// fungsi menghapus node posisi tertentu
	public static NodeDLL_2511531008 delPos_1008(NodeDLL_2511531008 head_1008, int pos_1008) {
		// jika DLL kosong
		if(head_1008 == null) return head_1008;
		NodeDLL_2511531008 curr_1008 = head_1008;
		//telusuri sampai ke node yang akan dihapus
		for(int i = 1; curr_1008 != null && i < pos_1008; ++i) curr_1008 = curr_1008.next_1008;

		//jika posisi tidak ditemukan
		if(curr_1008 == null) return head_1008;
		//update pointer
		if(curr_1008.prev_1008 != null) curr_1008.prev_1008.next_1008 = curr_1008.next_1008;
		if(curr_1008.next_1008 != null) curr_1008.next_1008.prev_1008 = curr_1008.prev_1008;
		// jika yang dihapus head
		if(head_1008 == curr_1008) {
			head_1008 = curr_1008.next_1008;
		}
		return head_1008;
	}
	public static void printList(NodeDLL_2511531008 head_1008) {
		NodeDLL_2511531008 curr_1008 = head_1008;
		while(curr_1008 != null) {
			System.out.print(curr_1008.data_1008 + " <-> ");
			curr_1008 = curr_1008.next_1008;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		//buat sebuah DLL
		NodeDLL_2511531008 head_1008 = new NodeDLL_2511531008(1);
		head_1008.next_1008 = new NodeDLL_2511531008(2);
		head_1008.next_1008.prev_1008 = head_1008;
		head_1008.next_1008.next_1008 = new NodeDLL_2511531008(3);
		head_1008.next_1008.next_1008.prev_1008 = head_1008.next_1008;
		head_1008.next_1008.next_1008.next_1008 = new NodeDLL_2511531008(4);
		head_1008.next_1008.next_1008.next_1008.prev_1008 = head_1008.next_1008.next_1008;
		head_1008.next_1008.next_1008.next_1008.next_1008 = new NodeDLL_2511531008(5);
		head_1008.next_1008.next_1008.next_1008.next_1008.prev_1008 = head_1008.next_1008.next_1008.next_1008;
		
		System.out.print("DLL awal: ");
		printList(head_1008);
		
		System.out.print("Setelah head dihapus: ");
		head_1008 = delHead_1008(head_1008);
		printList(head_1008);
		
		System.out.print("Setelah node terakhir dihapus: ");
		head_1008 = delLast_1008(head_1008);
		printList(head_1008);
		
		
		System.out.print("Setelah node ke 2: ");
		head_1008 = delPos_1008(head_1008, 2);
		
		printList(head_1008);
		
	}
}

