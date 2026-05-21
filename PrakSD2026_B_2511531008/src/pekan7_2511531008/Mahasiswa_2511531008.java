package pekan7_2511531008;

public class Mahasiswa_2511531008 {
    // Atribut Mahasiswa
    private String nama_1008;
    private String nim_1008;
    private String prodi_1008;

    // Constructor
    public Mahasiswa_2511531008(String nama_1008, String nim_1008, String prodi_1008) {
        this.nama_1008 = nama_1008;
        this.nim_1008 = nim_1008;
        this.prodi_1008 = prodi_1008;
    }

    // Getter 
    public String getNama_1008() {return nama_1008;}
    public String getNim_1008() { return nim_1008; }
    public String getProdi_1008() { return prodi_1008;}
    //setter
    public void setNama_1008(String nama_1008) { this.nama_1008 = nama_1008;}
    public void setNim_1008(String nim_1008) {this.nim_1008 = nim_1008; }
    public void setProdi_1008(String prodi_1008) { this.prodi_1008 = prodi_1008; }

    @Override
    public String toString() {
        return nama_1008;
    }
}