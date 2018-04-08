/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import someHelp.Secuencial;

/**
 *
 * @author jf_me
 */
public class psvm {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser jc=new JFileChooser();
        jc.setCurrentDirectory(new File("files/"));
        jc.showOpenDialog(jc);
        File f=jc.getSelectedFile();
        System.out.println(f.getAbsolutePath());
        try {
            Secuencial s=new Secuencial(f);
            System.out.println(s.readText());
        } catch (IOException ex) {
            Logger.getLogger(psvm.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader fis=new BufferedReader(new FileReader(f));
        RandomAccessFile raf=new RandomAccessFile(f, "rw");
        
        int i;
       
        try {
            fis.mark(100);
            while((i=fis.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println();
            fis.reset();
            while((i=fis.read())!=-1){
                System.out.print((char)i);
            }
        } catch (IOException ex) {
            Logger.getLogger(psvm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
