package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.HoaDonChiTiet;

public class HoaDonChiTietDAO {
    public ArrayList<HoaDonChiTiet> layThongTinHoaDonChiTiet() {
        ArrayList<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM HOA_DON_CHI_TIET";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // MaHDCT MaCTSP MaHD MaTT SoLuong DonGia MaKM GhiChu
            while (rs.next()) {
                int MaHDCT = rs.getInt("MaHDCT");
                int MaCTSP = rs.getInt("MaCTSP");
                int MaHD = rs.getInt("MaHD");
                int MaTT = rs.getInt("MaTT");
                int SoLuong = rs.getInt("SoLuong");
                double DonGia = rs.getDouble("DonGia");
                int MaKM = rs.getInt("MaKM");
                String GhiChu = rs.getString("GhiChu");

                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet(MaHDCT, MaCTSP, MaHD, MaTT, SoLuong, DonGia, MaKM,
                        GhiChu);
                list.add(HoaDonChiTiet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<HoaDonChiTiet> timKiemHoaDonBangMa(int maHD) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM HOA_DON_CHI_TIET WHERE MaHD = ?";
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setInt(1, maHD);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int MaHDCT = rs.getInt("MaHDCT");
                int MaCTSP = rs.getInt("MaCTSP");
                int MaHD = rs.getInt("MaHD");
                int MaTT = rs.getInt("MaTT");
                int SoLuong = rs.getInt("SoLuong");
                double DonGia = rs.getDouble("DonGia");
                int MaKM = rs.getInt("MaKM");
                String GhiChu = rs.getString("GhiChu");

                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet(MaHDCT, MaCTSP, MaHD, MaTT, SoLuong, DonGia, MaKM,
                        GhiChu);
                list.add(HoaDonChiTiet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
