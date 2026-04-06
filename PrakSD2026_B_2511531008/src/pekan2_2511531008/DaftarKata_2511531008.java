package pekan2_2511531008;
import java.util.ArrayList;
public class DaftarKata_2511531008 {
	private final ArrayList<String> data;
	//konstruktor : inisialisasi list kosong
	public DaftarKata_2511531008(){
		this.data = new ArrayList<>();
	}
	// menambahkan elemen di akhir list
	public void tambah_2511531008(String elemen) {
		data.add(elemen);
	}
	public void tambahpada_2511531008(int index, String elemen) {
		data.add(index,elemen);
	}
	
//	megubah elemen pada posisi 'index' menjadi 'nilai baru'.
//	bertindak sebagai setter untuk elemen tertentu.
	
	public void ubahElemen_2511531008 (int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	
	//menghapus elemen pada posisi index dan mengembalikan nilai yang dihapus
	public String hapusElemen_2511531008(int index) {
		return data.remove(index);
	}
	
//	melakukan iterasi dan mencetak setiap elemen dalam format : [index] nilai
//	metode ini tidak mengemablikan nilai; anya demonstrasi iterasi
//	
	public void iterasiCetak_2511531008() {
		for(int i = 0; i < data.size(); i++) {
			System.out.print(data.get(i)+ " ");
		}
	}
	//mengambil elemen berdasarkan indeks
	public String get_2511531008(int index) {
		return data.get(index);
	}
	//representasi string agar mudah dicetak
	@Override
	public String toString() {
		return data.toString();
	}
	

}
