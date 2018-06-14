package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javaswing.SinhVien;

/*@author hai*/
/**
 * description:
 */
public class DAO {//class ket noi JAVA - SQLServer// trao doi du lieu (get, set) giua JAVA - SQLServer

    /*=================== ATTRIBUTEs ================================*/
    private Connection conn;//ket noi

    /*=================== CONSTRUCTORs ================================*/
    public DAO() {//ham khoi tao connector, giup ket noi JAVA - SQLServer
                    //moi lan new DAO -> 1 lan ket noi
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien","root", "haile");
			
			System.out.println("ket noi toi mysql thanh cong!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*=================== OTHER METHODs  ===============================*/
    public boolean addSinhVien(SinhVien s) {//them 1 ban ghi sinh vien s vo database
String sql = "INSERT INTO sinhvien(ID, tenSV, diaChi, diem)"
                + "VALUES(?, ?, ?, ?)";//cau lenh SQL chen 1 ban ghi vao bang sinhvien
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh sql cho database
														// cu the la bang SinhVien cua database
            
            //set gia tri cu the tung cot cua bang SinhVien
            ps.setString(1, s.getID());//set ID cua sinh vien vao cot 1 cua bang
            ps.setString(2, s.getTenSV());//set tenSV vao cot 2
            ps.setString(3, s.getDiaChi());
            ps.setFloat(4, s.getDiem());//cot 4 - diem co kieu la float -> setFloat

            return ps.executeUpdate() > 0;//co chinh sua du lieu cua csdl thi return so luong ban ghi da chinh sua
											//khong chinh sua gi thi return 0
											//co thay doi database -> executeUpdate()
											//neu chi query du lieu -> executeQuery()
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        return false;
    }

    public ArrayList<SinhVien> getDanhSachSinhVien() {//doc cac ban ghi tu database, tra ve 1 ArrayList

        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();// ArrayList de luu cac phan tu SinhVien

        String sql = "SELECT * FROM sinhvien";//cau lenh truy van

        try {
            PreparedStatement ps = conn.prepareStatement(sql);//thuc thi cau lenh truy van
            
            ResultSet rs = ps.executeQuery();//rs luu cac gia tri duoc query ve tu database
                                               //neu chi truy van - quyery - thi dung ps.executeQuery
            while (rs.next()) {//doc den het cac ban ghi o databse
                SinhVien s = new SinhVien();
                s.setID(rs.getString("ID"));//lay cac gia tri tu rs de luu vo sinh vien s
                s.setTenSV(rs.getString("tenSV"));
                s.setDiaChi(rs.getString("diaChi"));
                s.setDiem(rs.getFloat("diem"));

                danhSachSinhVien.add(s);//them s vo danhSachSinhVien
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSachSinhVien;//return ArrayList danhSachSinhVien duoc doc tu database
    }

    public static void main(String[] args) {//test ket noi JAVA - SQLServer
        new DAO();
    }
}//class DAO
