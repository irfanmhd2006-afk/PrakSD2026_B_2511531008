package pekan9_2511531008;

public class BTreeDriver_2511531008 {
	public static void main(String[] args) {
		// membuat pohon
		BTree_2511531008 tree_1008 = new BTree_2511531008();
		System.out.print("jumlah simpul awal pohon: ");
		System.out.println(tree_1008.countNodes_1008());
		//menambahkan simpul data
		Node_2511531008 root_1008 = new Node_2511531008(1);
		//menjadikan simpul 1 sebagai root
		tree_1008.setroot_1008(root_1008);
		System.out.println("Jumlah simpul jika hanya ada root");
		System.out.println(tree_1008.countNodes_1008());
		Node_2511531008 node2_1008 = new Node_2511531008(2);
		Node_2511531008 node3_1008 = new Node_2511531008(3);
		Node_2511531008 node4_1008 = new Node_2511531008(4);
		Node_2511531008 node5_1008 = new Node_2511531008(5);
		Node_2511531008 node6_1008 = new Node_2511531008(6);
		Node_2511531008 node7_1008 = new Node_2511531008(7);
		Node_2511531008 node8_1008 = new Node_2511531008(8);
		Node_2511531008 node9_1008 = new Node_2511531008(9);
		
		root_1008.setLeft_1008(node2_1008);
		node2_1008.setLeft_1008(node4_1008);
		node2_1008.setRight_1008(node5_1008);
		node4_1008.setRight_1008(node8_1008);
		root_1008.setRight_1008(node3_1008);
		node3_1008.setLeft_1008(node6_1008);
		node3_1008.setRight_1008(node7_1008);
		node6_1008.setLeft_1008(node9_1008);
		//set root
		tree_1008.setCurrent_1008(tree_1008.getroot_1008());
		System.out.println("menampilkan simpul terakhir");
		System.out.println(tree_1008.getCurrent_1008().getdata_1008());
		System.out.println("jumlah simpul: setelah simpul ? ditambahkan");
		System.out.println(tree_1008.countNodes_1008());
		System.out.println("InOrder: ");
		tree_1008.printInorder_1008();
		System.out.println("\nPreOrder");
		tree_1008.printPreOrder_1008();
		System.out.println("\nPostOrder");
		tree_1008.printPostOrder_1008();
		System.out.println(" \n Menampilkan simpul dalam bentuk pohon");
		tree_1008.print_1008();
	}

}
