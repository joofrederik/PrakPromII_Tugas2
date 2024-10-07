package Tugas2;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class PendaftaranNasabahBank extends JFrame {
    // Komponen form
    private JTextField textFieldNama;
    private JTextField textFieldHP;
    private JRadioButton radioButtonLaki;
    private JRadioButton radioButtonPerempuan;
    private JCheckBox checkBoxWNA;
    private JTextArea txtOutput;
    private JList<String> listTabungan;
    private JSpinner spinnerFrekuensi;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JSpinner spinnerTanggalLahir;

    public PendaftaranNasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pendaftaran Nasabah Bank");

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuReset = new JMenuItem("Reset");
        JMenuItem menuExit = new JMenuItem("Exit");

        // Action listener untuk menu Reset
        menuReset.addActionListener(e -> resetForm());
        
        // Action listener untuk menu Exit
        menuExit.addActionListener(e -> System.exit(0));

        menuFile.add(menuReset);
        menuFile.add(menuExit);
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);

        // Label dan Text Field untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 100, 25);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(120, 40, 200, 25);

        // Label dan Text Field untuk Nomor HP
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 80, 100, 25);
        textFieldHP = new JTextField();
        textFieldHP.setBounds(120, 80, 200, 25);

        // Label Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 120, 100, 25);
        radioButtonLaki = new JRadioButton("Laki-Laki");
        radioButtonLaki.setBounds(120, 120, 100, 25);
        radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(220, 120, 100, 25);
        
        // ButtonGroup untuk jenis kelamin
        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(radioButtonLaki);
        groupGender.add(radioButtonPerempuan);

        // Checkbox WNA
        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(120, 160, 200, 25);

        // Input Jenis Tabungan menggunakan JList
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(15, 200, 100, 25);
        String[] tabunganOptions = {"Tabungan Umum", "Tabungan Pendidikan", "Tabungan Haji", "Tabungan Investasi"};
        listTabungan = new JList<>(tabunganOptions);
        listTabungan.setBounds(120, 200, 200, 60);
        listTabungan.setBorder(BorderFactory.createEtchedBorder());

        // Input Frekuensi Transaksi menggunakan JSpinner
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi:");
        labelFrekuensi.setBounds(15, 270, 150, 25);
        spinnerFrekuensi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerFrekuensi.setBounds(170, 270, 50, 25);

        // Input Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 310, 100, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 310, 200, 25);

        // Input Confirm Password
        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(15, 350, 120, 25);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(150, 350, 200, 25);

        // Input Tanggal Lahir menggunakan JSpinner
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 390, 100, 25);
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd-MM-yyyy");
        spinnerTanggalLahir.setEditor(editor);
        spinnerTanggalLahir.setBounds(120, 390, 100, 25);

        // Tombol Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(120, 430, 100, 30);

        // TextArea untuk menampilkan output
        txtOutput = new JTextArea();
        txtOutput.setBounds(15, 470, 350, 150);
        txtOutput.setEditable(false); // Output hanya dapat dibaca

        // Action Listener untuk tombol Simpan
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil data dari field dan radio button
                String nama = textFieldNama.getText();
                String nomorHP = textFieldHP.getText();
                String jenisKelamin = "";
                if (radioButtonLaki.isSelected()) {
                    jenisKelamin = "Laki-Laki";
                } else if (radioButtonPerempuan.isSelected()) {
                    jenisKelamin = "Perempuan";
                }
                // Mengambil jenis tabungan
                String jenisTabungan = listTabungan.getSelectedValue();
                // Mengambil frekuensi transaksi
                int frekuensi = (int) spinnerFrekuensi.getValue();
                // Mengambil status WNA
                String wna = checkBoxWNA.isSelected() ? "Ya" : "Bukan";
                // Mengambil password
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String passwordMatch = password.equals(confirmPassword) ? "Cocok" : "Tidak Cocok";
                // Mengambil tanggal lahir
                String tanggalLahir = spinnerTanggalLahir.getValue().toString();

                // Menampilkan hasil di JTextArea
                txtOutput.setText("");
                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("Nomor HP: " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA: " + wna + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi: " + frekuensi + " kali/bulan\n");
                txtOutput.append("Password dan Confirm Password: " + passwordMatch + "\n");
                txtOutput.append("Tanggal Lahir: " + tanggalLahir + "\n");
                
               
                
            }
        });

        // Menambahkan komponen ke frame
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelHP);
        this.add(textFieldHP);
        this.add(labelGender);
        this.add(radioButtonLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(labelTabungan);
        this.add(listTabungan);
        this.add(labelFrekuensi);
        this.add(spinnerFrekuensi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(buttonSimpan);
        this.add(txtOutput);
    
   
        // Mengatur ukuran frame dan layout
        this.setSize(400, 650);
        this.setLayout(null); // Menggunakan layout null untuk posisi absolut
    }

    private void resetForm() {
        textFieldNama.setText("");
        textFieldHP.setText("");
        radioButtonLaki.setSelected(false);
        radioButtonPerempuan.setSelected(false);
        checkBoxWNA.setSelected(false);
        listTabungan.clearSelection();
        spinnerFrekuensi.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        spinnerTanggalLahir.setValue(new java.util.Date());
        txtOutput.setText("");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PendaftaranNasabahBank frame = new PendaftaranNasabahBank();
                frame.setVisible(true);
            }
        });
    }
}