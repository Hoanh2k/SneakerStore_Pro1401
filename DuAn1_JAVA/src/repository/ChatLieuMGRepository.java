package repository;

import java.util.ArrayList;
import model.ChatLieu;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class ChatLieuMGRepository {

    //Chất liệu mặt giày
    public ArrayList<ChatLieu> getAllChatLieuMG() {
        ArrayList<ChatLieu> listChatLieuMG = new ArrayList<>();
        Connection cn = JdbcHelper.getConnection();
        String sql = "SELECT * FROM CHAT_LIEU";
        try {
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChatLieu chatLieu = new ChatLieu(rs.getInt("MaCL"), rs.getString("TenChatLieu"), rs.getBoolean("TrangThai"));
                listChatLieuMG.add(chatLieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuMGRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listChatLieuMG;
    }
}
