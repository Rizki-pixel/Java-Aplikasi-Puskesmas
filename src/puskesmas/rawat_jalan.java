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
public class rawat_jalan extends javax.swing.JFrame {
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
    public rawat_jalan() {
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
     public void tableobat(){
        Object Header[]={"kode_resep","resep_obat"};
        DefaultTableModel data=new DefaultTableModel(null, Header);
        obat.setModel (data);
        setKoneksi();
        String sql="select*from resep";
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
            String sql="select right (kd_jalan,2)+1 from rawat_jalan ";
            ResultSet rs=stm.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    kodejalan.setText("RJ"+no);}
                }
            else
            {
                kodejalan.setText("RJ001"); 
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
        jDialog3 = new javax.swing.JDialog();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        obat = new javax.swing.JTable();
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
        cariperawat = new javax.swing.JButton();
        kodeobat = new javax.swing.JTextField();
        namaobat = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tglmasuk = new javax.swing.JTextField();
        kodejalan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNama1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cariinap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        jDialog3.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog3.setBackground(new java.awt.Color(0, 0, 51));
        jDialog3.setMinimumSize(new java.awt.Dimension(694, 430));
        jDialog3.setModal(true);
        jDialog3.setResizable(false);
        jDialog3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog3MouseClicked(evt);
            }
        });

        jInternalFrame4.setResizable(true);
        jInternalFrame4.setTitle("obat");
        jInternalFrame4.setPreferredSize(new java.awt.Dimension(694, 430));
        jInternalFrame4.setVisible(true);
        jInternalFrame4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInternalFrame4MouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        obat.setAutoCreateRowSorter(true);
        obat.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        obat.setModel(new javax.swing.table.DefaultTableModel(
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
        obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                obatMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(obat);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 670, 1230, 220));

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
                .addGap(25, 25, 25)
                .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btedit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(bthapus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttambah)
                    .addComponent(btedit)
                    .addComponent(btbatal)
                    .addComponent(btsimpan)
                    .addComponent(bthapus)
                    .addComponent(btkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 880, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Kode Pasien");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 108, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nama Pasien");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 108, -1));
        jPanel2.add(kodepasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 163, 30));
        jPanel2.add(namapasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 270, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Kode Dokter");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 108, -1));

        kodedokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodedokterActionPerformed(evt);
            }
        });
        jPanel2.add(kodedokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 161, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nama");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 108, -1));
        jPanel2.add(namadokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 270, 30));

        caridokter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caridokter.setText("Cari");
        caridokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridokterActionPerformed(evt);
            }
        });
        jPanel2.add(caridokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 90, 30));

        caripasien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caripasien.setText("Cari");
        caripasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caripasienActionPerformed(evt);
            }
        });
        jPanel2.add(caripasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Kode Resep");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 124, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Nama Obat");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 124, -1));

        cariperawat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cariperawat.setText("Cari");
        cariperawat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariperawatActionPerformed(evt);
            }
        });
        jPanel2.add(cariperawat, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 80, 30));
        jPanel2.add(kodeobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 163, 30));
        jPanel2.add(namaobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 75, 250, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Tanggal Periksa");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        tglmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglmasukActionPerformed(evt);
            }
        });
        jPanel2.add(tglmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 120, 248, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 260, 880, 240));

        kodejalan.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        kodejalan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kodejalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodejalanActionPerformed(evt);
            }
        });
        getContentPane().add(kodejalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 260, 310, 260));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puskesmas/Print.png"))); // NOI18N
        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 600, 310, -1));

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

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KODE RAWAT JALAN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 210, 280, -1));

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

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TABLE RAWAT JALAN");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 758, -1));

        cariinap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cariinap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/puskesmas/Text preview.png"))); // NOI18N
        cariinap.setText("Cari");
        cariinap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariinapActionPerformed(evt);
            }
        });
        getContentPane().add(cariinap, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 550, 310, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FORM RAWAT JALAN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 758, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/simas.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        // TODO add your handling code here:
String user_id = kodejalan.getText();

String kodedokterq = kodedokter.getText();
String namadokterq = namadokter.getText();
String kodepasienq = kodepasien.getText();
String namapasienq = namapasien.getText();
String kodeperawatq = kodeobat.getText();
String namaperawatq = namaobat.getText();
String tglmasukq = tglmasuk.getText();
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="UPDATE rawat_jalan SET kd_dokter='"+kodedokterq+"',nama_dokter='"+namadokterq+"',kd_pasien='"+kodepasienq+"',nama_pasien='"+namapasienq+"',kd_resep='"+kodeperawatq+"',resep_obat='"+namaperawatq+"',tgl_periksa='"+tglmasukq+"' WHERE kd_jalan LIKE '"+user_id+"'";
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

    private void btkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkeluarActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btkeluarActionPerformed

    private void btbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbatalActionPerformed
kodejalan.setText("");
kodedokter.setText("");
namadokter.setText("");
kodepasien.setText("");
namapasien.setText("");
kodeobat.setText("");
namaobat.setText("");
tglmasuk.setText("");
aktif(false);
setTombol(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btbatalActionPerformed

    private void cariinapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariinapActionPerformed
        // TODO add your handling code here:
        String user_id = kodejalan.getText();
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="SELECT * FROM rawat_jalan WHERE kd_jalan like '"+user_id+"'";
 ResultSet rs = statement.executeQuery(sql);
if (rs.next())
{
aktif(true);
setTombol(false);
kodedokter.setText(rs.getString(2));
namadokter.setText(rs.getString(3));
kodepasien.setText(rs.getString(4));
namapasien.setText(rs.getString(5));
kodeobat.setText(rs.getString(6));
namaobat.setText(rs.getString(7));
tglmasuk.setText(rs.getString(8));


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
String user_id = kodejalan.getText();

String kodedokterq = kodedokter.getText();
String namadokterq = namadokter.getText();
String kodepasienq = kodepasien.getText();
String namapasienq = namapasien.getText();
String kodeperawatq = kodeobat.getText();
String namaperawatq = namaobat.getText();
String tglmasukq = tglmasuk.getText();

{
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="insert into rawat_jalan values('"+user_id+"','"+kodedokterq+"','"+namadokterq+"','"+kodepasienq+"','"+namapasienq+"','"+kodeperawatq+"','"+namaperawatq+"','"+tglmasukq+"')";
int executeUpdate = statement.executeUpdate(sql);
statement.close();
JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan..","Insert Data",JOptionPane.INFORMATION_MESSAGE);
aktif(false);
setTombol(true);
kodejalan.setText("");

kodedokter.setText("");
namadokter.setText("");
kodepasien.setText("");
namapasien.setText("");
kodeobat.setText("");
namaobat.setText("");
tglmasuk.setText("");

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
        String user_id = kodejalan.getText();
      try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/puskesmas", "root", "");
Statement statement = (Statement) koneksi.createStatement();
String sql="DELETE FROM rawat_jalan WHERE kd_jalan LIKE '"+user_id+"'";
statement.executeUpdate(sql);
statement.close();
kodejalan.setText("");

kodedokter.setText("");
namadokter.setText("");
kodepasien.setText("");
namapasien.setText("");
kodeobat.setText("");
namaobat.setText("");
tglmasuk.setText("");

JOptionPane.showMessageDialog(null, "Data berhasil dihapus..","Insert Data",JOptionPane.INFORMATION_MESSAGE);
koneksi.close();
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException e) { JOptionPane.showMessageDialog(null, "Eror: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
//System.err.println("Exception: "+e.getMessage());
}finally{
tampilkan_data();
      }
    }//GEN-LAST:event_bthapusActionPerformed

    private void kodejalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodejalanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodejalanActionPerformed

    private void kodedokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodedokterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodedokterActionPerformed

    private void caridokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridokterActionPerformed
 jDialog2.setLocationRelativeTo(null);
        tabledokter();
    jDialog2.setVisible(true);
    }//GEN-LAST:event_caridokterActionPerformed

    private void caripasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caripasienActionPerformed
jDialog1.setLocationRelativeTo(null);
        tablepasien();
    jDialog1.setVisible(true);
    }//GEN-LAST:event_caripasienActionPerformed

    private void cariperawatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariperawatActionPerformed
jDialog3.setLocationRelativeTo(null);
        tableobat();
    jDialog3.setVisible(true);
    }//GEN-LAST:event_cariperawatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new cetak_rjalan().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tglmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglmasukActionPerformed

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
String Kodejalan=jTable1.getValueAt(baris, 0).toString();
kodejalan.setText(Kodejalan);
String Kodedokter=jTable1.getValueAt(baris, 1).toString();
kodedokter.setText(Kodedokter);
String Namadokter=jTable1.getValueAt(baris, 2).toString();
namadokter.setText(Namadokter);
String Kodepasien=jTable1.getValueAt(baris, 3).toString();
kodepasien.setText(Kodepasien); 
String Namapasien=jTable1.getValueAt(baris, 4).toString();
namapasien.setText(Namapasien);
String Kodeperawat=jTable1.getValueAt(baris, 5).toString();
kodeobat.setText(Kodeperawat);
String Namaperawat=jTable1.getValueAt(baris, 6).toString();
namaobat.setText(Namaperawat);
String Tanggalmasuk=jTable1.getValueAt(baris, 7).toString();
tglmasuk.setText(Tanggalmasuk);
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

    private void obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_obatMouseClicked
        // TODO add your handling code here:
        int baris = obat.getSelectedRow();
        kodeobat.setText(obat.getModel().getValueAt(baris, 0).toString());
        namaobat.setText(obat.getModel().getValueAt(baris, 1).toString());
        jDialog3.dispose();
    }//GEN-LAST:event_obatMouseClicked

    private void jInternalFrame4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInternalFrame4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame4MouseClicked

    private void jDialog3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(rawat_jalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rawat_jalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rawat_jalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rawat_jalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new rawat_jalan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbatal;
    private javax.swing.JButton btedit;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btkeluar;
    private javax.swing.JButton btsimpan;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton caridokter;
    private javax.swing.JButton cariinap;
    private javax.swing.JButton caripasien;
    private javax.swing.JButton cariperawat;
    private javax.swing.JTable dokter;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JDialog jDialog3;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kodedokter;
    private javax.swing.JTextField kodejalan;
    private javax.swing.JTextField kodeobat;
    private javax.swing.JTextField kodepasien;
    private javax.swing.JLabel lblwktu;
    private javax.swing.JTextField namadokter;
    private javax.swing.JTextField namaobat;
    private javax.swing.JTextField namapasien;
    private javax.swing.JTable obat;
    private javax.swing.JTable pasien;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tglmasuk;
    private javax.swing.JTextField txtNama1;
    private javax.swing.JTextField txtNik;
    // End of variables declaration//GEN-END:variables

    private void tampilkan_data() {
        DefaultTableModel tabelmapel = new DefaultTableModel();
        tabelmapel.addColumn("KODE JALAN");
        tabelmapel.addColumn("KODE DOKTER");
        tabelmapel.addColumn("NAMA DOKTER");
        tabelmapel.addColumn("KODE PASIEN");
        tabelmapel.addColumn("NAMA PASIEN");
        tabelmapel.addColumn("KODE RESEP");
        tabelmapel.addColumn("NAMA RESEP");
        tabelmapel.addColumn("TANGGAL PERIKSA");
        try {
            open_db();
             String sql = "select * from rawat_jalan";
            stm = (Statement) Con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {
                Object[] o =new Object[8];
                o[0] = rs.getString("kd_jalan");
                o[1] = rs.getString("kd_dokter");
                o[2] = rs.getString("nama_dokter");
                o[3] = rs.getString("kd_pasien");
                o[4] = rs.getString("nama_pasien");
                o[5] = rs.getString("kd_resep");
                o[6] = rs.getString("resep_obat");
                o[7] = rs.getString("tgl_periksa");
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
      kodejalan.requestFocus();}

    private void setTombol(boolean t) {
     bttambah.setEnabled(t);
     btsimpan.setEnabled(!t);
     bthapus.setEnabled(!t);
     btedit.setEnabled(!t);
     btbatal.setEnabled(!t);
    }
}
