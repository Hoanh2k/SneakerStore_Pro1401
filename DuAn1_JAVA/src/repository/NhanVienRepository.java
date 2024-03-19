/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import utilities.JdbcHelper;

/**
 *
 * @author trung
 */
public class NhanVienRepository {

    private Connection connection;

    public NhanVienRepository() throws SQLServerException {
        this.connection = JdbcHelper.getConnection();
    }

    // Đọc thông tin nhân viên bằng ID
    public NhanVien getNhanVienById(int id) {
        String query = "SELECT * FROM NHAN_VIEN WHERE MaNV = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int maNV = resultSet.getInt("MaNV");
                String tenDangNhap = resultSet.getString("TenDangNhap");
                String matKhau = resultSet.getString("MatKhau");
                String hoTen = resultSet.getString("HoTen");
                int gioiTinh = resultSet.getInt("GioiTinh");
                String dienThoai = resultSet.getString("DienThoai");
                String email = resultSet.getString("Email");
                java.sql.Date ngayTao = resultSet.getDate("NgayTao");
                int chucVu = resultSet.getInt("ChucVu");
                int trangThai = resultSet.getInt("TrangThai");

                return new NhanVien(maNV, tenDangNhap, matKhau, hoTen, gioiTinh, dienThoai, email, ngayTao, chucVu, trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> getAllNhanViens() {
        String query = "SELECT * FROM NHAN_VIEN";
        List<NhanVien> nhanViens = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int maNV = resultSet.getInt("MaNV");
                String tenDangNhap = resultSet.getString("TenDangNhap");
                String matKhau = resultSet.getString("MatKhau");
                String hoTen = resultSet.getString("HoTen");
                int gioiTinh = resultSet.getInt("GioiTinh");
                String dienThoai = resultSet.getString("DienThoai");
                String email = resultSet.getString("Email");
                java.sql.Date ngayTao = resultSet.getDate("NgayTao");
                int chucVu = resultSet.getInt("ChucVu");
                int trangThai = resultSet.getInt("TrangThai");

                NhanVien nhanVien = new NhanVien(maNV, tenDangNhap, matKhau, hoTen, gioiTinh, dienThoai, email, ngayTao, chucVu, trangThai);
                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;

    }

    // add
    public void addNhanVien(NhanVien nhanVien) {
        if (nhanVien == null) {
            return;
        }

        String sql = """
    INSERT INTO NHAN_VIEN (TenDangNhap, MatKhau, HoTen, GioiTinh, DienThoai, Email, NgayTao, ChucVu, TrangThai)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, nhanVien.getTenDangNhap());
            stm.setString(2, nhanVien.getMatKhau());
            stm.setString(3, nhanVien.getHoTen());
            stm.setInt(4, nhanVien.getGioiTinh());
            stm.setString(5, nhanVien.getDienThoai());
            stm.setString(6, nhanVien.getEmail());
            stm.setDate(7, new java.sql.Date(nhanVien.getNgayTao().getTime()));
            stm.setInt(8, nhanVien.getChucVu());
            stm.setInt(9, nhanVien.getTrangThai());

            int check = stm.executeUpdate();

            if (check > 0) {
                System.out.println("Thêm nhân viên thành công");
            } else {
                System.out.println("Thêm nhân viên thất bại");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int maNV) {
        String sql = "DELETE FROM NHAN_VIEN WHERE MaNV = ?";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNV);
            int check = ps.executeUpdate();

            if (check > 0) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public NhanVien getNhanVienByTenDangNhap(String tenDangNhap) {
    String query = "SELECT * FROM NHAN_VIEN WHERE TenDangNhap = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, tenDangNhap);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int maNV = resultSet.getInt("MaNV");
            String matKhau = resultSet.getString("MatKhau");
            String hoTen = resultSet.getString("HoTen");
            int gioiTinh = resultSet.getInt("GioiTinh");
            String dienThoai = resultSet.getString("DienThoai");
            String email = resultSet.getString("Email");
            java.sql.Date ngayTao = resultSet.getDate("NgayTao");
            int chucVu = resultSet.getInt("ChucVu");
            int trangThai = resultSet.getInt("TrangThai");

            return new NhanVien(maNV, tenDangNhap, matKhau, hoTen, gioiTinh, dienThoai, email, ngayTao, chucVu, trangThai);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
    


//    public void addNhanVien(NhanVien nhanVien) {
//    String query = "INSERT INTO NHAN_VIEN (MaNV, TenDangNhap, MatKhau, HoTen, GioiTinh, DienThoai, Email, NgayTao, ChucVu, TrangThai) "
//            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    try (PreparedStatement statement = connection.prepareStatement(query)) {
//        statement.setString(1, nhanVien.getTenDangNhap());
//        statement.setString(2, nhanVien.getMatKhau());
//        statement.setString(3, nhanVien.getHoTen());
//        statement.setInt(4, nhanVien.getGioiTinh());
//        statement.setString(5, nhanVien.getDienThoai());
//        statement.setString(6, nhanVien.getEmail());
//        // Kiểm tra ngayTao trước khi sử dụng
//        if (nhanVien.getNgayTao() != null) {
//            statement.setDate(7, new java.sql.Date(nhanVien.getNgayTao().getTime()));
//        } else {
//            statement.setNull(7, java.sql.Types.DATE);
//        }
//        statement.setInt(8, nhanVien.getChucVu());
//        statement.setInt(9, nhanVien.getTrangThai());
//
//        statement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
}
