package pekan5_2511531008;

public class Pasien_2511531008 {
	private String nama_1008;
	private String penyakit_1008;
	private int antrian_1008;
	//pointer next
	Pasien_2511531008 next_1008;
	public Pasien_2511531008(String nama_1008, String penyakit_1008,int antrian_1008){
		this.nama_1008 = nama_1008;
		this.penyakit_1008 = penyakit_1008;
		this.antrian_1008 = antrian_1008;
		this.next_1008 = next_1008;
	}
	public String getnama_1008(){
		return nama_1008;
	}
	public String getpenyakit_1008(){
		return penyakit_1008;
	}
	public int getantrian_1008(){
		return antrian_1008;
	}
	@Override
	public String toString() {
	    return "No. Antrian: " + antrian_1008 + 
	           " | Nama: " + nama_1008 + 
	           " | Penyakit: " + penyakit_1008;
	}

}
