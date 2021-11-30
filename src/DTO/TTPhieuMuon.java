/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class TTPhieuMuon {

    private String  tengd,  slmuon, sophieumuon,  madg;
    private Date ngaymuon,ngayhentra,ngaytra;
    private DefaultTableModel dss;

    public TTPhieuMuon(String sophieumuon, Date ngaymuon, Date ngayhentra, Date ngaytra, String tengd, String slmuon, String madg) {
        this.ngaymuon = ngaymuon;
        this.tengd = tengd;
        this.ngayhentra = ngayhentra;
        this.slmuon = slmuon;
        this.sophieumuon = sophieumuon;
        this.ngaytra = ngaytra;
        this.madg = madg;
    }

    public TTPhieuMuon() {
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public void setTengd(String tengd) {
        this.tengd = tengd;
    }

    public void setNgayhentra(Date ngayhentra) {
        this.ngayhentra = ngayhentra;
    }

    public void setSlmuon(String slmuon) {
        this.slmuon = slmuon;
    }

    public void setSophieumuon(String sophieumuon) {
        this.sophieumuon = sophieumuon;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    public void setDss(DefaultTableModel dss) {
        this.dss = dss;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public String getTengd() {
        return tengd;
    }

    public Date getNgayhentra() {
        return ngayhentra;
    }

    public String getSlmuon() {
        return slmuon;
    }

    public String getSophieumuon() {
        return sophieumuon;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public String getMadg() {
        return madg;
    }

    public DefaultTableModel getDss() {
        return dss;
    }

    public String[] ToListString() {
        if (this.ngaytra == null) {
            return new String[]{"<html><p style=\"color:red\">" + this.sophieumuon + "</p></html>", "<html><p style=\"color:red\">" + this.tengd + "</p></html>", "<html><p style=\"color:red\">" + this.ngaymuon + "</p></html>", "<html><p style=\"color:red\">" + this.ngayhentra + "</p></html>", "<html><p style=\"color:red\">Chưa trả</p></html>", "<html><p style=\"color:red\">" + this.slmuon + "</p></html>"};
        } else {
            return new String[]{this.sophieumuon, this.tengd, this.ngaymuon.toString(), this.ngayhentra.toString(), this.ngaytra.toString(), this.slmuon};
        }
    }

    public boolean SearchOnAll(String key) {
        if (this.madg.equals(key) || this.sophieumuon.equals(key) || this.tengd.toLowerCase().contains(key.toLowerCase())) {
            return true;
        }

        return false;
    }
}
