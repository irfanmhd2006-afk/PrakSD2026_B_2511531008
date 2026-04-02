package pekan1_2511531008;

import pekan1_2511531008.Mobil_2511531008;

public final class Mobil_2511531008 {
	private String nama;
	private int cc;
	private int tahun;
	private double harga;
	private String merk;
	// konstruktor
	public Mobil_2511531008(String nama,int cc,  int tahun, double harga, String merk){
		this.nama = nama;
		this.cc= cc;
		this.tahun = tahun;
		this.harga = harga;
		this.merk = merk;
	}
	// selektor getter
	public String Getnama() {
		return nama;
	}
	public int Getcc() {
		return cc;
	}
	public int Gettahun() {
		return tahun;
	}
	public double Getharga() {
		return harga;
	}
	public String Getmerk() {
		return merk;
	}
	
	//mutator setter
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setcc(int cc) {
		this.cc = cc;
	}
	public void settahun(int tahun) {
		this.tahun = tahun;
	}
	public void setharga(double harga) {
		this.harga = harga;
	}
	public void setmerk(String merk) {
		this.merk = merk;
	}
	
	public void tampilMobil() {
        System.out.println("Nama  : " + nama);
        System.out.println("Tahun : " + tahun);
        System.out.println("CC    : " + cc);
        System.out.println("Harga : " + harga);
        System.out.println("Merk  : " + merk);
        System.out.println("----------------------");
    }
	static int jumlah = 0;
	static Mobil_2511531008[] daftarMobil = new Mobil_2511531008[10];
	
	//tambah mobbil
	public static void tambahMobil(Mobil_2511531008 Mobil) {
		if(jumlah < daftarMobil.length) {
			daftarMobil[jumlah] = Mobil;
			jumlah++;
		} else {
			System.out.print("Array Penuh");
		}
	}
	
	//hapus mobil
	public static void hapusMobil(int index) {
        if (index >= 0 && index < jumlah) {
            for (int i = index; i < jumlah - 1; i++) {
                daftarMobil[i] = daftarMobil[i + 1];
            }
            jumlah--;
        } else {
            System.out.println("Index tidak valid!");
        }
    }
	public static void tampilSemua() {
        for (int i = 0; i < jumlah; i++) {
            daftarMobil[i].tampilMobil();
        }
    }
} 