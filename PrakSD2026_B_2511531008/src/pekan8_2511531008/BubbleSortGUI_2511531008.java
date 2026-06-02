package pekan8_2511531008;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; 
import java.awt.FlowLayout;
import java.awt.Font;

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

public class BubbleSortGUI_2511531008 extends JFrame {
    private static final long serialVersionUID = 1L;
    private int[] array_1008;
    private JLabel[] labelAray_1008;
    private JButton stepButton_1008, resetButton_1008, setButton_1008;
    private JTextField inputField_1008;
    private JPanel panelArray_1008;
    private JTextArea stepArea_1008;

    private int i_1008 = 1, j_1008;
    private boolean sorting_1008 = false;
    private int stepCount_1008 = 1;

    public BubbleSortGUI_2511531008() {
        setTitle("Insertion Sort Langkah per Langkah");
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
        stepArea_1008 = new JTextArea(0, 60);
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

        // Event reset_1008
        resetButton_1008.addActionListener(e -> reset_1008());
    }

    private void setArrayFromInput_1008() {
        String text_1008 = inputField_1008.getText().trim();
        if (text_1008.isEmpty()) return;
        String[] parts = text_1008.split(",");
        array_1008 = new int[parts.length];
        try {
            for (int k_1008 = 0; k_1008 < parts.length; k_1008++) {
                array_1008[k_1008] = Integer.parseInt(parts[k_1008].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan"
                    + " dengan koma!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        i_1008 = 0;
        j_1008 = 0;
        stepCount_1008 = 1;
        sorting_1008 = true;
        stepButton_1008.setEnabled(true);
        stepArea_1008.setText("");
        panelArray_1008.removeAll();
        labelAray_1008 = new JLabel[array_1008.length];
        for (int k_1008 = 0; k_1008 < array_1008.length; k_1008++) {
            labelAray_1008[k_1008] = new JLabel(String.valueOf(array_1008[k_1008]));
            labelAray_1008[k_1008].setFont(new Font("Arial", Font.BOLD, 24));
            labelAray_1008[k_1008].setOpaque(true);
            labelAray_1008[k_1008].setBackground(Color.WHITE);
            labelAray_1008[k_1008].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelAray_1008[k_1008].setPreferredSize(new Dimension(50, 50)); 
            labelAray_1008[k_1008].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_1008.add(labelAray_1008[k_1008]);
        }
        panelArray_1008.revalidate();
        panelArray_1008.repaint();
    }

    private void performStep_1008() {
        if (!sorting_1008 || i_1008 >= array_1008.length - 1) {
            sorting_1008 = false;
            stepButton_1008.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
            return;
        }
        
        StringBuilder stepLog_1008 = new StringBuilder();
        labelAray_1008[j_1008].setBackground(Color.CYAN);
        labelAray_1008[j_1008 + 1].setBackground(Color.CYAN);
        if (array_1008[j_1008] > array_1008[j_1008 + 1]) {
            // Swap
            int temp_1008 = array_1008[j_1008];
            array_1008[j_1008] = array_1008[j_1008 + 1];
            array_1008[j_1008 + 1] = temp_1008;
            labelAray_1008[j_1008].setBackground(Color.RED);
            labelAray_1008[j_1008 + 1].setBackground(Color.RED);
            stepLog_1008.append("Langkah ").append(stepCount_1008).append(": Menukar elemen ke-")
                   .append(j_1008).append(" (").append(array_1008[j_1008 + 1]).append(") dengan elemen ke-")
                   .append(j_1008 + 1).append(" (").append(array_1008[j_1008]).append(")\n");
        } else {
            stepLog_1008.append("Langkah ").append(stepCount_1008).append(": Tidak ada pertukaran antara ke-")
                   .append(j_1008).append(" dan ke-").append(j_1008 + 1).append("\n");
        }
        stepLog_1008.append("Hasil: ").append(arrayToString_1008(array_1008)).append("\n\n");
        stepArea_1008.append(stepLog_1008.toString());
        updateLabels_1008();
        j_1008++;
        if (j_1008 >= array_1008.length - i_1008 - 1) {
            j_1008 = 0;
            i_1008++;
        }
        stepCount_1008++;
        if (i_1008 >= array_1008.length - 1) {
            sorting_1008 = false;
            stepButton_1008.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void updateLabels_1008() {
        for (int k_1008 = 0; k_1008 < array_1008.length; k_1008++) {
            labelAray_1008[k_1008].setText(String.valueOf(array_1008[k_1008]));
        }
    }

    private void reset_1008() {
        inputField_1008.setText("");
        panelArray_1008.removeAll();
        panelArray_1008.revalidate();
        panelArray_1008.repaint();
        stepArea_1008.setText("");
        stepButton_1008.setEnabled(false);
        sorting_1008 = false;
        i_1008 = 0;
        j_1008 = 0;
        stepCount_1008 = 1;
    }

    private String arrayToString_1008(int[] arr_1008) {
        StringBuilder sb = new StringBuilder();
        for (int k_1008 = 0; k_1008 < arr_1008.length; k_1008++) {
            sb.append(arr_1008[k_1008]);
            if (k_1008 < arr_1008.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	BubbleSortGUI_2511531008 gui = new BubbleSortGUI_2511531008();
            gui.setVisible(true);
        });
    }
}