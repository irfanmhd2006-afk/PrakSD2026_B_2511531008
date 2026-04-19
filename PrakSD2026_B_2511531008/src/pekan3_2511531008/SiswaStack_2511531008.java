package pekan3_2511531008;
import java.util.ArrayList;
class Siswa_2511531008 {
	String nama;
	int nim;
	public Siswa_2511531008(String nama, int nim) {
		this.nama = nama;
		this.nim = nim;
	}
	
	@Override
	public String toString() {
		return "Nim: " + nim + ", Nama: " + nama;
	}
}
public class SiswaStack_2511531008{
	private ArrayList<Siswa_2511531008> stack;
	public SiswaStack_2511531008() {
		stack = new ArrayList<>();
	}
	public void push(Siswa_2511531008 mhs) {
		stack.add(mhs);
	}
	public Siswa_2511531008 pop_2511531008() {
		if(!isEmpty_2511531008()) {
			return stack.remove(stack.size()- 1);
		}
		return null;
	}
	public Siswa_2511531008 peek_2511531008() {
		if (!isEmpty_2511531008()) {
			return stack.get(stack.size() -1);
		}
		return null;
	}
	public boolean isEmpty_2511531008() {
		return stack.isEmpty();
	}
	public void tampilkanSiswa_2511531008() {
		for(int i = stack.size() - 1; i >=  0; i--) {
			System.out.println(stack.get(i));
		}
	}
	public static void main(String[] args) {
		SiswaStack_2511531008 studentStack = new SiswaStack_2511531008();
		Siswa_2511531008 mhs1 = new Siswa_2511531008("Ali", 1);
		Siswa_2511531008 mhs2 = new Siswa_2511531008("Boby", 2);
		Siswa_2511531008 mhs3 = new Siswa_2511531008("Charles", 3);
		
		studentStack.push(mhs1);
		studentStack.push(mhs2);
		studentStack.push(mhs3);
		
		System.out.println("Siswa di dalam stack:");
		studentStack.tampilkanSiswa_2511531008();
		
		System.out.println("Siswa teratas " + studentStack.peek_2511531008());
		System.out.println("mengeluarkan siswa teratas dari stack: " + studentStack.pop_2511531008() );
		System.out.print("daftar siswa setelah di pop :");
		studentStack.tampilkanSiswa_2511531008();
	}

}
