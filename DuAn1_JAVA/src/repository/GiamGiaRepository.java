/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GiamGia;
import utilities.JdbcHelper;

/**
 *
 * @author trung
 */
public class GiamGiaRepository {
    
    private Connection connection;

    public GiamGiaRepository() {
        this.connection = JdbcHelper.getConnection();
    }

    public GiamGia getGiamGiaById(int id) {
        String query = "SELECT * FROM Giam_Gia WHERE MaGG = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int maGG = resultSet.getInt("MaGG");
                String tenMaGiam = resultSet.getString("TenMaGiam");
                float mucGiam = resultSet.getFloat("MucGiam");
                java.sql.Date ngayBatDau = resultSet.getDate("NgayBatDau");
                java.sql.Date ngayKetThuc = resultSet.getDate("NgayKetThuc");
                String ghiChu = resultSet.getString("GhiChu");

                return new GiamGia(maGG, tenMaGiam, mucGiam, ngayBatDau, ngayKetThuc, ghiChu);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    public List<GiamGia> getAllGiamGias() {
        String query = "SELECT * FROM Giam_Gia";
        List<GiamGia> giamGias = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int maGG = resultSet.getInt("MaGG");
                String tenMaGiam = resultSet.getString("TenMaGiam");
                float mucGiam = resultSet.getFloat("MucGiam");
                java.sql.Date ngayBatDau = resultSet.getDate("NgayBatDau");
                java.sql.Date ngayKetThuc = resultSet.getDate("NgayKetThuc");
                String ghiChu = resultSet.getString("GhiChu");

                GiamGia giamGia = new GiamGia(maGG, tenMaGiam, mucGiam, ngayBatDau, ngayKetThuc, ghiChu);
                giamGias.add(giamGia);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return giamGias;
    }

    private void handleSQLException(SQLException e) {
        
        e.printStackTrace();
    }
    
}
