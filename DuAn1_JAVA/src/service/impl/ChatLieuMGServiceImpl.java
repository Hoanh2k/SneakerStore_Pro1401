package service.impl;

import java.util.ArrayList;
import model.ChatLieu;
import repository.ChatLieuMGRepository;
import service.ChatLieuMGService;

/**
 *
 * @author ADMIN
 */
public class ChatLieuMGServiceImpl implements ChatLieuMGService {

    private final ChatLieuMGRepository chatLieuMGRepository = new ChatLieuMGRepository();

    @Override
    public ArrayList<ChatLieu> getAllChatLieuMG() {
        return chatLieuMGRepository.getAllChatLieuMG();
    }
}
