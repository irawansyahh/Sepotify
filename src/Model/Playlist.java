/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
/**
 *
 * @author Farhan
 */
public class Playlist {
    private JFileChooser file_chooser = new JFileChooser();
    private ArrayList list_array = new ArrayList();
    
    public void add(JFrame frame){
        file_chooser.setMultiSelectionEnabled(true);
        int file_benar = file_chooser.showOpenDialog(frame);
        if (file_benar == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (file_benar == javax.swing.JFileChooser.APPROVE_OPTION){
            File[] file = file_chooser.getSelectedFiles();
            list_array.addAll(Arrays.asList(file));
        }
    }
    
    public ArrayList getListSong(){
        return list_array;
    }
    
    
    //save playlist
    FileOutputStream file_output_stream;
    ObjectOutputStream object_output_stream;
    
    public void simpan_playlist(JFrame frame){
        file_chooser.setMultiSelectionEnabled(false);
        int benar = file_chooser.showSaveDialog(frame);
        if (benar == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        } else if (benar == javax.swing.JFileChooser.APPROVE_OPTION){
            File playlist1 = file_chooser.getSelectedFile(); //pls = playlist1
            try{
                file_output_stream = new FileOutputStream(playlist1 + ".tgr");
                object_output_stream = new ObjectOutputStream(file_output_stream);
                for (int i=0; i<list_array.size() ; i++){
                    File sementara = (File) list_array.get(i);
                    object_output_stream.writeObject(sementara);
                }
                object_output_stream.close();
            }
            catch (Exception e){
                
        }
        }
    }
    FileInputStream file_input_stream;
    ObjectInputStream object_input_stream;
    
    public void membuka_playlist(JFrame frame){
        file_chooser.setMultiSelectionEnabled(false);
        int benar = file_chooser.showOpenDialog(frame);
        if (benar == javax.swing.JFileChooser.CANCEL_OPTION){
            return;
        }
        if (benar == javax.swing.JFileChooser.APPROVE_OPTION){
            File playlist1 = file_chooser.getSelectedFile();
            try{
                file_input_stream = new FileInputStream(playlist1);
                object_input_stream = new ObjectInputStream(file_input_stream);
                File sementara;
                while ((sementara = (File) object_input_stream.readObject()) != null){
                    list_array.add(sementara);
                }
              if ((sementara = (File) object_input_stream.readObject()) == null){
                  list_array.isEmpty();
              }
              object_input_stream.close();
            }catch (Exception e){
        }
        
        }
    }

    public ArrayList getList_array() {
        return list_array;
    }
}
