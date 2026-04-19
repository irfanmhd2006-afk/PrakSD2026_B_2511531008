package pekan3_2511531008;
import java.util.*;
public class stackArrayDriver_2511531008 {

	public static void main(String[] args) {
		stackArray_2511531008 s = new stackArray_2511531008();
		s.push_2511531008(10);
		s.push_2511531008(20);
		s.push_2511531008(30);
		System.out.println(s.pop_2511531008()+" dikeluarkan dari stack ");
		System.out.println("Elemen teratas adalah :" + s.peek_2511531008());
		System.out.print("Element pada stack :");
		s.print_2511531008();

	}

}
