package pekan9_2511531008;

public class BTree_2511531008 {
	private Node_2511531008 root_1008;
	private Node_2511531008 currentNode_1008;
	public BTree_2511531008() {
		root_1008 = null;
	}
	public boolean search(int data_1008) {
		return search(root_1008, data_1008);
	}
	private boolean search(Node_2511531008 node, int data_1008) {
		if (node == null) return false;
		
		if (node.getdata_1008() == data_1008)
			return true;
		if (node.getLeft_1008() != null)
            if (search(node.getLeft_1008(), data_1008))
				return true;
		if (node.getRight_1008() != null)
			if (search (node.getRight_1008(), data_1008))
				return true;
			return false;
	}
	public void printInorder_1008() {
		root_1008.printInorder_1008(root_1008);
	}
	public void printPreOrder_1008() {
		root_1008.printPreorder_1008(root_1008);
	}
	public void printPostOrder_1008() {
		root_1008.printPostorder_1008(root_1008);
	}
	
	public Node_2511531008 getroot_1008() {
		return root_1008;
	}
	public boolean isEmpty_1008() {
		return root_1008 == null;
	}
	public int countNodes_1008(){
		return countNodes_1008(root_1008);
	}
	private int countNodes_1008(Node_2511531008 node_1008) {
		int count = 1;
		if (node_1008 == null) {
			return 0;
		}	else {
			count += countNodes_1008 (node_1008.getLeft_1008());
			count += countNodes_1008 (node_1008.getRight_1008());
			return count;
		}
	}
	
	public void print_1008() {
		root_1008.print_1008();
	}
	public Node_2511531008 getCurrent_1008() {
		return currentNode_1008;
	}
	
	public void setCurrent_1008(Node_2511531008 node) {
		this.currentNode_1008 = node;
	}
	
	public void setroot_1008(Node_2511531008 root_1008) {
		this.root_1008 = root_1008;
	}
}