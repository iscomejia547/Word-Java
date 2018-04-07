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

    //constructor que usa la ruta como parametro
    public TextModel(String path) throws IOException {
        this.PATH = path;
        load();
    }

    //constructor que usa el archivo como parametro
    public TextModel(File fl) throws IOException {
        this.file = fl;
        load();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    //funcion de carga
    private void load() throws IOException{
        //la ruta no puede ser vacia
        if (PATH==null && file==null){
            throw new NullPointerException("Parametros de archivo no válidos");
        }
        //si el archivo no se ha instanciado, se hace
        if(file==null){
            file=new File(PATH);
        }else{
            PATH=file.getPath();
        }
        //si no existe, se crea
        if(!file.exists()){
            file.createNewFile();
        }
        //corrientes de entrada y salida
        fis=new FileInputStream(file);
        fos=new FileOutputStream(file, false);
    }
    //cerrar flujos para reiniciar lectura y escritura
    public void close() throws IOException {
        if(fis!=null){
            fis.close();
        }
        if(fos!=null) {
            fos.close();
        }
    }
    
    private void open() throws IOException{
        fis=new FileInputStream(file);
        fos=new FileOutputStream(file, false);
    }

    //escribir
    public boolean writeFile(String text) throws IOException{
        //verifica el texto enviado
        open();
        if(text==null || text.isEmpty()){
            return false;
        }
        //escribe
        fos.write(text.getBytes());
        close();//cierra el flujo
        return true;
    }
    //lee
    public String readFile() throws IOException{
        //crea un texto que sera el retorno, y un entero que almacenara las letras (ya que en secuencial se lee letra a letra)
        open();
        String text="";int n;
        //leyendo letras, hasta el EOF
        while((n=fis.read())!=-1){
            text+=(char)n;
        }
        close();//cierra el flujo
        return text;
    }
}
