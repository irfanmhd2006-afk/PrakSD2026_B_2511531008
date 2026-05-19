package pekan7_2511531008;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; // ✅ Tambahan import
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

public class InsertionSortGUI_2511531008 extends JFrame {
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

    public InsertionSortGUI_2511531008() {
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
        resetButton_1008 = new JButton("Reset");
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
        setButton_1008.addActionListener(e -> setArrayFromInput());

        // Event Langkah Selanjutnya
        stepButton_1008.addActionListener(e -> performStep()); // ✅ Diperbaiki: stepButton bukan setButton

        // Event Reset
        resetButton_1008.addActionListener(e -> reset());
    }

    private void setArrayFromInput() {
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
        }
        i_1008 = 1;
        stepCount_1008 = 1;
        sorting_1008 = true;
        stepButton_1008.setEnabled(true);
        stepArea_1008.setText("");
        panelArray_1008.removeAll();
        labelAray_1008 = new JLabel[array_1008.length];
        for (int k_1008 = 0; k_1008 < array_1008.length; k_1008++) {
            labelAray_1008[k_1008] = new JLabel(String.valueOf(array_1008[k_1008]));
            labelAray_1008[k_1008].setFont(new Font("Arial", Font.BOLD, 24));
            labelAray_1008[k_1008].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelAray_1008[k_1008].setPreferredSize(new Dimension(50, 50)); // ✅ Diperbaiki
            labelAray_1008[k_1008].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_1008.add(labelAray_1008[k_1008]);
        }
        panelArray_1008.revalidate();
        panelArray_1008.repaint();
    }

    private void performStep() {
        if (i_1008 < array_1008.length && sorting_1008) {
            int key_1008 = array_1008[i_1008];
            j_1008 = i_1008 - 1;

            StringBuilder stepLog = new StringBuilder();
            stepLog.append("Langkah ").append(stepCount_1008).append(": Memasukkan ").append(key_1008).append("\n");
            while (j_1008 >= 0 && array_1008[j_1008] > key_1008) {
                array_1008[j_1008 + 1] = array_1008[j_1008];
                j_1008--; // ✅ Tambahan: agar tidak infinite loop
            }
            array_1008[j_1008 + 1] = key_1008;

            updateLabels();
            stepLog.append("Hasil: ").append(arrayToString(array_1008)).append("\n\n"); // ✅ Diperbaiki
            stepArea_1008.append(stepLog.toString());

            i_1008++;
            stepCount_1008++;

            if (i_1008 == array_1008.length) {
                sorting_1008 = false;
                stepButton_1008.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Sorting selesai!");
            }
        }
    }

    private void updateLabels() {
        for (int k_1008 = 0; k_1008 < array_1008.length; k_1008++) {
            labelAray_1008[k_1008].setText(String.valueOf(array_1008[k_1008]));
        }
    }

    private void reset() {
        inputField_1008.setText("");
        panelArray_1008.removeAll();
        panelArray_1008.revalidate();
        panelArray_1008.repaint();
        stepArea_1008.setText("");
        stepButton_1008.setEnabled(false);
        sorting_1008 = false;
        i_1008 = 1;
        stepCount_1008 = 1;
    }

    private String arrayToString(int[] arr_1008) {
        StringBuilder sb = new StringBuilder();
        for (int k_1008 = 0; k_1008 < arr_1008.length; k_1008++) {
            sb.append(arr_1008[k_1008]);
            if (k_1008 < arr_1008.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InsertionSortGUI_2511531008 gui = new InsertionSortGUI_2511531008();
            gui.setVisible(true);
        });
    }
}