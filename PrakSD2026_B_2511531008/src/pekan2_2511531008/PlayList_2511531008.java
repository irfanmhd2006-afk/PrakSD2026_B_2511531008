package pekan2_2511531008;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayList_2511531008 {
	//input lagu
	public static void masukandata_2511531008(Scanner input, ArrayList<Musik_2511531008> playlist) {
		System.out.print("Masukkan Judul: ");
        String judul = input.nextLine();

        System.out.print("Masukkan Penyanyi: ");
        String penyanyi = input.nextLine();

        System.out.print("Masukkan Durasi: ");
        int durasi = input.nextInt();
        input.nextLine();

        playlist.add(new Musik_2511531008(judul,penyanyi,durasi));
	}
	//tampilkan menu 
	public static void Daftarmenu_2511531008(){
		System.out.println("\n=== Playlist Musik NIM: 2511531008 ===");
        System.out.println("1. Tambah Lagu");
        System.out.println("2. Lihat Playlist");
        System.out.println("3. Hapus Lagu");
        System.out.println("4. Cek Jumlah Lagu");
        System.out.println("5. Keluar");
        System.out.print("Pilihan: ");
		
	}
	//cetak semua lagu
	public static void tampilkanlagu_2511531008(ArrayList<Musik_2511531008> playlist) {
		if (playlist.isEmpty()) {
            System.out.println("Playlist kosong.");
        } else {
            System.out.println("\n=== Daftar Lagu ===");

            for (Musik_2511531008 msk : playlist) {
            	System.out.print(msk);
            }
            System.out.println("==================");
        }
	}
	// method hapus lagu
	public static void hapuslagu_2511531008(ArrayList<Musik_2511531008> playlist, Scanner input){
		if (playlist.isEmpty()) {
            System.out.println("Playlist kosong.");
        } else {
            System.out.print("Masukkan nomor lagu yang akan dihapus: ");
            int index = input.nextInt();
            input.nextLine();
            if (index > 0 && index <= playlist.size()) {
                playlist.remove(index - 1);
                System.out.println("Lagu berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
        
	}
	//cetak jumlah lagu
	public static void jumlahlagu_2511531008(ArrayList<Musik_2511531008> playlist) {
		System.out.println("Jumlah lagu dalam playlist: "
                + playlist.size());
	}
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // ArrayList untuk menyimpan objek Musik
        ArrayList<Musik_2511531008> playlist = new ArrayList<>();
        int pilihan;
        do {
        	Daftarmenu_2511531008();
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {

                case 1:
                    // Tambah Lagu
                	masukandata_2511531008(input, playlist);
                	break;

                case 2:
                    // Lihat Playlist
                	tampilkanlagu_2511531008(playlist);
                	break;

                case 3:
                    // Hapus Lagu
                    hapuslagu_2511531008(playlist, input);
                    break;

                case 4:
                    // Cek jumlah lagu
                    jumlahlagu_2511531008(playlist);
                    break;

                case 5:
                	//program selesai
                    System.out.println("Program selesai.");
                    break;

                default:
                	//input tidak valid
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);

        input.close();
    }
}
