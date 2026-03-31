package pekan1_2511531008;


public final class Jam_2511531008{
	private int hh; // 0..23
	private int mm; // 0..59
	private int ss; // 0..59
	
	// --- Validator ---
	public static boolean isValid(int h, int m, int s) {
		return (h > 0) && (h <=23) && (m > 0) && (m <=59) && (s > 0) && (s <=59);  
	}
	// --- kontruktor / kreator ---
	public Jam_2511531008(int h, int m, int s) {
		this.hh = h; this.mm = m; this.ss = s;
	}
	
	//-- selektor --
	public int getHour() { return hh; }
	public int getMinute() { return mm; }
	public int getSecond() { return ss; }
	
	// --- mutator ---
	public void setHour (int h) { this.hh = h; }
	public void setMinute (int m) { this.mm = m; }
	public void setSecond (int s) { this.ss = s; }
	
	// ---konversi ---
	public int  ToSeconds() { return 3600 * hh + 60 * mm + ss; }
	public static Jam_2511531008 fromSeconds(int total) {
		if (total < 0) throw new IllegalArgumentException("detik negatif");
		total %= 24 * 3600;
		int h = total /3600 ; total %= 3600;
		int m = total /60 ; total %= 60;
		int s = total;
		return new Jam_2511531008(h,m,s);
	}
	
	// --- Relasional ---
	public int compareTo(Jam_2511531008 other) { return Integer.compare(this.ToSeconds(),other.ToSeconds());}
	public boolean equals (Object o) {
		if(! (o instanceof Jam_2511531008 j)) return false;
		return hh == j.hh && mm == j.mm && ss == j.ss;
	}
	public int hashCode() {return java.util.Objects.hash(hh,mm,ss);}
	
	// --- Aritmatika ---
	public Jam_2511531008 plus (Jam_2511531008 other) {return fromSeconds (this.ToSeconds() + other.ToSeconds());}
	public Jam_2511531008 minus(Jam_2511531008 other ) {return fromSeconds(Math.floorMod(this.ToSeconds()-other.ToSeconds(), 24*3600));}
	public Jam_2511531008 nextSecond() { return fromSeconds(this.ToSeconds()+1); }
	public Jam_2511531008 nextNSeconds (int n) {return fromSeconds(this.ToSeconds() + Math.max(0, n));}
	public Jam_2511531008 prevSecond() {return fromSeconds(Math.floorMod(this.ToSeconds()-1 , 24*3600));}
	public Jam_2511531008 prevNSeconds(int n) { return fromSeconds(Math.floorMod(this.ToSeconds() - Math.max(0, n), 24*3600));}
	
	// --- Durasi (detik) -- bisa negatif jika this > other ? sesuai spesifikasi durasi (JAw, JAkh)
	public static int durasiDetik( Jam_2511531008 jaw, Jam_2511531008 jakh) { return jakh.ToSeconds() - jaw.ToSeconds();}
	public String toString() {return String.format("%02d:%02d:%02d", hh,mm,ss);}
}
