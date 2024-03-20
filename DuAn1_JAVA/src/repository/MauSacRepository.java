package repository;

import java.util.ArrayList;
import model.MauSac;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class MauSacRepository {

    public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        Connection cn = JdbcHelper.getConnection();
        String sql = "SELECT * FROM MAU_SAC";
        Statement stm;
        try {
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MauSac mauSac = new MauSac(rs.getInt("MaMS"), rs.getString("TenMau"), rs.getBoolean("TrangThai"));
                listMauSac.add(mauSac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMauSac;
    }

    public Integer addMauSac(MauSac mauSac) {
        Integer row = null;
        String sql = "INSERT INTO MAU_SAC(TenMau,TrangThai)\n"
                + "VALUES(?,?)";
        Connection cn = JdbcHelper.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, mauSac.getTenMau());
            pstm.setBoolean(2, mauSac.isTrangThai());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MauSacRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
