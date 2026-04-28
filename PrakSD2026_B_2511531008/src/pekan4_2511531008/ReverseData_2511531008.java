package pekan4_2511531008;
import java.util.*;

public class ReverseData_2511531008 {
	public static void main(String[] args) {
		Queue<Integer> q_2511531008 = new LinkedList<Integer>();
		q_2511531008.add(1);
		q_2511531008.add(2);
		q_2511531008.add(3); //[1,2,3]
		System.out.println("Sebelum reverse" + q_2511531008);
		Stack<Integer> s_2511531008 = new Stack<Integer>();
		while(!q_2511531008.isEmpty()){
			s_2511531008.push(q_2511531008.remove());
		}
		
		while(!s_2511531008.isEmpty()) {
			q_2511531008.add(s_2511531008.pop());
		}
		System.out.println("sesudah reverse " + q_2511531008);
		//[3, 2, 1]
	}

}
