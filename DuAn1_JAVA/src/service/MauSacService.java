package service;

import java.util.ArrayList;
import model.MauSac;

/**
 *
 * @author ADMIN
 */
public interface MauSacService {
    ArrayList<MauSac> getAllMauSac();
    Integer addMauSac(MauSac mauSac);
}
