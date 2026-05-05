package pekan5_2511531008;
import java.util.*;
public class PencarianSLL_2511531008 {
	static boolean searchKey_1008(NodeSLL_2511531008 head_1008, int key_1008) {
		NodeSLL_2511531008 curr_1008 = head_1008;
		while(curr_1008 != null) {
			if (curr_1008.data_1008 == key_1008) return true;
			curr_1008 = curr_1008.next_1008;
		}
		return false;
	}
	public static void transversal(NodeSLL_2511531008 head_1008) {
		//mulai dari head
		NodeSLL_2511531008 curr_1008 = head_1008;
		//telusuri sampia ponuiter null
		while (curr_1008 != null) {
			System.out.print(" " + curr_1008.data_1008);
			curr_1008 = curr_1008.next_1008;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		NodeSLL_2511531008 head_1008 = new NodeSLL_2511531008(14);
		head_1008.next_1008 = new NodeSLL_2511531008(21);
		head_1008.next_1008.next_1008 = new NodeSLL_2511531008(30);
		head_1008.next_1008.next_1008.next_1008 = new NodeSLL_2511531008(10);
		System.out.print("Penelusuran SLL : ");
		transversal(head_1008);
		//data yang akan dicari
		int key_1008 = 30;
		System.out.print("cari data " + key_1008 + " = ");
		if(searchKey_1008(head_1008,key_1008)) {
			System.out.println("ketemu");
		}else {
			System.out.println("tidak ada");
		}
		
	}
}
