package pekan2_2511531008;

public class DaftarKataDriver_2511531008 {

	public static void main(String[] args) {
		DaftarKata_2511531008 al = new DaftarKata_2511531008();
		
		//menambah elemen akhir
		al.tambah_2511531008("kami");
		al.tambah_2511531008("informatika");
		
		//menyisipkan elemen pada indeks 1
		al.tambahpada_2511531008(1, "Mahasiswa");
		
		//Cetak isi awal
		System.out.println("Awal   :"+al);
		
		//mengubah elemen index 1
		al.ubahElemen_2511531008(1, "Departemen");
		System.out.print("Setelah ubah: " + al);
		
		//menghapus elemen (hapus index 0)
		String terhapus = al.hapusElemen_2511531008(0);
		System.out.println("Terhapus   : " + terhapus );
		System.out.println("Setelah Hapus " + al);
		
		//iterasi pada ArrayList (cetak setiap elemen)
		System.out.println("iterasi:");
		al.iterasiCetak_2511531008();
		System.out.println();
	}

}
