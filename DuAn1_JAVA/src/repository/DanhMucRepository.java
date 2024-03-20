package repository;

import java.util.ArrayList;
import model.DanhMuc;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class DanhMucRepository {

    public ArrayList<DanhMuc> getAllDanhMuc() {
        ArrayList<DanhMuc> listDanhMuc = new ArrayList<>();
        Connection cn = JdbcHelper.getConnection();
        Statement stm;
        String sql = "SELECT * FROM DANH_MUC";
        try {
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                DanhMuc danhMuc = new DanhMuc(rs.getInt("MaDM"),rs.getString("TenDanhMuc"), rs.getBoolean("TrangThai"));
                listDanhMuc.add(danhMuc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDanhMuc;
    }
}
