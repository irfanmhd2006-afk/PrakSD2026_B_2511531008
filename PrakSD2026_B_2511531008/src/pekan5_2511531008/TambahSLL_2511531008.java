package pekan5_2511531008;

public class TambahSLL_2511531008 {
	public static NodeSLL_2511531008 insertAtFront_1008(NodeSLL_2511531008 head_1008,int value) {
		NodeSLL_2511531008 new_node_1008 = new NodeSLL_2511531008(value);
		new_node_1008.next_1008 = head_1008;
		return new_node_1008;
	}
	// fungsi menambahkan node diakhir SLL
	public static NodeSLL_2511531008 insertAtEnd_1008 (NodeSLL_2511531008 head_1008, int value_1008) {
		//buat sebuah node dengan sebuah nilai
		NodeSLL_2511531008 newNode_1008 = new NodeSLL_2511531008(value_1008);
		//jika list kosong maka node jadi head
		if (head_1008 == null) {
			return newNode_1008;
		}
		// simpan head ke variabel smeentara
		NodeSLL_2511531008 last_1008 = head_1008;
		//telusuri ke node akhir
		while(last_1008.next_1008 != null) {
			last_1008 = last_1008.next_1008;
		}
		//ubah pointer
		last_1008.next_1008 = newNode_1008;
		return head_1008;
		}
	static NodeSLL_2511531008 GetNode(int data_1008) {
		return new NodeSLL_2511531008(data_1008);
	}
	static NodeSLL_2511531008 insertPos_1008(NodeSLL_2511531008 headNode_1008,int position_1008, int value_1008) {
		NodeSLL_2511531008 head_1008 = headNode_1008;
		if(position_1008 < 1) System.out.print("invalid position");
		if(position_1008 == 1) {
			NodeSLL_2511531008 new_node = new NodeSLL_2511531008(value_1008);
			new_node.next_1008 = head_1008;
			return new_node;
		} else {
			while (position_1008-- != 0) {
				if (position_1008 == 1) {
					NodeSLL_2511531008 newNode = GetNode(value_1008);
					newNode.next_1008 = headNode_1008.next_1008;
					headNode_1008.next_1008 = newNode;
					break;
				}
				headNode_1008 = headNode_1008.next_1008;
			}
			if(position_1008 != 1) System.out.print("posisi diluar jangkuan");
		}
		return head_1008;
	}
	public static void printList(NodeSLL_2511531008 head_1008) {
		NodeSLL_2511531008 curr_1008 = head_1008;
		while (curr_1008.next_1008 != null) {
			System.out.print(curr_1008.data_1008 + "-->");
			curr_1008 = curr_1008.next_1008;
		}
		if(curr_1008.next_1008 == null ) {
			System.out.print(curr_1008.data_1008);
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		//buat linked list 2->3->5->6
		NodeSLL_2511531008 head_1008 = new NodeSLL_2511531008(2);
		head_1008.next_1008 = new NodeSLL_2511531008(3);
		head_1008.next_1008.next_1008 = new NodeSLL_2511531008(5);
		head_1008.next_1008.next_1008.next_1008 = new NodeSLL_2511531008(6);
		//cetak list asli
		System.out.print("Senarai berantai awal :");
		printList(head_1008);
		//tambahkan node baru di depan
		System.out.print("tambah 1 simpul di depan : ");
		int data_1008 = 1;
		head_1008 = insertAtFront_1008(head_1008, data_1008);
		// cetak update list
		printList(head_1008);
		//tambahkan node baru di belakang
		System.out.print("tambah 1 simpul di belakang : ");
		int data2_1008 = 7;
		head_1008 = insertAtEnd_1008(head_1008, data2_1008);
		//cetak update list
		printList(head_1008);
		int data3_1008 = 4;
		int pos_1008 = 4;
		head_1008 = insertPos_1008(head_1008,pos_1008,data3_1008);
		//cetak update list
		printList(head_1008);
	}
}