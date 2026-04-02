package pekan1_2511531008;


public class DriverMobil_2511531008 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Mobil_2511531008 m1 = new Mobil_2511531008("Avanza", 2020, 1300, 150000000, "Toyota");
	     Mobil_2511531008 m2 = new Mobil_2511531008("Brio", 2022, 1200, 170000000, "Honda");
	     
	     Mobil_2511531008.tambahMobil(m1);
	     Mobil_2511531008.tambahMobil(m2);

	     System.out.println("=== DATA MOBIL ===");
	     Mobil_2511531008.tampilSemua();
	     
	     System.out.println("=== HAPUS INDEX 1 ===");
	     Mobil_2511531008.hapusMobil(1);

	     Mobil_2511531008.tampilSemua();
	     
	}

}
