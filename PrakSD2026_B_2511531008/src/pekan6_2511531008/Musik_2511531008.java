package pekan6_2511531008;
import java.util.*;
public class Musik_2511531008 {
	 
    Lagu_2511531008 head_1008;
    Lagu_2511531008 tail_1008;
 
    // 1. tambahLagu_1008() - Menambah lagu baru di AKHIR list
    public void tambahLagu_1008(String judul, String penyanyi) {
    	Lagu_2511531008 laguBaru_1008 = new Lagu_2511531008(judul, penyanyi);
    	if (head_1008 == null) {
    	    head_1008 = laguBaru_1008;
    	    tail_1008 = laguBaru_1008;
    	} else {
    	    laguBaru_1008.prev_1008 = tail_1008;
    	    tail_1008.next_1008 = laguBaru_1008;
    	    tail_1008 = laguBaru_1008; // tail diupdate
    	}
        System.out.println("Lagu berhasil ditambahkan!");
    }
    // 2. hapusLaguAwal_1008() - Menghapus lagu pertama (head)
    public void hapusLaguAwal_1008() {
        if (head_1008 == null) {
            System.out.println("Playlist kosong, tidak ada lagu yang dihapus.");
            return;
        }
        System.out.println(" Lagu \"" + head_1008.getJudul_1008() + "\" berhasil dihapus.");
 
        head_1008 = head_1008.next_1008;
		if(head_1008 != null) {
			head_1008.prev_1008 = null;
		}
    }
    // 3. tampilMaju_1008() - Tampilkan lagu dari awal ke akhir
    public void tampilMaju_1008() {
        if (head_1008 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        System.out.println("\n Playlist (Maju) :");
        System.out.println("--------------------------------------------");
        Lagu_2511531008 curr_1008 = head_1008;
		//lanjutkan sampai akhir
        int nomor = 1;
        while (curr_1008 != null) {
            System.out.println(nomor++ + ". " + curr_1008);
            curr_1008 = curr_1008.next_1008;
        }
		//print spasi
		System.out.println();
        System.out.println("--------------------------------------------");
    }
    // 4. tampilMundur_1008() - Tampilkan lagu dari akhir ke awal
    public void tampilMundur_1008() {
        if (tail_1008 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        System.out.println("\n Playlist (Mundur) :");
        System.out.println("--------------------------------------------");
        Lagu_2511531008 curr_1008 = tail_1008;
        int nomor = 1;
        // traversal mundur menggunakan pointer prev
        while (curr_1008 != null) {
            System.out.println(nomor++ + ". " + curr_1008); // otomatis panggil toString()
            curr_1008 = curr_1008.prev_1008;
        }
        System.out.println("--------------------------------------------");
           }
    // 5. cariLagu_1008() - Cari lagu berdasarkan judul
    public void cariLagu_1008(String judul) {
        if (head_1008 == null) {
            System.out.println(" Playlist kosong.");
            return;
        }
        Lagu_2511531008 curr_1008 = head_1008;
        int posisi = 1;
        while (curr_1008 != null) {
            if (curr_1008.getJudul_1008().equalsIgnoreCase(judul)) {
                System.out.println("  Lagu ditemukan di posisi " + posisi + "!");
                System.out.println("   Judul    : " + curr_1008.getJudul_1008());
                System.out.println("   Penyanyi : " + curr_1008.getPenyanyi_1008());
                return;
            }
            curr_1008 = curr_1008.next_1008;
            posisi++;
        }
        System.out.println("  Lagu \"" + judul + "\" tidak ditemukan.");
    }
    public static void menulagu_1008() {
    	// Tampilan menu utama
        System.out.println("=== Playlist Musik NIM: 2511531008 ===");
        System.out.println("1. Tambah Lagu                      ");
        System.out.println("2. Hapus Lagu Pertama               ");
        System.out.println("3. Lihat Playlist (Maju)            ");
        System.out.println("4. Lihat Playlist (Mundur)          ");
        System.out.println("5. Cari Lagu                        ");
        System.out.println("6. Keluar                           ");
    }
  
    public static void main(String[] args) { 
        Scanner sc_1008    = new Scanner(System.in);
        Musik_2511531008 playlist_1008 = new Musik_2511531008();
        int pilihan_1008;
        do {
            menulagu_1008();
            System.out.print("Pilihan: ");
            pilihan_1008 = sc_1008.nextInt();
            sc_1008.nextLine(); // buang newline sisa
            switch (pilihan_1008) {
                case 1:
                    //  Tambah Lagu 
                    System.out.print("Judul    : ");
                    String judul_1008    = sc_1008.nextLine();
                    System.out.print("Penyanyi : ");
                    String penyanyi_1008 = sc_1008.nextLine();
                    playlist_1008.tambahLagu_1008(judul_1008, penyanyi_1008);
                    break;
                case 2:
                    playlist_1008.hapusLaguAwal_1008();
                    break;
                case 3:
                    playlist_1008.tampilMaju_1008();
                    break;
                case 4:
                    playlist_1008.tampilMundur_1008();
                    break;
                case 5:
                    System.out.print("Masukkan judul yang dicari: ");
                    String cari_1008 = sc_1008.nextLine();
                    playlist_1008.cariLagu_1008(cari_1008);
                    break;
                case 6:
                    System.out.println("Terima kasih, program selesai!");
                    break;
                default:
                    System.out.println(" Pilihan tidak tersedia, coba lagi.");
            }
 
        } while (pilihan_1008 != 6);
 
        sc_1008.close();
    }
}