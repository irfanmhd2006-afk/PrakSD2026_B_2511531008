package pekan8_2511531008;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; 
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MergeSortGUI_2511531008 extends JFrame {
    private static final long serialVersionUID = 1L;
    private int[] array_1008;
    private JLabel[] labelArray_1008;
    private JButton stepButton_1008, resetButton_1008, setButton_1008;
    private JTextField inputField_1008;
    private JPanel panelArray_1008;
    private JTextArea stepArea_1008;
    
    // Variabel state kontrol algoritma Merge Sort per langkah
    private boolean isMerging_1008;
    private boolean copying_1008;
    private int[] temp_1008;
    private int left_1008, mid_1008, right_1008;
    private int i_1008, j_1008, k_1008;
    private int stepCount_1008 = 1;
    
    // Queue untuk menyimpan langkah pengerjaan cakupan indeks (left, mid, right)
    private Queue<int[]> mergeQueue_1008 = new LinkedList<>();

    public MergeSortGUI_2511531008() {
        setTitle("Merge Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel_1008 = new JPanel(new FlowLayout());
        inputField_1008 = new JTextField(30);
        setButton_1008 = new JButton("Set Array");
        inputPanel_1008.add(new JLabel("Masukkan angka (pisahkan dengan koma) :"));
        inputPanel_1008.add(inputField_1008);
        inputPanel_1008.add(setButton_1008);

        // Panel array visual
        panelArray_1008 = new JPanel();
        panelArray_1008.setLayout(new FlowLayout());

        // Panel kontrol
        JPanel controlPanel_1008 = new JPanel();
        stepButton_1008 = new JButton("Langkah Selanjutnya");
        resetButton_1008 = new JButton("reset");
        stepButton_1008.setEnabled(false);
        controlPanel_1008.add(stepButton_1008);
        controlPanel_1008.add(resetButton_1008);

        // Area teks untuk log langkah
        stepArea_1008 = new JTextArea(0, 30);
        stepArea_1008.setEditable(false);
        stepArea_1008.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_1008 = new JScrollPane(stepArea_1008);

        // Tambahkan panel ke frame
        add(inputPanel_1008, BorderLayout.NORTH);
        add(panelArray_1008, BorderLayout.CENTER);
        add(controlPanel_1008, BorderLayout.SOUTH);
        add(scrollPane_1008, BorderLayout.EAST);

        // Event Set Array
        setButton_1008.addActionListener(e -> setArrayFromInput_1008());

        // Event Langkah Selanjutnya
        stepButton_1008.addActionListener(e -> performStep_1008()); 

        // Event reset
        resetButton_1008.addActionListener(e -> reset_1008());
    }

    private void setArrayFromInput_1008() {
        String text_1008 = inputField_1008.getText().trim();
        if (text_1008.isEmpty()) return;
        String[] parts_1008 = text_1008.split(",");
        array_1008 = new int[parts_1008.length];
        try {
            for (int i_1008 = 0; i_1008 < parts_1008.length; i_1008++) {
                array_1008[i_1008] = Integer.parseInt(parts_1008[i_1008].trim());
            }
        } catch (NumberFormatException e_1008) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        labelArray_1008 = new JLabel[array_1008.length];
        panelArray_1008.removeAll();
        for (int i_1008 = 0; i_1008 < array_1008.length; i_1008++) {
            labelArray_1008[i_1008] = new JLabel(String.valueOf(array_1008[i_1008]));
            labelArray_1008[i_1008].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_1008[i_1008].setOpaque(true);
            labelArray_1008[i_1008].setBackground(Color.WHITE);
            labelArray_1008[i_1008].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_1008[i_1008].setPreferredSize(new Dimension(50, 50));
            labelArray_1008[i_1008].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_1008.add(labelArray_1008[i_1008]);
        }
        
        mergeQueue_1008.clear();
        generateMergeSteps_1008(0, array_1008.length - 1);
        stepButton_1008.setEnabled(true);
        stepArea_1008.setText("");
        stepCount_1008 = 1;
        isMerging_1008 = false;
        copying_1008 = false;
        panelArray_1008.revalidate();
        panelArray_1008.repaint();
    }

    // Fungsi Rekursif untuk mendaftarkan pembagian indeks ke dalam Queue secara berkala
    private void generateMergeSteps_1008(int l_1008, int r_1008) {
        if (l_1008 < r_1008) {
            int m_1008 = l_1008 + (r_1008 - l_1008) / 2;
            generateMergeSteps_1008(l_1008, m_1008);
            generateMergeSteps_1008(m_1008 + 1, r_1008);
            mergeQueue_1008.add(new int[]{l_1008, m_1008, r_1008});
        }
    }

    private void performStep_1008() {
        resetHighlights_1008();
        
        if (copying_1008 && k_1008 < temp_1008.length) {
            array_1008[left_1008 + k_1008] = temp_1008[k_1008];
            labelArray_1008[left_1008 + k_1008].setText(String.valueOf(temp_1008[k_1008]));
            labelArray_1008[left_1008 + k_1008].setBackground(Color.GREEN);
            k_1008++;
            stepArea_1008.append("Langkah " + stepCount_1008++ + ": Tempelkan ke array utama\n");
            return;
        }
        
        if (copying_1008 && k_1008 == temp_1008.length) {
            isMerging_1008 = false;
            copying_1008 = false;
        }
        
        if (mergeQueue_1008.isEmpty() && !isMerging_1008) {
            stepArea_1008.append("Selesai.\n");
            stepButton_1008.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
            return;
        }
        
        if (!isMerging_1008 && !mergeQueue_1008.isEmpty()) {
            int[] range_1008 = mergeQueue_1008.poll();
            left_1008 = range_1008[0];
            mid_1008 = range_1008[1];
            right_1008 = range_1008[2];
            temp_1008 = new int[right_1008 - left_1008 + 1];
            i_1008 = left_1008;
            j_1008 = mid_1008 + 1;
            k_1008 = 0;
            copying_1008 = false;
            isMerging_1008 = true;
            stepArea_1008.append("Langkah " + stepCount_1008++ + 
                    ": Mulai merge dari " + left_1008 + " ke " + right_1008 + "\n");
            return;
        }
        
        if (isMerging_1008 && !copying_1008) {
            if (i_1008 <= mid_1008 && j_1008 <= right_1008) {
                labelArray_1008[i_1008].setBackground(Color.CYAN);
                labelArray_1008[j_1008].setBackground(Color.CYAN);
                if (array_1008[i_1008] <= array_1008[j_1008]) {
                    temp_1008[k_1008++] = array_1008[i_1008++];
                } else {
                    temp_1008[k_1008++] = array_1008[j_1008++];
                }
                stepArea_1008.append("Langkah " + stepCount_1008++ + ": Bandingkan dan salin elemen\n");
                return;
            } else if (i_1008 <= mid_1008) {
                temp_1008[k_1008++] = array_1008[i_1008++];
                stepArea_1008.append("Langkah " + stepCount_1008++ + ": Salin sisa kiri\n");
                return;
            } else if (j_1008 <= right_1008) {
                temp_1008[k_1008++] = array_1008[j_1008++];
                stepArea_1008.append("Langkah " + stepCount_1008++ + ": Salin sisa kanan\n");
                return;
            } else {
                copying_1008 = true;
                k_1008 = 0;
                return;
            }
        }
    }

    private void resetHighlights_1008() {
        if (labelArray_1008 == null) return;
        for (JLabel label_1008 : labelArray_1008) {
            label_1008.setBackground(Color.WHITE);
        }
    }

    private void reset_1008() {
        inputField_1008.setText("");
        panelArray_1008.removeAll();
        panelArray_1008.revalidate();
        panelArray_1008.repaint();
        stepArea_1008.setText("");
        stepButton_1008.setEnabled(false);
        mergeQueue_1008.clear();
        isMerging_1008 = false;
        copying_1008 = false;
        stepCount_1008 = 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            MergeSortGUI_2511531008 gui_1008 = new MergeSortGUI_2511531008();
            gui_1008.setVisible(true);
        });
    }
}