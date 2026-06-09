package pekan9_2511531008;


public class Node_2511531008 {
	int data_1008;
	Node_2511531008 left_1008;
	Node_2511531008 right_1008;
	public Node_2511531008(int data_1008) {
		this.data_1008 = data_1008;
		left_1008 = null;
		right_1008 = null;
	}
	public void setLeft_1008(Node_2511531008 node_1008) {
		if (left_1008 == null) left_1008 = node_1008;
	}
	public void setRight_1008(Node_2511531008 node_1008) {
		if (right_1008 == null) right_1008 = node_1008;
	}
	public Node_2511531008 getLeft_1008() {
		return left_1008;
	}
	public Node_2511531008 getRight_1008() {
		return right_1008;
	}
    public int getdata_1008() {
    	return data_1008;
    }
    public void setdata_1008(int data_1008) {
    	this.data_1008 = data_1008;
    }
	
	void printPreorder_1008(Node_2511531008 node_1008) {
		if (node_1008 == null) return;
		System.out.print(node_1008.data_1008+ " ");
		printPreorder_1008(node_1008.left_1008);
		printPreorder_1008(node_1008.right_1008);
	}
	void printPostorder_1008(Node_2511531008 node_1008) {
		if (node_1008 == null) return;
		printPreorder_1008(node_1008.left_1008);
		printPreorder_1008(node_1008.right_1008);
		System.out.print(node_1008.data_1008+ " ");
	}
	void printInorder_1008(Node_2511531008 node_1008) {
		if (node_1008 == null) return;
		printPreorder_1008(node_1008.left_1008);
		System.out.print(node_1008.data_1008+ " ");
		printPreorder_1008(node_1008.right_1008);
		
	}
	public String print_1008() {
		return this.print_1008("",true,"");
	}


    public String print_1008(String prefix_1008, boolean isTail_1008,String sb_1008) {
    	if (right_1008 != null) {
    		right_1008.print_1008(prefix_1008 + (isTail_1008 ? "|   " : "    "), false, sb_1008);
    	}
    	System.out.println(prefix_1008 + (isTail_1008 ? "\\-- " : "/-- ")+ data_1008);
    	if(left_1008 != null) {
    		left_1008.print_1008(prefix_1008 + (isTail_1008 ? "    " : "|   "), true, sb_1008);
    	}
    	return sb_1008;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
