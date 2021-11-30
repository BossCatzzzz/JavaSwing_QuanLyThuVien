/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MagicDra
 */
public class ThongKeSachTrongThang {
    
    private String nam,thang;
    private int soluong;

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public ThongKeSachTrongThang() {
    }

    public ThongKeSachTrongThang(String nam, String thang, int soluong) {
        this.nam = nam;
        this.thang = thang;
        this.soluong = soluong;
    }

}
