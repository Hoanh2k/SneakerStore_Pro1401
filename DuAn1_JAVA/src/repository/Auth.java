/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.NhanVien;

/**
 *
 * @author trung
 */
public class Auth {
    
    public static NhanVien User = null; 
    
    public static void clear() {
        Auth.User = null;
    }

    public static Boolean isLogin() {
        return Auth.User != null;
    }
 
}
