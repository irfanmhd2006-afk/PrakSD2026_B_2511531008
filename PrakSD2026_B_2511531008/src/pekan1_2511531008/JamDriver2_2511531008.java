package pekan1_2511531008;
import java.util.Scanner;
public class JamDriver2_2511531008 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=== Program Driver Objek Jam ===");
		// 1.input Jam Pertma
		System.out.println("\n--- Input Jam 1 ---");
		Jam_2511531008 j1 = buatJamDariInput(input);
		
		// 2.input jam kedua
		System.out.println("\n--- Input Jam 2 ---");
		Jam_2511531008 j2 = buatJamDariInput(input);
		
		// 3.menampilkan Data
		System.out.println("\n--- Hasil Operasi ---");
		System.out.println("Jam 1 (String)		: " + j1.toString());
		System.out.println("Jam 2 (String)		: " + j2.toString());
		System.out.println("Jam 1 (Second)		: " + j1.ToSeconds());
		System.out.println("Jam 2 (Second)		: " + j2.ToSeconds());
		
		//4. Operasi Relasional (Perbandingan)
		int perbandingan = j1.compareTo(j2);
		if(perbandingan > 0) {
			System.out.println("Status					 	: Jam 1 lebih lambat (Setelah) Jam 2");
		}else if (perbandingan < 0) {
			System.out.println("Status						: Jam 1 lebih awal (sebelum) jam 2");
		} else {
			System.out.println("Status						: Ja, 1 da Jam 2 sama persis");
		}
		
		//5. Operasi Aritmatika
		System.out.println("Durasi (J1 ke J2)				: "+ Jam_2511531008.durasiDetik(j1, j2) + "detik");
		
		Jam_2511531008 jNext = j1.nextSecond();
		System.out.println("Jam 1 detik berikutnya: " + jNext);
		
		Jam_2511531008 jPrev =j1.prevSecond();
		System.out.println("Jam 1 Detik sebelumnya: " + jPrev);
		
		// 6.Operasi Penjumlahan Jam
		Jam_2511531008 jHasilPlus = j1.plus(j2);
		System.out.println("Hasil J1 + J2 			: " + jHasilPlus);
		
		input.close();
		System.out.println("\nProgram Selesai.");

		
		
	}
	private static Jam_2511531008 buatJamDariInput(Scanner sc) {
		int h, m ,s;
		while(true) {
			System.out.print("Masukkan Jam (0-23)	: ");
			h = sc.nextInt();
			System.out.print("Masukkan Menit (0-59) : ");
			m = sc.nextInt();
			System.out.print("Masukkan detik (0-59) : ");
			s =sc.nextInt();
			
			//Memanggil method statuc isValid dari kelas
			if(Jam_2511531008.isValid(h,m,s)) {
				return new Jam_2511531008(h,m,s);
			} else {
				System.out.println("[Error] Input tidak valid! Silkan ulangi. \n");
			}
		}
		
	}

}
