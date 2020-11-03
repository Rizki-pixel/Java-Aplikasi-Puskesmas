/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puskesmas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class pemeriksaan extends javax.swing.JFrame {
    java.util.Date tglsekarang = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    //diatas adalah pengaturan format penulisan, bisa diubah sesuai keinginan.
    private final String tanggal = smpdtfmt.format(tglsekarang);
    private com.mysql.jdbc.Connection Con;
    java.sql.Connection con;
    java.sql.Statement st;
    ResultSet rs;
    java.sql.Connection conn;
    java.sql.Statement stm;
    /**
     * Creates new form user
     */
    public pemeriksaan() {
        initComponents();
        tampilkan_data();
        setLocationRelativeTo(this);
        aktif(false);
        setTombol(true);
        tgl.setText(tanggal);
        setJam();
        menampilkan();
    }
     public java.sql.Connection setKoneksi(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost/puskesmas","root","");
           stm=conn.createStatement();
       } catch (Exception e){
           JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
       }
       return conn;
    }
    public void tabledokter(){
        Object Header[]={"kd_dokter","nama_dokter"};
        DefaultTableModel data=new DefaultTableModel(null, Header);
        dokter.setModel (data);
        setKoneksi();
        String sql="select*from dokter";
        try{
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                
                String kolom[]={kolom1,kolom2};
                data.addRow(kolom);
            }
        }catch (Exception e){
            
        }
        }
     public void tablepasien(){
        Object Header[]={"kd_pasien","nama_pasien"};
        DefaultTableModel data=new DefaultTableModel(null, Header);
        pasien.setModel (data);
        setKoneksi();
        String sql="select*from pasien";
        try{
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                
                String kolom[]={kolom1,kolom2};
                data.addRow(kolom);
            }
        }catch (Exception e){
            
        }
        }
    
     private void id(){
        try {
            setKoneksi();
            String sql="select right (kd_pemeriksaan,2)+1 from pemeriksaan ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    kodepemeriksaan.setText("PR"+no);}
                }
            else
            {
                kodepemeriksaan.setText("PR001"); 
        }
        } catch (Exception e) 
        {
        }
    }
       public void menampilkan(){
        try{
            String host = "jdbc:mysql://localhost:3306/puskesmas";
            String user = "root";
            String pass = "";
            con=DriverManager.getConnection(host, user, pass);
            
            st = con.createStatement();
            String sql = "SELECT * FROM user";
            rs=stm.executeQuery(sql);
            
            rs.next();
            String NIK = rs.getString("user_id");
            String Nama = rs.getString("username");
            txtNik.setText(NIK);
            txtNama1.setText(Nama);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
     public final void setJam(){
ActionListener taskPerformer = new ActionListener() {

            @Override
public void actionPerformed(ActionEvent evt) {
String nol_jam = "", nol_menit = "",nol_detik = "";

java.util.Date dateTime = new java.util.Date();
int nilai_jam = dateTime.getHours();
int nilai_menit = dateTime.getMinutes();
int nilai_detik = dateTime.getSeconds();

if(nilai_jam <= 9) nol_jam= "0";
if(nilai_menit <= 9) nol_menit= "0";
if(nilai_detik <= 9) nol_detik= "0";

String jam = nol_jam + Integer.toString(nilai_jam);
String menit = nol_menit + Integer.toString(nilai_menit);
String detik = nol_detik + Integer.toString(nilai_detik);

lblwktu.setText(jam+":"+menit+":"+detik+"");
}
};
new Timer(1000, taskPerformer).start();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog2 = new javax.swing.JDialog();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dokter = new javax.swing.JTable();
        jDialog1 = new javax.swing.JDialog();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pasien = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        bttambah = new javax.swing.JButton();
        btsimpan = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        btbatal = new javax.swing.JButton();
        btkeluar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kodepasien = new javax.swing.JTextField();
        namapasien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        kodedokter = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        namadokter = new javax.swing.JTextField();
        caridokter = new javax.swing.JButton();
        caripasien = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tglperiksa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        hasil = new javax.swing.JTextField();
        combodiagnosa = new javax.swing.JComboBox();
        Tindakkan = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblwktu = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cariinap = new javax.swing.JButton();
        kodepemeriksaan = new javax.swing.JTextField();
        txtNik = new javax.swing.JTextField();
        txtNama1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jDialog2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog2.setBackground(new java.awt.Color(0, 0, 51));
        jDialog2.setMinimumSize(new java.awt.Dimension(694, 430));
        jDialog2.setModal(true);
        jDialog2.setResizable(false);
        jDialog2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog2MouseClicked(evt);
            }
        });

        jInternalFrame2.setResizable(true);
        jInternalFrame2.setTitle("Dokter");
        jInternalFrame2.setPreferredSize(new java.awt.Dimension(694, 430));
        jInternalFrame2.setVisible(true);
        jInternalFrame2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInternalFrame2MouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        dokter.setAutoCreateRowSorter(true);
        dokter.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        dokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dokterMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(dokter);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jDialog1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog1.setBackground(new java.awt.Color(0, 0, 51));
        jDialog1.setMinimumSize(new java.awt.Dimension(694, 430));
        jDialog1.setModal(true);
        jDialog1.setResizable(false);
        jDialog1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog1MouseClicked(evt);
            }
        });

        jInternalFrame3.setTitle("pasien");
        jInternalFrame3.setPreferredSize(new java.awt.Dimension(694, 430));
        jInternalFrame3.setVisible(true);
        jInternalFrame3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInternalFrame3MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        pasien.setAutoCreateRowSorter(true);
        pasien.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        pasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pasienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(pasien);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 690, 1230, 220));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bttambah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        btsimpan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        btedit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btedit.setText("Edit");
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditActionPerformed(evt);
            }
        });

        bthapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });

        btbatal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btbatal.setText("Batal");
        btbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbatalActionPerformed(evt);
            }
        });

        btkeluar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btkeluar.setText("Keluar");
        btkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btedit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btsimpan)
                .addGap(31, 31, 31)
                .addComponent(btedit)
                .addGap(27, 27, 27)
                .addComponent(bthapus)
                .addGap(28, 28, 28)
                .addComponent(btbatal)
                .addGap(26, 26, 26)
                .addComponent(btkeluar)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 250, 180, 370));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Kode Pasien");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 144, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nama Pasien");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 144, 29));
        jPanel2.add(kodepasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 340, 30));
        jPanel2.add(namapasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 450, 29));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Kode Dokter");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 144, 30));

        kodedokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodedokterActionPerformed(evt);
            }
        });
        jPanel2.add(kodedokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 340, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nama");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 144, 29));
        jPanel2.add(namadokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 450, 29));

        caridokter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caridokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puskesmas/Text preview.png"))); // NOI18N
        caridokter.setText("Cari");
        caridokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridokterActionPerformed(evt);
            }
        });
        jPanel2.add(caridokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 87, 30));

        caripasien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caripasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puskesmas/Text preview.png"))); // NOI18N
        caripasien.setText("Cari");
        caripasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caripasienActionPerformed(evt);
            }
        });
        jPanel2.add(caripasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 87, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Diagnosa");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 144, 29));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Tanggal Periksa");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 132, 20));

        tglperiksa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglperiksaActionPerformed(evt);
            }
        });
        jPanel2.add(tglperiksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 450, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Hasil");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 101, -1));
        jPanel2.add(hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 340, 30));

        combodiagnosa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Berat", "Ringan" }));
        combodiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combodiagnosaActionPerformed(evt);
            }
        });
        jPanel2.add(combodiagnosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 450, 29));

        Tindakkan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tindakkan.setText("Tindakan");
        Tindakkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TindakkanActionPerformed(evt);
            }
        });
        jPanel2.add(Tindakkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 660, 370));

        jButton9.setBackground(new java.awt.Color(179, 179, 179));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Exit.png"))); // NOI18N
        jButton9.setText("EXIT");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.setBorderPainted(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 810, 150, 100));

        jButton6.setBackground(new java.awt.Color(179, 179, 179));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Pasien");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setBorderPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 120, 40));

        jButton3.setBackground(new java.awt.Color(179, 179, 179));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Obat");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setBorderPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPreferredSize(new java.awt.Dimension(50, 47));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 120, 40));

        jButton5.setBackground(new java.awt.Color(179, 179, 179));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Dokter");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setBorderPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 120, 40));

        jButton2.setBackground(new java.awt.Color(179, 179, 179));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Perawatan");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setBorderPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 120, 40));

        jButton7.setBackground(new java.awt.Color(179, 179, 179));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Rawat Jalan");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.setBorderPainted(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 120, 40));

        jButton8.setBackground(new java.awt.Color(179, 179, 179));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Rawat Inap");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton8.setBorderPainted(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 120, 40));

        jButton10.setBackground(new java.awt.Color(179, 179, 179));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Pemeriksaan");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton10.setBorderPainted(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 120, 120, 40));

        lblwktu.setFont(new java.awt.Font("Agency FB", 1, 55)); // NOI18N
        lblwktu.setForeground(new java.awt.Color(240, 240, 240));
        lblwktu.setText("jLabel9");
        getContentPane().add(lblwktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 60, 210, -1));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tgl.setForeground(new java.awt.Color(240, 240, 240));
        tgl.setText("jLabel7");
        getContentPane().add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 30, 170, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("KODE PEMERIKSAAN");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 498, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("TABEL PEMERIKSAAN PASIEN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 640, 498, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("PEMERIKSAAN PASIEN");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 498, -1));

        cariinap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cariinap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puskesmas/Text preview.png"))); // NOI18N
        cariinap.setText("Cari");
        cariinap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariinapActionPerformed(evt);
            }
        });
        getContentPane().add(cariinap, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 340, 30));

        kodepemeriksaan.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        kodepemeriksaan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kodepemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodepemeriksaanActionPerformed(evt);
            }
        });
        getContentPane().add(kodepemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 340, 320));

        txtNik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNik.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNik.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNikActionPerformed(evt);
            }
        });
        getContentPane().add(txtNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 190, 30));

        txtNama1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNama1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNama1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(txtNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 190, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/simas.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        // TODO add your handling code here:
String user_id = kodepemeriksaan.getText();

String kodedokterq = kodedokter.getText();
String namadokterq = namadokter.getText();
String kodepasienq = kodepasien.getText();
String namapasienq = namapasien.getText();
String kodeperawatq = (String) combodiagnosa.getSelectedItem();
String namaperawatq = tglperiksa.getText();
String tglmasukq = hasil.getText();
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="UPDATE pemeriksaan SET kd_dokter='"+kodedokterq+"',nama_dokter='"+namadokterq+"',kd_pasien='"+kodepasienq+"',nama_pasien='"+namapasienq+"',diagnosa='"+kodeperawatq+"',tgl_pemeriksaan='"+namaperawatq+"',hasil='"+tglmasukq+"' WHERE kd_pemeriksaan LIKE '"+user_id+"'";
statement.executeUpdate(sql);
statement.close();
JOptionPane.showMessageDialog(null, "Data berhasil diedit..","Insert Data",JOptionPane.INFORMATION_MESSAGE);
koneksi.close();
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException e) {
JOptionPane.showMessageDialog(null, "Eror: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
//System.err.println("Exception: "+e.getMessage());
}finally{
tampilkan_data();
}
    }//GEN-LAST:event_bteditActionPerformed

    private void kodeperawatq(){ 
combodiagnosa.addItem("Berat"); 
combodiagnosa.addItem("Ringan"); 
combodiagnosa.setSelectedIndex(-1); }
    private void btkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkeluarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btkeluarActionPerformed

    private void btbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbatalActionPerformed
kodepemeriksaan.setText("");
kodedokter.setText("");
namadokter.setText("");
kodepasien.setText("");
namapasien.setText("");
combodiagnosa.setSelectedItem("");
tglperiksa.setText("");
hasil.setText("");
aktif(false);
setTombol(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btbatalActionPerformed

    private void cariinapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariinapActionPerformed
        // TODO add your handling code here:
        String user_id = kodepemeriksaan.getText();
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="SELECT * FROM pemeriksaan WHERE kd_pemeriksaan like '"+user_id+"'";
 ResultSet rs = statement.executeQuery(sql);
if (rs.next())
{
aktif(true);
setTombol(false);
kodedokter.setText(rs.getString(2));
namadokter.setText(rs.getString(3));
kodepasien.setText(rs.getString(4));
namapasien.setText(rs.getString(5));
combodiagnosa.setSelectedItem(rs.getString(6));
tglperiksa.setText(rs.getString(7));
hasil.setText(rs.getString(8));


JOptionPane.showMessageDialog(null, "Data ditemukan","Insert Data",JOptionPane.INFORMATION_MESSAGE);
}
else
{
JOptionPane.showMessageDialog(null, "Data tidak ditemukan ","Insert Data",JOptionPane.INFORMATION_MESSAGE);
}
statement.close();
koneksi.close();
}
catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException e)
{
JOptionPane.showMessageDialog(null, "Eror:"+e,"Gagal",JOptionPane.WARNING_MESSAGE);
//System.err.println("Exception: "+e.getMessage());
} 
    }//GEN-LAST:event_cariinapActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        // TODO add your handling code here:
String user_id = kodepemeriksaan.getText();

String kodedokterq = kodedokter.getText();
String namadokterq = namadokter.getText();
String kodepasienq = kodepasien.getText();
String namapasienq = namapasien.getText();
String kodeperawatq = (String) combodiagnosa.getSelectedItem();
String namaperawatq = tglperiksa.getText();
String tglmasukq = hasil.getText();

{
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="insert into pemeriksaan values('"+user_id+"','"+kodedokterq+"','"+namadokterq+"','"+kodepasienq+"','"+namapasienq+"','"+kodeperawatq+"','"+namaperawatq+"','"+tglmasukq+"')";
int executeUpdate = statement.executeUpdate(sql);
statement.close();
JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan..","Insert Data",JOptionPane.INFORMATION_MESSAGE);
aktif(false);
setTombol(true);
kodepemeriksaan.setText("");

kodedokter.setText("");
namadokter.setText("");
kodepasien.setText("");
namapasien.setText("");
combodiagnosa.setSelectedItem("");
tglperiksa.setText("");
hasil.setText("");

koneksi.close();
}
catch (     ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException e)
{
JOptionPane.showMessageDialog(null, "Eror: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
//System.err.println("Exception: "+e.getMessage());
}
finally {
tampilkan_data();
}
    }
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
aktif(true);
setTombol(false); 
id();// TODO add your handling code here:
    }//GEN-LAST:event_bttambahActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        // TODO add your handling code here:
        String user_id = kodepemeriksaan.getText();
      try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="DELETE FROM pemeriksaan WHERE kd_pemeriksaan LIKE '"+user_id+"'";
statement.executeUpdate(sql);
statement.close();
kodepemeriksaan.setText("");

kodedokter.setText("");
namadokter.setText("");
kodepasien.setText("");
namapasien.setText("");
combodiagnosa.setSelectedItem("");
tglperiksa.setText("");
hasil.setText("");

JOptionPane.showMessageDialog(null, "Data berhasil dihapus..","Insert Data",JOptionPane.INFORMATION_MESSAGE);
koneksi.close();
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException e) { JOptionPane.showMessageDialog(null, "Eror: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
//System.err.println("Exception: "+e.getMessage());
}finally{
tampilkan_data();
      }
    }//GEN-LAST:event_bthapusActionPerformed

    private void kodepemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodepemeriksaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodepemeriksaanActionPerformed

    private void kodedokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodedokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodedokterActionPerformed

    private void caridokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridokterActionPerformed
    jDialog2.setLocationRelativeTo(null);
    tabledokter();
    jDialog2.setVisible(true);
    }//GEN-LAST:event_caridokterActionPerformed

    private void caripasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caripasienActionPerformed
        // TODO add your handling code here:
       jDialog1.setLocationRelativeTo(null);
        tablepasien();
    jDialog1.setVisible(true);
    }//GEN-LAST:event_caripasienActionPerformed

    private void TindakkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TindakkanActionPerformed
        String kodeperawatq = (String)(combodiagnosa.getSelectedItem());
        if(kodeperawatq=="Berat"){
         new rawat_inap().setVisible(true);
             dispose();
        }
        else if(kodeperawatq=="Ringan"){
            new rawat_jalan().setVisible(true);
             dispose();    
        }

    }//GEN-LAST:event_TindakkanActionPerformed

    private void combodiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combodiagnosaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combodiagnosaActionPerformed

    private void tglperiksaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglperiksaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglperiksaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new pasien().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new resep().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new dokter().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new perawat().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        new rawat_jalan().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new rawat_inap().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new pemeriksaan().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNikActionPerformed

    }//GEN-LAST:event_txtNikActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int baris = jTable1.rowAtPoint(evt.getPoint());
String Kodepemeriksaan=jTable1.getValueAt(baris, 0).toString();
kodepemeriksaan.setText(Kodepemeriksaan);
String Kodedokter=jTable1.getValueAt(baris, 1).toString();
kodedokter.setText(Kodedokter);
String Namadokter=jTable1.getValueAt(baris, 2).toString();
namadokter.setText(Namadokter);
String Kodepasien=jTable1.getValueAt(baris, 3).toString();
kodepasien.setText(Kodepasien); 
String Namapasien=jTable1.getValueAt(baris, 4).toString();
namapasien.setText(Namapasien);
String diagnosa=jTable1.getValueAt(baris, 9).toString();
combodiagnosa.setSelectedItem(diagnosa);
String tanggalperiksa=jTable1.getValueAt(baris, 10).toString();
tglperiksa.setText(tanggalperiksa);
String Hasil=jTable1.getValueAt(baris, 5).toString();
hasil.setText(Hasil);
aktif(true);
setTombol(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void dokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dokterMouseClicked
        // TODO add your handling code here:
        int baris = dokter.getSelectedRow();
        kodedokter.setText(dokter.getModel().getValueAt(baris, 0).toString());
        namadokter.setText(dokter.getModel().getValueAt(baris, 1).toString());
        jDialog2.dispose();
    }//GEN-LAST:event_dokterMouseClicked

    private void jInternalFrame2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInternalFrame2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame2MouseClicked

    private void jDialog2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog2MouseClicked

    private void pasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasienMouseClicked
        // TODO add your handling code here:
        int baris = pasien.getSelectedRow();
        kodepasien.setText(pasien.getModel().getValueAt(baris, 0).toString());
        namapasien.setText(pasien.getModel().getValueAt(baris, 1).toString());
        jDialog1.dispose();
    }//GEN-LAST:event_pasienMouseClicked

    private void jInternalFrame3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInternalFrame3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame3MouseClicked

    private void jDialog1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new pemeriksaan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Tindakkan;
    private javax.swing.JButton btbatal;
    private javax.swing.JButton btedit;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btkeluar;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton caridokter;
    private javax.swing.JButton cariinap;
    private javax.swing.JButton caripasien;
    private javax.swing.JComboBox combodiagnosa;
    private javax.swing.JTable dokter;
    private javax.swing.JTextField hasil;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kodedokter;
    private javax.swing.JTextField kodepasien;
    private javax.swing.JTextField kodepemeriksaan;
    private javax.swing.JLabel lblwktu;
    private javax.swing.JTextField namadokter;
    private javax.swing.JTextField namapasien;
    private javax.swing.JTable pasien;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tglperiksa;
    private javax.swing.JTextField txtNama1;
    private javax.swing.JTextField txtNik;
    // End of variables declaration//GEN-END:variables

    private void tampilkan_data() {
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("KODE PEMERIKSAAN");
        tabelmapel.addColumn("KODE DOKTER");
        tabelmapel.addColumn("NAMA DOKTER");
        tabelmapel.addColumn("KODE PASIEN");
        tabelmapel.addColumn("NAMA PASIEN");
        tabelmapel.addColumn("DIAGNOSA");
        tabelmapel.addColumn("TANGGAL PERIKSA");
        tabelmapel.addColumn("HASIL");
        try {
            open_db();
             String sql = "select * from pemeriksaan";
            stm = (Statement) Con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {
                Object[] o =new Object[8];
                o[0] = rs.getString("kd_pemeriksaan");
                o[1] = rs.getString("kd_dokter");
                o[2] = rs.getString("nama_dokter");
                o[3] = rs.getString("kd_pasien");
                o[4] = rs.getString("nama_pasien");
                o[5] = rs.getString("diagnosa");
                o[6] = rs.getString("tgl_pemeriksaan");
                o[7] = rs.getString("hasil");
                tabelmapel.addRow(o);
                
            }
           jTable1.setModel(tabelmapel);
        } catch (Exception e) {
        }
    }

    private void open_db() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
Con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
            stm = (Statement) Con.createStatement();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi gagal");
            System.out.println(e.getMessage());
        }
    }

    private void aktif(boolean x) {
      
      kodepasien.setEditable(x);
      namapasien.setEditable(x);
      kodepemeriksaan.requestFocus();}

    private void setTombol(boolean t) {
     bttambah.setEnabled(t);
     btsimpan.setEnabled(!t);
     bthapus.setEnabled(!t);
     btedit.setEnabled(!t);
     btbatal.setEnabled(!t);
    }
}
