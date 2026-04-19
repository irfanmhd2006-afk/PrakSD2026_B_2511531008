package pekan2_2511531008;

public class Musik_2511531008 {

    private String judul_1008;
    private String penyanyi_1008;
    private int durasi_1008;

    public Musik_2511531008(String judul, String penyanyi, int durasi) {
        this.judul_1008 = judul;
        this.penyanyi_1008 = penyanyi;
        this.durasi_1008 = durasi;
    }

    public String getJudul_1008() {
        return judul_1008;
    }

    public String getPenyanyi_1008() {
        return penyanyi_1008;
    }

    public int getDurasi_1008() {
        return durasi_1008;
    }
    @Override
    public String toString() {
    	return "judul : " + judul_1008 + "\n"+
               "penyanyi : " + penyanyi_1008 + "\n" +
    			"durasi : " + durasi_1008 + "\n";
    }
}