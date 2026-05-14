package pekan6_2511531008;
public class Lagu_2511531008 {   
    private String judul_1008;
    private String penyanyi_1008;
    Lagu_2511531008 next_1008; // pointer ke node berikutnya
    Lagu_2511531008 prev_1008; // pointer ke node sebelumnya
    
    public Lagu_2511531008(String judul_1008, String penyanyi_1008) {
        this.judul_1008    = judul_1008;
        this.penyanyi_1008 = penyanyi_1008;
        this.next_1008     = null;
        this.prev_1008     = null;
    }
    // getter
    public String getJudul_1008() {return judul_1008;}
    public String getPenyanyi_1008() {return penyanyi_1008;}
    // Setter 
    public void setJudul_1008(String judul_1008) {this.judul_1008 = judul_1008;}
    public void setPenyanyi_1008(String penyanyi_1008) {this.penyanyi_1008 = penyanyi_1008;}
    
    @Override
    public String toString() {
        return judul_1008 + " - " + penyanyi_1008;
    }
}