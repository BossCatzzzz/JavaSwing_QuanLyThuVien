/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class TTPhieuMuon {

    private String ngaymuon, tengd, ngayhentra, slmuon, sophieumuon, ngaytra, madg;
    private DefaultTableModel dss;

    public TTPhieuMuon(String sophieumuon, String ngaymuon, String ngayhentra, String ngaytra, String tengd, String slmuon, String madg) {
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

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public void setTengd(String tengd) {
        this.tengd = tengd;
    }

    public void setNgayhentra(String ngayhentra) {
        this.ngayhentra = ngayhentra;
    }

    public void setSlmuon(String slmuon) {
        this.slmuon = slmuon;
    }

    public void setSophieumuon(String sophieumuon) {
        this.sophieumuon = sophieumuon;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    public void setDss(DefaultTableModel dss) {
        this.dss = dss;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public String getTengd() {
        return tengd;
    }

    public String getNgayhentra() {
        return ngayhentra;
    }

    public String getSlmuon() {
        return slmuon;
    }

    public String getSophieumuon() {
        return sophieumuon;
    }

    public String getNgaytra() {
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
            return new String[]{"<html><p style=\"color:red\">" + this.sophieumuon + "</p></html>", "<html><p style=\"color:red\">" + this.tengd + "</p></html>", "<html><p style=\"color:red\">" + this.ngaymuon + "</p></html>", "<html><p style=\"color:red\">" + this.ngayhentra + "</p></html>", "<html><p style=\"color:red\">" + this.ngaytra + "</p></html>", "<html><p style=\"color:red\">" + this.slmuon + "</p></html>"};
        } else {
            return new String[]{this.sophieumuon, this.tengd, this.ngaymuon, this.ngayhentra, this.ngaytra, this.slmuon};
        }
    }

    public boolean SearchOnAll(String key) {
        if (this.madg.equals(key) || this.sophieumuon.equals(key) || this.tengd.toLowerCase().contains(key.toLowerCase())) {
            return true;
        }

        return false;
    }
}
