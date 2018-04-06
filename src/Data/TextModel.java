/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author jf_me
 */
public class TextModel {
    private FileInputStream fis;//corriente de entrada secuecncial
    private FileOutputStream fos;//corriente de salida secuecncial
    private File file;//archvio a leer o escribir
    private String PATH;//ruta del archivo

    public TextModel(String path) {
        PATH = path;
    }
    
    private void load() throws IOException{
        if (PATH==null){
            throw new NullPointerException("Parametros de archivo no válidos");
        }
        if(file==null){
            file=new File(PATH);
        }
        if(!file.exists()){
            file.createNewFile();
        }
        fis=new FileInputStream(file);
        fos=new FileOutputStream(file, true);
    }
    
    public boolean writeFile(String text) throws IOException{
        if(text==null || text.isEmpty()){
            return false;
        }
        fos.write(text.getBytes());
        return true;
    }
    
    public String readFile() throws IOException{
        String text="";int n;
        while((n=fis.read())!=-1){
            text+=n;
        }
        return text;
    }
}
