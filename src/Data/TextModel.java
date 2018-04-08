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
import java.io.RandomAccessFile;

/**
 *
 * @author jf_me
 */
public class TextModel {
    private RandomAccessFile raf;
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
        if(PATH==null && file==null){
            throw new NullPointerException("Parametros de entrada y salida no válidos");
        }
        if (file == null && PATH!=null) {
            file = new File(PATH);
        }else{
            PATH=file.getPath();
        }
        //
        if(!file.exists()){
            file.createNewFile();
        }
        raf=new RandomAccessFile(file, "rw");
        raf.seek(0);
    }
    //cerrar flujos para reiniciar lectura y escritura
    private void reset() throws IOException {
        raf.seek(0);
    }

    private void reset(long pos) throws IOException{
        raf.seek(pos);
    }


    //escribir
    public boolean writeFile(String text) throws IOException{
        //verifica el texto enviado
        if(text==null || text.isEmpty()){
            return false;
        }
        //escribe
        raf.write(text.getBytes());
        reset();
        return true;
    }
    //lee
    public String readFile() throws IOException{
        //crea un texto que sera el retorno, y un entero que almacenara las letras (ya que en secuencial se lee letra a letra
        String text="";int n;
        //leyendo letras, hasta el EOF
        while((n=raf.read())!=(-1)){
            text+=(char)n;
        }
        System.out.println(text);
        reset(0);//cierra el flujo
        return text;
    }
}
