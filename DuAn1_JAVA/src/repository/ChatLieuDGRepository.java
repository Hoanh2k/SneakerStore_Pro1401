package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChatLieu;
import model.ChatLieuDeGiay;
import utilities.JdbcHelper;

/**
 *
 * @author ADMIN
 */
public class ChatLieuDGRepository {

    // Chất liệu Đế giày
    public ArrayList<ChatLieuDeGiay> getAllChatLieDG() {
        ArrayList<ChatLieuDeGiay> listChatLieuDG = new ArrayList<>();
        Connection cn = JdbcHelper.getConnection();
        String sql = "SELECT * FROM CHAT_LIEU_DE_GIAY";
        try {
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChatLieuDeGiay chatLieu = new ChatLieuDeGiay(rs.getInt("MaCLDe"), rs.getString("TenChatLieuDe"), rs.getBoolean("TrangThai"));
                listChatLieuDG.add(chatLieu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuMGRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listChatLieuDG;
    }
}
