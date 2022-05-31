/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaksinasi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ACER
 */
public class Controller {
    Model modelVaksin;
    View viewVaksin;
    public String data;
    public Controller(Model modelVaksin, View viewVaksin){
        this.modelVaksin = modelVaksin;
        this.viewVaksin = viewVaksin;
        
        if (modelVaksin.getBanyakData()!=0) {
            String dataVaksin[][] = modelVaksin.readVaksin();
            viewVaksin.tabel.setModel((new JTable(dataVaksin, viewVaksin.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         viewVaksin.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String NIK = viewVaksin.getNIK();
                String Nama = viewVaksin.getNama();
                
                String JenisVaksin = viewVaksin.getJenisvak();
                String Tanggal = viewVaksin.getTanggal();
                if(NIK.isEmpty() || Nama.isEmpty() || viewVaksin.getVaksinke().isEmpty() || Tanggal.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
                }else{
                    int Vaksinke = Integer.parseInt(viewVaksin.getVaksinke());
                    modelVaksin.insertData(NIK, Nama, Vaksinke, JenisVaksin, Tanggal);
                }
                
         
                String dataVaksin[][] = modelVaksin.readVaksin();
                viewVaksin.tabel.setModel((new JTable(dataVaksin, viewVaksin.namaKolom)).getModel());
            }
        });
         
          viewVaksin.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String NIK = viewVaksin.getNIK();
                String Nama = viewVaksin.getNama();
                int Vaksinke = Integer.parseInt(viewVaksin.getVaksinke());
                String JenisVaksin = viewVaksin.getJenisvak();
                String Tanggal = viewVaksin.getTanggal();
                modelVaksin.updateData(NIK, Nama, Vaksinke, JenisVaksin, Tanggal);

                String dataVaksin[][] = modelVaksin.readVaksin();
                viewVaksin.tabel.setModel((new JTable(dataVaksin, viewVaksin.namaKolom)).getModel());
            }
        });
         
          viewVaksin.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                viewVaksin.tfnik.setText("");
                viewVaksin.tfnama.setText("");
                viewVaksin.tfvaksinke.setText("");
                viewVaksin.tftanggal.setText("");
            }
        });
        
    
          viewVaksin.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = viewVaksin.tabel.getSelectedRow();
                data = viewVaksin.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = viewVaksin.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = viewVaksin.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          viewVaksin.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus NIK " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelVaksin.deleteData(data);
                String dataVaksin[][] = modelVaksin.readVaksin();
                viewVaksin.tabel.setModel((new JTable(dataVaksin, viewVaksin.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
    
}
