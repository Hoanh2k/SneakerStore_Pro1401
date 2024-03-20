package service.impl;

import java.util.ArrayList;
import model.MauSac;
import repository.MauSacRepository;
import service.MauSacService;

/**
 *
 * @author ADMIN
 */
public class MauSacServiceImpl implements MauSacService{
    private final MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public ArrayList<MauSac> getAllMauSac() {
        return mauSacRepository.getAllMauSac();
    }

    @Override
    public Integer addMauSac(MauSac mauSac) {
        return mauSacRepository.addMauSac(mauSac);
    }
    
    
}
