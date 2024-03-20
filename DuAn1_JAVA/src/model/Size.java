package model;

/**
 *
 * @author ADMIN
 */
public class Size {
    private int MaSize;
    private int KichThuoc;
    private boolean TrangThai;

    public Size() {
    }

    public Size(int MaSize, int KichThuoc, boolean TrangThai) {
        this.MaSize = MaSize;
        this.KichThuoc = KichThuoc;
        this.TrangThai = TrangThai;
    }

    public int getMaSize() {
        return MaSize;
    }

    public void setMaSize(int MaSize) {
        this.MaSize = MaSize;
    }

    public int getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(int KichThuoc) {
        this.KichThuoc = KichThuoc;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
