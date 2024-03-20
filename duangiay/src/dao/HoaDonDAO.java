package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connect.ConnectDB;
import model.HoaDon;
import model.HoaDon;

public class HoaDonDAO {
    public ArrayList<HoaDon> layThongTinHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM HOA_DON";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int MaHD = rs.getInt("MaHD");
                String NgayTao = rs.getString("NgayTao");
                double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");

                int MaTTKH = rs.getInt("MaTTKH");
                int MaNV = rs.getInt("MaNV");

                HoaDon HoaDon = new HoaDon(MaHD, NgayTao, TongTien, TrangThai, MaTTKH, MaNV);
                list.add(HoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<HoaDon> timKiemHoaDonBangMa(int maHD) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getCon();
            String sql = "SELECT * FROM HOA_DON WHERE MaHD = ?";
            PreparedStatement statement = null;
            statement = con.prepareStatement(sql);
            statement.setInt(1, maHD);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                int MaHD = rs.getInt("MaHD");
                String NgayTao = rs.getString("NgayTao");
                double TongTien = rs.getDouble("TongTien");
                boolean TrangThai = rs.getBoolean("TrangThai");

                int MaTTKH = rs.getInt("MaTTKH");
                int MaNV = rs.getInt("MaNV");

                HoaDon HoaDon = new HoaDon(MaHD, NgayTao, TongTien, TrangThai, MaTTKH, MaNV);
                list.add(HoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
