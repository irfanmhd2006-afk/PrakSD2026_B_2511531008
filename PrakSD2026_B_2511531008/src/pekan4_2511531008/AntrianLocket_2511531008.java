package pekan4_2511531008;
import java.util.*;
public class AntrianLocket_2511531008 {
	int front_1008,rear_1008,max_1008,size_1008;
	String array_1008[];
	public AntrianLocket_2511531008 (int max_1008) {
		this.max_1008 = max_1008;
		front_1008 = this.size_1008 = 0;
		rear_1008 = max_1008 - 1;
		array_1008 = new String[this.max_1008];
	}
	boolean isFull_2511531008(AntrianLocket_2511531008 queue) {
		return(queue.size_1008 == queue.max_1008);
	}
	boolean isEmpty_2511531008(AntrianLocket_2511531008 queue) {
		return(queue.size_1008 == 0);
	}
	void enqueue_2511531008(String data) {
		if(isFull_2511531008(this)) {
			System.out.print("antrian penuh");
		}else {
			this.rear_1008 = (this.rear_1008 + 1) % this.max_1008;
			this.array_1008[this.rear_1008] = data;
			this.size_1008 = this.size_1008 + 1;
			System.out.println(data + " enqueued to queue");
		}
	}
	String dequeue_2511531008(){
		if(isEmpty_2511531008(this)) {
			return "\n tidak ada antrean yang bisa dihapus";
		}
		String item_1008 = this.array_1008[this.front_1008];
		this.front_1008 = (this.front_1008 + 1) % this.max_1008;
		this.size_1008 = this.size_1008 - 1;
		System.out.println("antrean berhasil dihapus");
		return item_1008;
	}
	String front_2511531008() {
		if(isEmpty_2511531008(this))
			return "kosong";
		return this.array_1008[this.front_1008];
	}
	
	String rear_2511531008() {
		if(isEmpty_2511531008(this))
			return "kosong";
		return this.array_1008[this.rear_1008];
	}
	
	
	void display_2511531008(){
		if(isEmpty_2511531008(this)) {
			System.out.print("\n Antrian Kosong \n");
			return;
		}
		
		//kunjugi dari belakang secara acak
		System.out.println("Isi antrian:");
        int no = 1;
        for (int i = front_1008; i <= rear_1008; i++) {
            System.out.println(no + ". " + array_1008[i]);
            no++;
        }
		return;
	}
	
	public void reverse_2511531008() {
	    if (isEmpty_2511531008(this)) {
	        System.out.println("Antrian kosong");
	        return;
	    }

	    int start = front_1008;
	    int end = rear_1008;

	    for (int i = 0; i < size_1008 / 2; i++) {
	        String temp = array_1008[start];
	        array_1008[start] = array_1008[end];
	        array_1008[end] = temp;

	        start = (start + 1) % max_1008;
	        end = (end - 1 + max_1008) % max_1008;
	    }

	    System.out.println("Antrian berhasil dibalik");
	}


}
