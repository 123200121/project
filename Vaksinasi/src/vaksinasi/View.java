/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaksinasi;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class View extends JFrame{
    JLabel lnik = new JLabel("NIK");
    JLabel lnama = new JLabel("Nama");
    JLabel lvaksinke = new JLabel("Vaksin Ke-");
    JLabel ljenisvak = new JLabel("Jenis Vaksin");
    JLabel ltanggal = new JLabel("Tanggal");
    
    public JTextField tfnik = new JTextField();
    public JTextField tfnama = new JTextField();
    public JTextField tfvaksinke = new JTextField();
    String [] jenisvaksin = {"Sinovac", "Astra Zeneca", "Moderna", "Pfizer", "Sinopharm" };
    public JComboBox jenisvak = new JComboBox(jenisvaksin);
    public JTextField tftanggal = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"NIK", "Nama", "Vaksin Ke-", "Jenis Vaksin", "Tanggal"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Vaksin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(850,550);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 630, 450);
        
        add(lnik);
        lnik.setBounds(670, 20, 90, 20);
        add(tfnik);
        tfnik.setBounds(670, 40, 120, 20);
        
        add(lnama);
        lnama.setBounds(670, 60, 90, 20);
        add(tfnama);
        tfnama.setBounds(670, 80, 120, 20);
        
        add(lvaksinke);
        lvaksinke.setBounds(670, 100, 90, 20);
        add(tfvaksinke);
        tfvaksinke.setBounds(670, 120, 120, 20);
        
        add(ljenisvak);
        ljenisvak.setBounds(670, 140, 90, 20);
        add(jenisvak);
        jenisvak.setBounds(670, 160, 120, 20);
        
        add(ltanggal);
        ltanggal.setBounds(670, 180, 90, 20);
        add(tftanggal);
        tftanggal.setBounds(670, 200, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(670, 230, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(670, 260, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(670, 290, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(670, 320, 90, 20);
    }
    
    public String getNIK(){
        return tfnik.getText();
    }
    
    public String getNama(){
        return tfnama.getText();
    }
    
    public String getVaksinke(){
        return tfvaksinke.getText();
    }
    
    public String getJenisvak(){
        return (String) jenisvak.getSelectedItem();
    }
    
    public String getTanggal(){
        return tftanggal.getText();
    }
}
