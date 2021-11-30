/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPK;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gic
 */
public class test {

    public static void main(String[] args) throws InterruptedException {
        JFrame jf = new JFrame("test");
        jf.setSize(800, 600);
        JPanel jp = new JPanel();
        jp.setSize(800, 600);
        JLabel jl = new JLabel("hello world!");
        jp.setLayout(null);
        Dimension size = jl.getPreferredSize();
        int x = 0;
        boolean reverse = false;
        jl.setBounds(x, jp.getHeight() / 2, size.width, size.height);
        jp.add(jl);
        jf.getContentPane().add(jp);
        jf.setVisible(true);
        
        
        while(true){
            if(x==jp.getWidth()-60&&!reverse) 
                reverse=true;
            else if(x==0&&reverse)
                reverse=false;
            if(reverse)
                x--;
            else x++;
            jl.setBounds(x,jp.getHeight()/2, size.width, size.height);
            Thread.sleep(10);
        }

//        for (int i = 0; i < 20; i++) {
//            if (i % 2 == 0) {
//                for (int j = 50; j > 0; j-=10) {
//                    jl.setBounds(j, jp.getHeight() / 2, size.width, size.height);
//                    Thread.sleep(10);
//                }
//            } else {
//                for (int j = 0; j < 50; j+=10) {
//                    jl.setBounds(j, jp.getHeight() / 2, size.width, size.height);
//                    Thread.sleep(10);
//                }
//            }
//
//        }

//        for (int i = 0; i < 100; i++) {
//            
//            jl.setBounds(20+i, jp.getHeight()/2, size.width, size.height);
//
//        }

//        //s=stock.substring(be, en - 1);
//        String stock="<html><p style=\"color:red\">gic</p></html>";
//        System.out.println("stock: "+stock);
//        System.out.println("stock substring: "+stock.substring(27, 30));
    }
}
