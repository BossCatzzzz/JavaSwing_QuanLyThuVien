/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


/**
 *
 * @author Magic
 */
public class DocGia{

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String Gioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    
    private String ten,ma,sdt,diachi,gioitinh,cmnd;
    

    public DocGia(String ma,String ten, String diachi, String sdt, String cmnd,String gt) {
        this.ten = ten;
        this.ma = ma;
        this.sdt = sdt;
        this.diachi = diachi;
        this.cmnd = cmnd;
        this.gioitinh=gt;
    }

    public DocGia() {
    }
    public String[] ToListString()
    {        
        return new String[]{this.ma,this.ten,this.diachi,this.sdt,this.cmnd,this.gioitinh};
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
