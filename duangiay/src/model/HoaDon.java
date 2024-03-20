/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoanh
 */
public class HoaDon {

    private int MaHD;
    private String NgayTao;
    private double TongTien;
    private boolean TrangThai;
    private int MaTTKH;
    private int MaNV;

    public HoaDon() {
    }

    public HoaDon(int MaHD, String NgayTao, double TongTien, boolean TrangThai, int MaTTKH, int MaNV) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.MaTTKH = MaTTKH;
        this.MaNV = MaNV;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaTTKH() {
        return MaTTKH;
    }

    public void setMaTTKH(int MaTTKH) {
        this.MaTTKH = MaTTKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

}
