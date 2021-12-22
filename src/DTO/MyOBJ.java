/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Gic
 */
public class MyOBJ {
    public String BoQuaUNICODE(String s1) {
        String sa = "áàảãạăâắằẵẳặấầẩẫậ";
        String sd = "đ";
        String se = "éèẻẽẹêếềểễệ";
        String si = "íìỉĩị";
        String so = "óòỏõọốồổỗộôơớờởỡợ";
        String su = "úùủũụưứừửữự";
        String sy = "ýỳỷỹỵ";

        for (int i = 0; i < sa.length(); i++) {
            s1=s1.replace(sa.charAt(i), 'a');
        }
        for (int i = 0; i < sd.length(); i++) {
            s1=s1.replace(sd.charAt(i), 'd');
        }
        for (int i = 0; i < se.length(); i++) {
            s1=s1.replace(se.charAt(i), 'e');
        }
        for (int i = 0; i < si.length(); i++) {
            s1=s1.replace(si.charAt(i), 'i');
        }
        for (int i = 0; i < so.length(); i++) {
            s1=s1.replace(so.charAt(i), 'o');
        }
        for (int i = 0; i < su.length(); i++) {
            s1=s1.replace(su.charAt(i), 'u');
        }
        for (int i = 0; i < sy.length(); i++) {
            s1=s1.replace(sy.charAt(i), 'y');
        }

        return s1;
    }
}
