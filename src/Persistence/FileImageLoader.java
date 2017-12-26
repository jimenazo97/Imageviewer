/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;
 
 import imageviewer.model.Image;
 import Persistence.ImageLoader;
 import java.io.BufferedInputStream;
 import java.io.File;
 import java.io.FileFilter;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.InputStream;
 
 /**
  *
  * @author Ithiel
  */
 public class FileImageLoader implements ImageLoader{
     
     private File[] files;
 
     public FileImageLoader(File folder) {
         this.files = folder.listFiles();
     }
     private FileFilter imageType(){
         return new FileFilter(){
             @Override
             public boolean accept(File pathname) {
                 return pathname.getName().endsWith(".jpg");
 
             }
         };      
     }
     
     //@Override
     public Image imageAt(int i){
         return new Image(){
             @Override
             public String name(){
                 return files[i].getName();
             }
             @Override
             public InputStream stream(){
                 try{
                     return new BufferedInputStream(new FileInputStream(files[i]));
                }catch(FileNotFoundException ex){
                    return null;
                }

             }
             @Override
             public Image next(){
                 //return imageAt(i == files.length-1 ? 0 : i+1);
                 return i == files.length - 1 ? imageAt(0):imageAt(i+1);
             }
             @Override
             public Image prev(){
                 if( i == 0){
                     return imageAt(files.length -1);
                 }else{
                     return imageAt(i-1);
                 }
             }
         };
                 
     }
 
     @Override
     public Image load() {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     
 }