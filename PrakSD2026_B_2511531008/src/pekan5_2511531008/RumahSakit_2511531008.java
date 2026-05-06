package pekan5_2511531008;
import java.util.*;
public class RumahSakit_2511531008 {
	static int counter = 0;
	static Pasien_2511531008 head_1008 = null;
	//1. tambah pasien didepan
	public static Pasien_2511531008 InsertAtTail(String nama_1008,String penyakit_1008) {
		counter++;
		Pasien_2511531008 newnode_1008 = new Pasien_2511531008(nama_1008,penyakit_1008, counter);
		// jika kosong
		if(head_1008 == null) {
			head_1008 = newnode_1008;
			System.out.println("Data berhasil ditambahkan " + newnode_1008);
			return newnode_1008;
		}
		Pasien_2511531008 last_1008 = head_1008;
		while(last_1008.next_1008 != null) {
			last_1008 = last_1008.next_1008;
		}
		//ubah pointer
		last_1008.next_1008 = newnode_1008;
		System.out.println("Data berhasil ditambahkan " + newnode_1008);
		return newnode_1008;
	}
	
	//2. panggil pasien (delete)
	public static Pasien_2511531008 panggilPasien_1008() {
		if(head_1008 == null) return null;
		else {
			Pasien_2511531008 panggil_1008 = head_1008;
			head_1008 = head_1008.next_1008;
			System.out.println("Memanggil pasien: " + panggil_1008.getnama_1008());
			return panggil_1008;
		}
	}
	//3. tampilkan antrean
	public static void listantrian_1008 () {
		Pasien_2511531008 pasien_1008 = head_1008;
		while(pasien_1008 != null) {
			System.out.println(pasien_1008);
			pasien_1008 = pasien_1008.next_1008;
		}
		System.out.println();
		
	}
	// 4. cari pasien
	public static boolean pencarian_1008(String keyname_1008) {
		Pasien_2511531008 pasien_1008 = head_1008;
		
		while(pasien_1008 != null) {
			if(keyname_1008.equalsIgnoreCase(pasien_1008.getnama_1008())) {
				System.out.println("data ditemukan: " + pasien_1008.getnama_1008() );
				return true;
			}
			pasien_1008 = pasien_1008.next_1008;
		}
		System.out.println("data tidak ditemukan");
		return false;
	}
	// 5. cek total antrian
	public static void cekStatusAntrian_1008() {
		Pasien_2511531008 last_1008 = head_1008;
		int total = 0;
		if(head_1008 == null) {
			System.out.println("tidak ditemukan");
			return;
		}
		total++;
		while(last_1008.next_1008 !=null) {
			total++;
			last_1008 = last_1008.next_1008;
		}
		System.out.print("jumlah total pasien = "+ total);
		return;
	}
	//input data pasien
		public static void inputdata_1008(Scanner scan_1008) {
			scan_1008.nextLine();
			System.out.print("Masukkan Nama Pasien: ");
	        String nama_1008 = scan_1008.nextLine();
	        System.out.print("Masukkan penyakit: ");
	        String penyakit_1008 = scan_1008.nextLine();
	        InsertAtTail(nama_1008,penyakit_1008);
	        
		}
	// display menu
	public static void displaymenu_1008() {
		System.out.println("\nAntrian Rumah Sakit NIM: 2511531008");
        System.out.println("1. Daftarkan Pasien (Insert)");
        System.out.println("2. Panggil Pasien (Delete Head)");
        System.out.println("3. Tampilkan Antrian (Display)");
        System.out.println("4. Cari Pasien (Search)");
        System.out.println("5. Cek Status Antrian");
        System.out.println("6. Keluar");
        System.out.print("Pilihan: ");
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			displaymenu_1008();
			choice = input.nextInt();
			if(choice ==1) {
				inputdata_1008(input);
			}else if( choice == 2){
				panggilPasien_1008();
			}else if (choice == 3) {
				listantrian_1008 ();
			}else if (choice == 4) {
				input.nextLine();
				System.out.println("masukkan nama pasien yang diacri");
				String cari = input.nextLine();
				pencarian_1008(cari);
			}else if (choice == 5) {
				cekStatusAntrian_1008();
			}else if(choice == 6) break;
			else System.out.println("pilihan tidak valid");
		}while(choice != 6);
	}
}

	


