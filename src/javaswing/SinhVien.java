package javaswing;

/* @author hai*/
public class SinhVien {//dung de luu du lieu ve 1 sinh vien

    /*=================== ATTRIBUTEs ==================================*/
    private String ID;
    private String tenSV;
    private String diaChi;
    private float diem;

    /*=================== CONSTRUCTORs ================================*/
    public SinhVien() {

    }

    public SinhVien(String tenSV, String ID, String diaChi, float diem) {
        this.tenSV = tenSV;
        this.ID = ID;
        this.diaChi = diaChi;
        this.diem = diem;
    }

    /*=================== GETTTERs & SETTERs  ============================*/

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    /*=================== OTHER METHODs  ===============================*/
}//class SinhVien
