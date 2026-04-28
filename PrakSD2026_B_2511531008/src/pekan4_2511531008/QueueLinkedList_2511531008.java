package pekan4_2511531008;
import java.util.*;
public class QueueLinkedList_2511531008 {

	public static void main(String[] args) {
		Queue<Integer> q_2511531008 = new LinkedList<>();
		for(int i_1008 = 0; i_1008 < 6; i_1008++) {
			q_2511531008.add(i_1008);
		}
		//Menampilkan isi antrian
		System.out.println("elemen antrian " + q_2511531008);
		//untukmenghapus kepala antrian
		int hapus_1008 = q_2511531008.remove();
		System.out.println("Hapus elemen = " + hapus_1008);
		System.out.println(q_2511531008);
		//untuk melihat antrian terdepan
		int depan_1008 = q_2511531008.peek();
		System.out.println("Kepala Antrian = "+ depan_1008);
		int banyak_1008 = q_2511531008.size();
		System.out.println("Size Antrian = " + banyak_1008);
	}

}
