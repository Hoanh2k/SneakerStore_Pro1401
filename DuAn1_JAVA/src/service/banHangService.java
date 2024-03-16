/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.chiTietSanPham;
import model.sanPham;
import java.sql.*;
import utilities.JdbcHelper;

/**
 *
 * @author hoanh
 */
public class banHangService {

    JdbcHelper helper = new JdbcHelper();

    //lấy all chi tiet sản phẩm
    public List<chiTietSanPham> listAll() {
        List<chiTietSanPham> listAll = new ArrayList<>();
        String query = """
                     select CHI_TIET_SAN_PHAM.MaCTSP, SAN_PHAM.TenSP, CHAT_LIEU_DE_GIAY.TenChatLieuDe, 
                     SIZE.KichThuoc, MAU_SAC.TenMau, CHAT_LIEU.TenChatLieu,  
                     CHI_TIET_SAN_PHAM.DonGia,CHI_TIET_SAN_PHAM.SoLuong, Giam_Gia.MucGiam,CHI_TIET_SAN_PHAM.mota 
                     from CHI_TIET_SAN_PHAM 
                     
                     join SAN_PHAM on CHI_TIET_SAN_PHAM.MaSP = SAN_PHAM.MaSP
                     join CHAT_LIEU_DE_GIAY on CHI_TIET_SAN_PHAM.MaCLDe = CHAT_LIEU_DE_GIAY.MaCLDe
                     join SIZE on CHI_TIET_SAN_PHAM.MaSize = SIZE.MaSize
                     join MAU_SAC on CHI_TIET_SAN_PHAM.MaMS = MAU_SAC.MaMS
                     join Giam_Gia on Giam_Gia.MaGG= CHI_TIET_SAN_PHAM.MaGG
                     join CHAT_LIEU on CHI_TIET_SAN_PHAM.MaCL = CHAT_LIEU.MaCL""";

        Connection conn = null;
        try {
            conn = JdbcHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                chiTietSanPham CTSP = new chiTietSanPham();
                CTSP.setMaCTSP(rs.getInt("MaCTSP"));
                CTSP.setTenSP(rs.getString("TenSP"));
                CTSP.setTenCLDe(rs.getString("TenChatLieuDe"));
                CTSP.setTenSize(rs.getString("KichThuoc"));
                CTSP.setTenMS(rs.getString("TenMau"));
                CTSP.setTenCL(rs.getString("TenChatLieu"));
                CTSP.setDonGia(rs.getFloat("DonGia"));
                CTSP.setSoLuong(rs.getInt("SoLuong"));
                CTSP.setMucGG(rs.getFloat("MucGiam"));
                CTSP.setMoTa(rs.getString("mota"));
                listAll.add(CTSP);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAll;
    }

    //fill danh mục
    public ArrayList getMaDanhMuc() {

        ArrayList listMaDM = new ArrayList<>();

        String query = "select * from DANH_MUC";

        try {
            Connection conn = JdbcHelper.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("TrangThai") == 1) {
                    String tenDM = rs.getString("tenDanhMuc");
                    listMaDM.add(tenDM);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaDM;
    }

}
