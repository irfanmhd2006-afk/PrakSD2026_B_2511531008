package pekan7_2511531008;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SortingMahasiswaGUI_2511531008 extends JFrame {
    private static final long serialVersionUID = 1L;
    
    // array list mahasiswa
    private ArrayList<Mahasiswa_2511531008> listMahasiswa_2511531008 = new ArrayList<>();
    
    
    private JTextField txtNama_1008, txtNim_1008, txtProdi_1008;
    private JComboBox<String> cmbAlgoritma_1008;
    private JTable tabelMahasiswa_2511531008;
    private DefaultTableModel tableModel_1008;
    private JTextArea txtAreaLog_1008;
    private JButton btnTambah_1008, btnHapus_1008, btnSort_1008;

    public SortingMahasiswaGUI_2511531008() {
        setTitle("Pengurutan Nama Mahasiswa Alfabetis_2511531008");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        // 1. PANEL INPUT (Bagian Atas / NORTH)
        JPanel panelInput_1008 = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput_1008.setBorder(BorderFactory.createTitledBorder("Form Input Data Mahasiswa"));
        
        panelInput_1008.add(new JLabel(" Nama Mahasiswa:"));
        txtNama_1008 = new JTextField();
        panelInput_1008.add(txtNama_1008);
        
        panelInput_1008.add(new JLabel(" NIM Mahasiswa:"));
        txtNim_1008 = new JTextField();
        panelInput_1008.add(txtNim_1008);
        
        panelInput_1008.add(new JLabel(" Program Studi:"));
        txtProdi_1008 = new JTextField();
        panelInput_1008.add(txtProdi_1008);
        
        btnTambah_1008 = new JButton("Tambah Data");
        btnHapus_1008 = new JButton("Hapus Data Terpilih");
        panelInput_1008.add(btnTambah_1008);
        panelInput_1008.add(btnHapus_1008);

        // 2. panel utama, tempat letak data dan sorting
        JPanel panelTengah_1008 = new JPanel(new BorderLayout(5, 5));
        
        // Setup Tabel
        String[] kolom_1008 = {"NIM", "Nama Mahasiswa", "Program Studi"};
        tableModel_1008 = new DefaultTableModel(kolom_1008, 0);
        tabelMahasiswa_2511531008 = new JTable(tableModel_1008);
        JScrollPane scrollTabel_1008 = new JScrollPane(tabelMahasiswa_2511531008);
        panelTengah_1008.add(scrollTabel_1008, BorderLayout.CENTER);
        
        // Panel Kontrol Batas Bawah Tabel
        JPanel panelKontrolSort_1008 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelKontrolSort_1008.add(new JLabel("Pilih Algoritma:"));
        String[] pilihanSort_1008 = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
        cmbAlgoritma_1008 = new JComboBox<>(pilihanSort_1008);
        panelKontrolSort_1008.add(cmbAlgoritma_1008);
        
        btnSort_1008 = new JButton("Mulai Sorting");
        panelKontrolSort_1008.add(btnSort_1008);
        panelTengah_1008.add(panelKontrolSort_1008, BorderLayout.SOUTH);

        // 3. panel sebelah kanan (langkah2 pengurutan)
        JPanel panelLog_1008 = new JPanel(new BorderLayout());
        panelLog_1008.setBorder(BorderFactory.createTitledBorder("Langkah-Langkah Proses Sorting"));
        txtAreaLog_1008 = new JTextArea(0, 30);
        txtAreaLog_1008.setEditable(false);
        txtAreaLog_1008.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollLog_1008 = new JScrollPane(txtAreaLog_1008);
        panelLog_1008.add(scrollLog_1008, BorderLayout.CENTER);

        
        getContentPane().add(panelInput_1008, BorderLayout.NORTH);
        getContentPane().add(panelTengah_1008, BorderLayout.CENTER);
        getContentPane().add(panelLog_1008, BorderLayout.EAST);

  
        
        // Event Tambah Data
        btnTambah_1008.addActionListener(e -> tambahDataMahasiswa());

        // Event Hapus Data
        btnHapus_1008.addActionListener(e -> hapusDataMahasiswa());

        // Event Proses Sorting
        btnSort_1008.addActionListener(e -> prosesSorting());
    }

    private void tambahDataMahasiswa() {
        String nama = txtNama_1008.getText().trim();
        String nim = txtNim_1008.getText().trim();
        String prodi = txtProdi_1008.getText().trim();

        if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua form input wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Mahasiswa_2511531008 mhs = new Mahasiswa_2511531008(nama, nim, prodi);
        listMahasiswa_2511531008.add(mhs);

        tableModel_1008.addRow(new Object[]{mhs.getNim_1008(), mhs.getNama_1008(), mhs.getProdi_1008()});

        txtNama_1008.setText("");
        txtNim_1008.setText("");
        txtProdi_1008.setText("");
    }

    private void hapusDataMahasiswa() {
        int barisTerpilih = tabelMahasiswa_2511531008.getSelectedRow();
        if (barisTerpilih >= 0) {
            listMahasiswa_2511531008.remove(barisTerpilih);
            tableModel_1008.removeRow(barisTerpilih);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris pada tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void prosesSorting() {
        if (listMahasiswa_2511531008.size() < 2) {
            JOptionPane.showMessageDialog(this, "Data mahasiswa minimal harus berjumlah 2 untuk diurutkan!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        txtAreaLog_1008.setText(""); // Bersihkan log lama
        String algoritma = (String) cmbAlgoritma_1008.getSelectedItem();

        txtAreaLog_1008.append("Data Awal: " + listMahasiswa_2511531008.toString() + "\n");
        txtAreaLog_1008.append("===================================\n");

        // Jalankan metode berdasarkan ComboBox yang dipilih
        if (algoritma.equals("Insertion Sort")) {
            txtAreaLog_1008.append("=== INSERTION SORT ===\n");
            insertionSort_1008();
        } else if (algoritma.equals("Selection Sort")) {
            txtAreaLog_1008.append("=== SELECTION SORT ===\n");
            selectionSort_1008();
        } else if (algoritma.equals("Bubble Sort")) {
            txtAreaLog_1008.append("=== BUBBLE SORT ===\n");
            bubbleSort_1008();
        }

        // Perbarui susunan tampilan data pada JTable setelah sukses diurutkan
        refreshTable();
        JOptionPane.showMessageDialog(this, "Proses pengurutan selesai secara Ascending!");
    }
    
    
   // algortima pengurutan disini
    private void insertionSort_1008() {
        int n = listMahasiswa_2511531008.size();
        int langkah = 1;
        for (int i = 1; i < n; i++) {
            Mahasiswa_2511531008 key = listMahasiswa_2511531008.get(i);
            int j = i - 1;

            // Menggunakan compareToIgnoreCase() untuk membandingkan Nama secara alfabetis (A-Z)
            while (j >= 0 && listMahasiswa_2511531008.get(j).getNama_1008().compareToIgnoreCase(key.getNama_1008()) > 0) {
                listMahasiswa_2511531008.set(j + 1, listMahasiswa_2511531008.get(j));
                j--;
            }
            listMahasiswa_2511531008.set(j + 1, key);
            
            // Catat visualisasi log langkah per langkah
            txtAreaLog_1008.append("Langkah " + (langkah++) + ": " + listMahasiswa_2511531008.toString() + "\n");
        }
    }

    private void selectionSort_1008() {
        int n = listMahasiswa_2511531008.size();
        int pass = 1;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                // Cari elemen nama terkecil secara alfabetis
                if (listMahasiswa_2511531008.get(j).getNama_1008().compareToIgnoreCase(listMahasiswa_2511531008.get(minIdx).getNama_1008()) < 0) {
                    minIdx = j;
                }
            }
            // Swap elemen
            Mahasiswa_2511531008 temp = listMahasiswa_2511531008.get(minIdx);
            listMahasiswa_2511531008.set(minIdx, listMahasiswa_2511531008.get(i));
            listMahasiswa_2511531008.set(i, temp);

            // Catat visualisasi log langkah per pass
            txtAreaLog_1008.append("Pass " + (pass++) + ": " + listMahasiswa_2511531008.toString() + "\n");
        }
    }

    private void bubbleSort_1008() {
        int n = listMahasiswa_2511531008.size();
        int pass = 1;
        for (int i = 0; i < n; i++) {
            boolean ditukar = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Jika elemen kiri lebih besar alfabetisnya dari kanan, lakukan swap
                if (listMahasiswa_2511531008.get(j).getNama_1008().compareToIgnoreCase(listMahasiswa_2511531008.get(j + 1).getNama_1008()) > 0) {
                    Mahasiswa_2511531008 temp = listMahasiswa_2511531008.get(j);
                    listMahasiswa_2511531008.set(j, listMahasiswa_2511531008.get(j + 1));
                    listMahasiswa_2511531008.set(j + 1, temp);
                    ditukar = true;
                }
            }
            // Catat visualisasi log langkah per pass
            txtAreaLog_1008.append("Pass " + (pass++) + ": " + listMahasiswa_2511531008.toString() + "\n");
            
            // Optimasi: jika dalam satu putaran penuh tidak ada swap, hentikan loop lebih awal
            if (!ditukar) break; 
        }
    }

    private void refreshTable() {
        tableModel_1008.setRowCount(0); // Kosongkan tabel lama
        for (Mahasiswa_2511531008 mhs : listMahasiswa_2511531008) {
            tableModel_1008.addRow(new Object[]{mhs.getNim_1008(), mhs.getNama_1008(), mhs.getProdi_1008()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortingMahasiswaGUI_2511531008().setVisible(true);
        });
    }
}