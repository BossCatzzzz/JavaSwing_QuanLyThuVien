/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;


/**
 *
 * @author Magic
 */
public class Sach {
    private String MaSach, TenSach, SoLuong, MaTheLoai, TomTat, tacgia;

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getSoLuong() {
        return Integer.parseInt(SoLuong);
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getTomTat() {
        return TomTat;
    }

    public void setTomTat(String TomTat) {
        this.TomTat = TomTat;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }
    
    public String[] ToListString()
    {    
        return new String[]{this.MaSach,this.TenSach,this.SoLuong,this.MaTheLoai,this.TomTat,this.tacgia};
    }

    public Sach() {
    }

    public Sach(String MaSach, String TenSach, String SoLuong, String MaTheLoai, String TomTat, String tacgia) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.SoLuong = SoLuong;
        this.MaTheLoai = MaTheLoai;
        this.TomTat = TomTat;
        this.tacgia = tacgia;
    }
    
    public boolean SearchOnAll(String key)
    {
        for (String item : this.ToListString()) {
           if(item.toLowerCase().contains(key.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
    
    
}
