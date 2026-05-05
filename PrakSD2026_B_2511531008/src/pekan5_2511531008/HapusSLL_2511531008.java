package pekan5_2511531008;
import java.util.*;
public class HapusSLL_2511531008 {
	public static NodeSLL_2511531008  deleteHead_1008(NodeSLL_2511531008 head_1008) {
		// jika SLL kosong
		if (head_1008 == null) {
			return null;
		}
		//pindahkan head ke node berikutnya
		head_1008 = head_1008.next_1008;
		return head_1008;
	}
	public static NodeSLL_2511531008 removeLatsNode_1008( NodeSLL_2511531008 head_1008) {
		//jika list kosng , return null
		if(head_1008 == null) {
			return null;
		}
		//jika list satu node, hapus node dan return null
		if(head_1008.next_1008 == null) {
			return null;
		}
		//temukan node terakhir ke dua
	
		NodeSLL_2511531008 secondlast_1008 = head_1008;
		while(secondlast_1008.next_1008.next_1008 != null) {
			secondlast_1008 = secondlast_1008.next_1008;
		}
		//hapus node terakhir
		secondlast_1008.next_1008 = null;
		return head_1008;
	}
	
	public static NodeSLL_2511531008 deleteNode_1008(NodeSLL_2511531008 head_1008, int position_1008) {
		NodeSLL_2511531008 temp_1008 = head_1008;
		NodeSLL_2511531008 prev_1008 = null;
		//jika linked list null
		if(temp_1008 == null) return head_1008;
		//kasus 1 : head dihapus
		if(position_1008 == 1) {
			head_1008 = temp_1008.next_1008;
			return head_1008;
		}
		//kasus 2 : menghapus node ditengah
		//telusuri ke node yang dihapus
		for(int i = 1; temp_1008 != null && i < position_1008 ; i++) {
			prev_1008 = temp_1008;
			temp_1008 = temp_1008.next_1008;
		}
			//jika ditemukan, hapus node
			if(temp_1008 != null) {
				prev_1008.next_1008 = temp_1008.next_1008;
			}else {
				System.out.println("Data tidak ada");
			}
			return head_1008;
		
	}
	// fungsi mencetak SSL
	public static void printList(NodeSLL_2511531008 head_1008) {
		NodeSLL_2511531008 curr_1008 = head_1008;
		while(curr_1008.next_1008 != null) {
			System.out.print(curr_1008.data_1008 + "-->");
			curr_1008 = curr_1008.next_1008;
			if(curr_1008.next_1008 == null) {
				System.out.print(curr_1008.data_1008);
				System.out.println();
			}
		}
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		// buat SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6-> null
		NodeSLL_2511531008 head_1008 = new NodeSLL_2511531008(1);
		head_1008.next_1008 = new NodeSLL_2511531008(2);
		head_1008.next_1008.next_1008 = new NodeSLL_2511531008(3);
		head_1008.next_1008.next_1008.next_1008 = new NodeSLL_2511531008(4);
		head_1008.next_1008.next_1008.next_1008.next_1008 = new NodeSLL_2511531008(5);
		head_1008.next_1008.next_1008.next_1008.next_1008.next_1008 = new NodeSLL_2511531008(6);
		//cetak list awal
		System.out.println("list awal: ");
		printList(head_1008);
		//hapus head
		head_1008 = deleteHead_1008(head_1008);
		System.out.println("list setekah head dihapus: ");
		printList(head_1008);
		//hapus node terakhir
		head_1008 = removeLatsNode_1008(head_1008);
		System.out.println("List setelah simpul terakhir di hapus: ");
		printList(head_1008);
		//deleting node at position 2
		int position_1008 = 2;
		head_1008 = deleteNode_1008(head_1008,position_1008);
		//print list after deletion
		System.out.println("list setelah posisi 2 dihapus: ");
		printList(head_1008);
		
		
	}

}
