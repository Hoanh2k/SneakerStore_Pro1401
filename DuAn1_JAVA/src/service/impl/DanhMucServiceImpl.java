package service.impl;

import java.util.ArrayList;
import model.DanhMuc;
import repository.DanhMucRepository;
import service.DanhMucService;

/**
 *
 * @author ADMIN
 */
public class DanhMucServiceImpl implements DanhMucService {

    private final DanhMucRepository danhMucRepository = new DanhMucRepository();

    public ArrayList<DanhMuc> getAllDanhMuc() {
        return danhMucRepository.getAllDanhMuc();
    }
}
