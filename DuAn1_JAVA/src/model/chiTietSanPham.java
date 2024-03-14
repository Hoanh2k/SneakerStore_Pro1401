package model;

/**
 *
 * @author ADMIN
 */
public class chiTietSanPham {
    private int MaCTSP;
    private int SoLuong;
    private float DonGia;
    private int MaSP;
    private int MaCLDe;
    private int MaSize;
    private int MaMS;
    private int MaCL;
    private String MoTa;
    private int MaGG;

    public chiTietSanPham() {
    }

    public chiTietSanPham(int MaCTSP, int SoLuong, float DonGia, int MaSP, int MaCLDe, int MaSize, int MaMS, int MaCL, String MoTa, int MaGG) {
        this.MaCTSP = MaCTSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.MaSP = MaSP;
        this.MaCLDe = MaCLDe;
        this.MaSize = MaSize;
        this.MaMS = MaMS;
        this.MaCL = MaCL;
        this.MoTa = MoTa;
        this.MaGG = MaGG;
    }

    public int getMaCTSP() {
        return MaCTSP;
    }

    public void setMaCTSP(int MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public int getMaCLDe() {
        return MaCLDe;
    }

    public void setMaCLDe(int MaCLDe) {
        this.MaCLDe = MaCLDe;
    }

    public int getMaSize() {
        return MaSize;
    }

    public void setMaSize(int MaSize) {
        this.MaSize = MaSize;
    }

    public int getMaMS() {
        return MaMS;
    }

    public void setMaMS(int MaMS) {
        this.MaMS = MaMS;
    }

    public int getMaCL() {
        return MaCL;
    }

    public void setMaCL(int MaCL) {
        this.MaCL = MaCL;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getMaGG() {
        return MaGG;
    }

    public void setMaGG(int MaGG) {
        this.MaGG = MaGG;
    }
    
}
