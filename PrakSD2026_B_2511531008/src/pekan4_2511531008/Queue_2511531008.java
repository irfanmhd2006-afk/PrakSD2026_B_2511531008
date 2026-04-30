package pekan4_2511531008;
import java.util.*;
public class Queue_2511531008 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		AntrianLocket_2511531008 antrian = new AntrianLocket_2511531008(10);
		
		int chose;
		do {
			System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            chose = input.nextInt();
            input.nextLine();
            if(chose == 1) {
            	 System.out.print("Masukkan nama pelanggan: ");
                 String nama = input.nextLine();
                 antrian.enqueue_2511531008(nama);
            }else if(chose == 2) {
            	antrian.dequeue_2511531008();
            }else if(chose == 3) {
            	antrian.display_2511531008();
            }else if(chose == 4) {
            	antrian.reverse_2511531008();
            }else if(chose == 5) {
            	System.out.println("program selesai");
            }else {
            	System.out.println("list tidak valid");
            }
		}while(chose != 5);

	}

}
