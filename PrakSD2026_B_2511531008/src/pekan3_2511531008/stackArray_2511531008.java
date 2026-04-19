package pekan3_2511531008;
import java.util.*;
public class stackArray_2511531008 {
	static final int max = 1000;
	int top;
	int a[] = new int[max];
	boolean isEmpty_2511531008() {
		return (top < 0);
	}
	stackArray_2511531008(){
		top = -1;
	}
	boolean push_2511531008(int x) {
		if(top >= (max - 1)) {
			System.out.println("Stack overflow");
			return false;
		}
		else {
			a[++top] = x;
			System.out.println(x +" dimasukkan dalam stack");
			return true;
		}
	}
	int pop_2511531008() {
		if(top < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x = a[top--];
			return x;
		}
	}
	int peek_2511531008() {
		if(top < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x = a[top];
			return x;
		}
	}
	void print_2511531008() {
		for(int i = top; i >-1; i--) {
			System.out.print(" "+ a[i]);
		}
	}
	

}
