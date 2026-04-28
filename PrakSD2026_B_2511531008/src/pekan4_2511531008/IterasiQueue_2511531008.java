package pekan4_2511531008;
import java.util.*;
public class IterasiQueue_2511531008 {

	public static void main(String[] args) {
		Queue<String> q_2511531008 = new LinkedList<>();
		q_2511531008.add("Praktikum");
		q_2511531008.add("Struktur");
		q_2511531008.add("Data");
		q_2511531008.add("Dan");
		q_2511531008.add("Algoritma");
		Iterator<String> iterator = q_2511531008.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}

}
