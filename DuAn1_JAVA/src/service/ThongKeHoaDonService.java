/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.chiTietSanPham;
import model.hoaDon;
import model.sanPham;
import utilities.JdbcHelper;

/**
 *
 * @author trung
 */
public class ThongKeHoaDonService {

    private final Connection connection;

    public ThongKeHoaDonService() throws SQLServerException {
        this.connection = JdbcHelper.getConnection();
    }

    public int daThanhToan() throws SQLException {
        int totalPaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM HOA_DON WHERE TrangThai = 1";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalPaidInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Throw the exception to be handled by the calling code
        }

        return totalPaidInvoices;
    }

    public int hoaDonCho() {
        int totalUnpaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM HOA_DON WHERE TrangThai = 0";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalUnpaidInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalUnpaidInvoices;
    }

    public int tongHoaDon() {
        int totalInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM HOA_DON";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalInvoices;
    }

    public Float sumTotal() {
        Float total = 0.0f;
        String sql = "SELECT SUM(TongTien) AS total_sum FROM HOA_DON WHERE TrangThai = 1;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                total = resultSet.getFloat("total_sum");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    

    public int dangKinhDoanh() throws SQLException {
        int totalPaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM SAN_PHAM WHERE TrangThai = 1";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalPaidInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Throw the exception to be handled by the calling code
        }

        return totalPaidInvoices;
    }

    public int ngungKinhDoanh() {
        int totalUnpaidInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM SAN_PHAM WHERE TrangThai = 0";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalUnpaidInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalUnpaidInvoices;
    }

    public int tongSP() {
        int totalInvoices = 0;
        String sql = "SELECT COUNT(*) AS tongHoaDon FROM SAN_PHAM";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                totalInvoices = resultSet.getInt("tongHoaDon");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalInvoices;
    }
    
    
    //lấy all chi tiet sản phẩm
    public List<chiTietSanPham> listAll() {
        List<chiTietSanPham> listAll = new ArrayList<>();
        String query = """
                     select CHI_TIET_SAN_PHAM.MaCTSP, SAN_PHAM.TenSP, CHAT_LIEU_DE_GIAY.TenChatLieuDe, 
                                        SIZE.KichThuoc, MAU_SAC.TenMau, CHAT_LIEU.TenChatLieu,  
                                        CHI_TIET_SAN_PHAM.DonGia,CHI_TIET_SAN_PHAM.SoLuong, Giam_Gia.MucGiam,CHI_TIET_SAN_PHAM.mota 
                                        from CHI_TIET_SAN_PHAM 
                                          
                     			join SAN_PHAM on SAN_PHAM.MaSP =  CHI_TIET_SAN_PHAM.MaSP 
                                        join CHAT_LIEU_DE_GIAY on CHAT_LIEU_DE_GIAY.MaCLDe  =  CHI_TIET_SAN_PHAM.MaCLDe
                                        join SIZE on SIZE.MaSize =  CHI_TIET_SAN_PHAM.MaSize
                                        join MAU_SAC on MAU_SAC.MaMS =  CHI_TIET_SAN_PHAM.MaMS
                                        Left join Giam_Gia on Giam_Gia.MaGG= CHI_TIET_SAN_PHAM.MaGG
                                        join CHAT_LIEU on CHAT_LIEU.MaCL =  CHI_TIET_SAN_PHAM.MaCL""";

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
                CTSP.setTenSize(rs.getInt("KichThuoc"));
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
  

    // fill Size
    public ArrayList getSize() {
        ArrayList listSize = new ArrayList<>();
        String query = "  select * from SIZE ";
        try {
            Connection conn = JdbcHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("TrangThai") == 1) {
                    int kichThuoc = rs.getInt("kichThuoc");
                    listSize.add(kichThuoc);
                }
            }
            return listSize;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //fill danh mục
    public ArrayList getChatLieuDe() {

        ArrayList listMaDM = new ArrayList<>();

        String query = "select * from Chat_Lieu_De_Giay";

        try {
            Connection conn = JdbcHelper.getConnection();
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("TrangThai") == 1) {
                    String tenChatLieuDe = rs.getString("tenChatLieuDe");
                    listMaDM.add(tenChatLieuDe);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaDM;
    }
    
    public ArrayList<hoaDon> getHoaDonCho(int trangThai) {
        ArrayList<hoaDon> listHDCho = new ArrayList<>();
        String query = """
                       select HOA_DON.MaHD,NHAN_VIEN.HoTen, HOA_DON.NgayTao,
                       HOA_DON.TrangThai,HOA_DON.TongTien  from HOA_DON 
                                         
                                         join NHAN_VIEN on HOA_DON.MaNV= NHAN_VIEN.MaNV
                                                      where HOA_DON.TrangThai like ?
                                                      order by MaHD desc """;

        try {
            Connection conn = JdbcHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + trangThai + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                hoaDon hd = new hoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setTenNV(rs.getString("HoTen"));
                hd.setNgayTao(rs.getString("ngayTao"));
                hd.setTrangThai(rs.getBoolean("trangThai"));
                hd.setTongTien(rs.getDouble("TongTien"));
                listHDCho.add(hd);
            }
            System.out.println("getdata");
            return listHDCho;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public void updateMucGiam(int maGG, float mucGiam) {
    String query = "UPDATE Giam_Gia SET MucGiam = ? WHERE MaGG = ?";
    try (Connection conn = JdbcHelper.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setFloat(1, mucGiam);
        stmt.setInt(2, maGG);
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy mã giảm giá tương ứng.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
