package pekan3_2511531008;

import java.util.Scanner;
import java.util.Stack;

public class Browser_2511531008 {

    // tampilkan menu
    public static void tampilkanMenu_2511531008() {

        System.out.println("\n=== Browser History NIM: 2511531008 ===");
        System.out.println("1. Kunjungi Website (Push)");
        System.out.println("2. Tombol Back (Pop)");
        System.out.println("3. Lihat Halaman Aktif (Peek)");
        System.out.println("4. Cek Status History");
        System.out.println("5. Keluar");
        System.out.print("Pilihan: ");
    }

    // case 1 push
    public static void kunjungiWebsite_2511531008(Scanner input, Stack<Website_2511531008> history) {

        System.out.print("Masukkan Judul: ");
        String judul = input.nextLine();

        System.out.print("Masukkan URL: ");
        String url = input.nextLine();

        history.push(new Website_2511531008(judul, url));

        System.out.println("Berhasil mengunjungi halaman!");
    }

    // Case 2 pop atau undo halaman
    public static void tombolBack_2511531008(Stack<Website_2511531008> history) {

        if (history.isEmpty()) {
            System.out.println("History kosong, tidak bisa kembali.");

        } else {
            Website_2511531008 web = history.pop();
            System.out.println("Kembali dari: " + web.getJudul_1008());
        }
    }

    // case 3 peek(kembali ke halaman saat ini)
    public static void lihatHalamanAktif_2511531008(Stack<Website_2511531008> history) {

        if (history.isEmpty()) {
            System.out.println("Tidak ada halaman aktif.");
        } else {
            Website_2511531008 web = history.peek();

            System.out.println("\nHalaman Aktif:");
            System.out.println("Judul : "+ web.getJudul_1008());
            System.out.println("URL   : "+ web.getUrl_1008());
        }
    }

    // case 4 cek history
    public static void cekStatusHistory_2511531008(Stack<Website_2511531008> history) {

        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("Jumlah history: " + history.size());
        }
    }

    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Stack<Website_2511531008> history = new Stack<>();

        int pilihan;

        do {
            tampilkanMenu_2511531008();
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {

                case 1:
                    kunjungiWebsite_2511531008(input,history);
                    break;

                case 2:
                    tombolBack_2511531008(history);
                    break;

                case 3:
                    lihatHalamanAktif_2511531008(history);
                    break;

                case 4:
                    cekStatusHistory_2511531008(history);
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);

        input.close();
    }
}