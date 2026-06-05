package pekan8_2511531008;
import java.util.Scanner;

class Lagu_1008 {
     String judul_1008;
     String penyanyi_1008;
     int durasi_1008;

    public Lagu_1008(String judul_1008, String penyanyi_1008, int durasi_1008) {
        this.judul_1008 = judul_1008;
        this.penyanyi_1008 = penyanyi_1008;
        this.durasi_1008 = durasi_1008;
    }
    @Override
    public String toString() {
        return String.format("%-25s | %-16s | %d detik", judul_1008, penyanyi_1008, durasi_1008);
    }
}

public class Sorting_2511531008 {
	//array maksimal 20 lagu
    static Lagu_1008[] dataLagu_1008 = new Lagu_1008[20];
    static int jumlahLagu_1008 = 0;

    //method isi lagu (min 7 buah)
    static void inputData_1008() {
        dataLagu_1008[0] = new Lagu_1008("Faded","Alan walker ", 210);
        dataLagu_1008[1] = new Lagu_1008("Alone",  "Alan walker",  195);
        dataLagu_1008[2] = new Lagu_1008("Ghost", "Justin bieber",    183);
        dataLagu_1008[3] = new Lagu_1008("Terlalu lama",  "vierra",   220);
        dataLagu_1008[4] = new Lagu_1008("alone","marshmello",   240);
        dataLagu_1008[5] = new Lagu_1008("celengan rindu", "lupa", 198);
        dataLagu_1008[6] = new Lagu_1008("Rang Talu", "Anas Mardin",  175);
        jumlahLagu_1008 = 7;
    }
    
    
    static void shellSort_1008() {
        int gap = jumlahLagu_1008 / 2;
        while (gap > 0) {
            for (int i = gap; i < jumlahLagu_1008; i++) {
                Lagu_1008 temp = dataLagu_1008[i];
                int j = i;
                while (j >= gap && dataLagu_1008[j - gap].judul_1008.compareToIgnoreCase(temp.judul_1008) > 0) {
                    dataLagu_1008[j] = dataLagu_1008[j - gap];
                    j -= gap;
                }
                dataLagu_1008[j] = temp;
            }
            gap /= 2;
        }
    }
    public static void main(String[] args) {
    	System.out.println("\n=== Sorting Playlist NIM: 2511531008 ===");
        System.out.println("Algoritma Dipilih: Shell Sort (judul_1008 A-Z)");

        inputData_1008();

        System.out.println("\nData Sebelum Sorting:");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < jumlahLagu_1008; i++) {
        	System.out.println((i + 1) + ". " + dataLagu_1008[i]);
        }

        // Jalankan Shell Sort
        shellSort_1008();

        // Tampilkan sesudah sorting
        System.out.println("\nData Setelah Shell Sort (judul_1008 A-Z):");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < jumlahLagu_1008; i++) {
        	System.out.println((i + 1) + ". " + dataLagu_1008[i]);
        }

        System.out.println("\nSorting selesai!");
    }
}