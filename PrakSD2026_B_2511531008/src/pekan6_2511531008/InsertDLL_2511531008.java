package pekan6_2511531008;

public class InsertDLL_2511531008 {
	static NodeDLL_2511531008 insertBegin_1008(NodeDLL_2511531008 head_1008, int data) {
		// budat node baru
		NodeDLL_2511531008 new_node = new NodeDLL_2511531008(data);
		//jadikan pointer nextnya head
		new_node.next_1008 = head_1008;
		// jadikan pointer prev head ke new_node
		if(head_1008 != null) {
			head_1008.prev_1008 = new_node;
		}
		return new_node;
	}
	//fungsi menambahkan node diakhir
	public static NodeDLL_2511531008 insertEnd_1008(NodeDLL_2511531008 head_1008, int NewData_1008) {
		//buat node baru
		NodeDLL_2511531008 newNode_1008 = new NodeDLL_2511531008(NewData_1008);
		//jika dll null jadikan head
		if(head_1008 == null) {
			head_1008 = newNode_1008;
		}
		else {
			NodeDLL_2511531008 curr_1008 = head_1008;
			while(curr_1008.next_1008 != null) {
				curr_1008 = curr_1008.next_1008;
			}
			curr_1008.next_1008 = newNode_1008;
			newNode_1008.prev_1008 = curr_1008;
		}
		return head_1008;
	}
	public static NodeDLL_2511531008 insertAtPosition(NodeDLL_2511531008 head_1008, int pos_1008, int new_data_1008) {
		//buat node baru
		NodeDLL_2511531008 new_node_1008 = new NodeDLL_2511531008(new_data_1008);
		if(pos_1008 == 1) {
			new_node_1008.next_1008 = head_1008;
			if(head_1008 == null) {
				head_1008.prev_1008 = new_node_1008;
			}
			head_1008 = new_node_1008;
			return head_1008;
		}
		NodeDLL_2511531008 curr_1008 = head_1008;
		for(int i = 1; i < pos_1008- 1 && curr_1008 != null;++i) {
			curr_1008 = curr_1008.next_1008;
		}
			if(curr_1008 == null) {
				System.out.print("posisi tidak ada");
				return head_1008;
			}
			new_node_1008.prev_1008= curr_1008;
			new_node_1008.next_1008 = curr_1008.next_1008;
			curr_1008.next_1008 = new_node_1008;
			if(new_node_1008.next_1008 != null) {
				new_node_1008.next_1008.prev_1008 = new_node_1008;
			}
			return head_1008;
		
		
		
	}
	public static void printList_1008(NodeDLL_2511531008 head_1008) {
		NodeDLL_2511531008 curr_1008 = head_1008;
		while(curr_1008 != null) {
			System.out.print(curr_1008.data_1008 + " <-> ");
			curr_1008 = curr_1008.next_1008;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		//membuat ddl 2 <-> 3 <-> 5
		NodeDLL_2511531008 head_1008 = new NodeDLL_2511531008(2);
		head_1008.next_1008 = new NodeDLL_2511531008(3);
		head_1008.next_1008.prev_1008 = head_1008;
		head_1008.next_1008.next_1008 = new NodeDLL_2511531008(5);
		head_1008.next_1008.next_1008.prev_1008 = head_1008.next_1008;
		//cetak DLL awal
		printList_1008(head_1008);
		//tambah 1 diawal
		head_1008 = insertBegin_1008(head_1008, 1);
		System.out.print("simpul 1 ditambah di awal : ");
		printList_1008(head_1008);
		//tambah 6 di akhir
		System.out.print("simpil 6 ditambah diakhir:");
		int data_1008 = 6;
		head_1008 = insertEnd_1008(head_1008, data_1008);
		printList_1008(head_1008);
		//menambah node 4 di posisi 4
		System.out.print("ditambah node 4 di posisi 4: ");
		int data2_1008 = 4;
		int pos_1008 = 4;
		head_1008 = insertAtPosition(head_1008,pos_1008,data2_1008);
		printList_1008(head_1008);
	}
	
	
}
