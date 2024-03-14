/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author hoanh
 */
public class hoaDon {

    private int MaHD;
    private Date NgayTao;
    private double TongTien;
    private boolean TrangThai;
    private int MaTTKH;
    private int MaNV;
    public hoaDon() {
    }

    public hoaDon(int MaHD, Date NgayTao, double TongTien, boolean TrangThai, int MaTTKH, int MaNV) {
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
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
