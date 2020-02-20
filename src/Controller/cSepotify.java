/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.*;
import model.*;
import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.File;
    
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Playlist;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.AncestorListener;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/**
 *
 * @author Farhan
 */
public class cSepotify implements ActionListener, MouseListener{
    
    private Playlist play_lst = new Playlist();
    private ArrayList update_playlst = new ArrayList();
    private javazoom.jl.player.Player player;
    private File simpan;
    
    
    private vSepotify vsepotify;
    
    public cSepotify() {
        vsepotify = new vSepotify();
        vsepotify.addActionListener(this);
        vsepotify.addMouseListener(this);
        vsepotify.setVisible(true);
        vsepotify.setlEmail(cLogin.email);
        
    }
     
    void update_playlst() {
        update_playlst = play_lst.getListSong();
        DefaultListModel model =  new DefaultListModel();
        for (int i = 0; i < update_playlst.size(); i++) {
            int j = i + 1;
            model.add(i, j + " | " + ((File) update_playlst.get(i)).getName());
        }
        vsepotify.getlDaftarList().setModel(model);

    }
    
    //pengontrol mp3
    
    void add(){
        play_lst.add(vsepotify);
        update_playlst();
    }
    
    void open(){
        play_lst.membuka_playlist(vsepotify);
        update_playlst();
    }
    
    void save(){
        play_lst.simpan_playlist(vsepotify);
        update_playlst();
    }
    
    void remove(){
        try {
            int akandihapus = vsepotify.getlDaftarList().getLeadSelectionIndex();
            play_lst.getList_array().remove(akandihapus);
            update_playlst();
        } catch (Exception e) {
        }
    }
    
    void up(){ 
        try {
            int metod1 = vsepotify.getlDaftarList().getLeadSelectionIndex();
            simpan = (File) play_lst.getList_array().get(metod1);
            play_lst.getList_array().remove(metod1);
            play_lst.getList_array().add(metod1 - 1, simpan );
            update_playlst();
            vsepotify.getlDaftarList().setSelectedIndex(metod1-1);
        } catch (Exception e) {
        }
    }
    
    void down(){
        try {
            int metod1 = vsepotify.getlDaftarList().getSelectedIndex();
            simpan = (File) play_lst.getList_array().get(metod1);
            play_lst.getList_array().remove(metod1);
            play_lst.getList_array().add(metod1 + 1, simpan );
            update_playlst();
            vsepotify.getlDaftarList().setSelectedIndex(metod1+1);
        } catch (Exception e) {
        }
    }
    
    //pengontrol musik
    File memutar1;
    static int a = 0;
    
    void putar(){
    if(a==0){
        try{
            int m1 = vsepotify.getlDaftarList().getSelectedIndex();
            memutar1 = (File) this.update_playlst.get(m1);
            FileInputStream file_input_stream = new FileInputStream(memutar1);
            BufferedInputStream buffered_input_stream = new BufferedInputStream(file_input_stream);
            player = new javazoom.jl.player.Player(buffered_input_stream);
            a =1;
        }catch(Exception e){
            System.out.println("Lagu Gagal DI Putar, Ada Kesalahan pada Code");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        putar();
    }
}
    
    File metode;    //sa = metode //s1 = metod1
    void next(){
    if(a==0){
        try{
            int metod1 = vsepotify.getlDaftarList().getSelectedIndex() +1;
            metode = (File) this.play_lst.getListSong().get(metod1);
            FileInputStream file_input_stream = new FileInputStream(metode);
            BufferedInputStream buffered_input_stream = new BufferedInputStream(file_input_stream);
            player = new javazoom.jl.player.Player(buffered_input_stream);
            a =1;
            vsepotify.getlDaftarList().setSelectedIndex(metod1);
        }catch(Exception e){
            System.out.println("Lagu Gagal DI Putar, Ada Kesalahan pada Code");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        next();
    }

}



void previous(){
    if(a==0){
        try{
            int metod1 = vsepotify.getlDaftarList().getSelectedIndex() -1;
            metode = (File) this.play_lst.getListSong().get(metod1);
            FileInputStream file_input_stream = new FileInputStream(metode);
            BufferedInputStream buffered_input_stream = new BufferedInputStream(file_input_stream);
            player = new javazoom.jl.player.Player(buffered_input_stream);
            a =1;
            vsepotify.getlDaftarList().setSelectedIndex(metod1);
        }catch(Exception e){
            System.out.println("Lagu Gagal DI Putar, Ada Kesalahan pada Code");
            System.out.println(e);
        }
        
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                
            }catch (Exception e){
            }
        }
    }.start();
    }else{
        player.close();
        a=0;
        previous();
    }
}

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(vsepotify.getbAdd())){
            add();
        }else if(source.equals(vsepotify.getbOpen())){
            open();
        }else if(source.equals(vsepotify.getbRemove())){
            remove();
        }else if(source.equals(vsepotify.getbSave())){
            save();
        }else if(source.equals(vsepotify.getbUp())){
            up();
        }else if(source.equals(vsepotify.getbDown())){
            down();
        }else if(source.equals(vsepotify.getbLogout())){
            vsepotify.dispose();
            player.close();
            new cLogin();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(vsepotify.getlPrev())){
            previous();
        }else if(source.equals(vsepotify.getlNext())){
            next();
        }else if(source.equals(vsepotify.getlStop())){
            player.close();
        }else if(source.equals(vsepotify.getlPause())){
            player.close();
        }else if(source.equals(vsepotify.getlPlay())){
            putar();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(vsepotify.getlPrev())){
            vsepotify.getlPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iPrevInvert.png")));
        }else if(source.equals(vsepotify.getlNext())){
            vsepotify.getlNext().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iNextInvert.png")));
        }else if(source.equals(vsepotify.getlStop())){
           vsepotify.getlStop().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iStopInvert.png")));
        }else if(source.equals(vsepotify.getlPause())){
            vsepotify.getlPause().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iPauseInvert.png")));
        }else if(source.equals(vsepotify.getlPlay())){
            vsepotify.getlPlay().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iPlayInvert.png")));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(vsepotify.getlPrev())){
            vsepotify.getlPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iPrev.png")));
        }else if(source.equals(vsepotify.getlNext())){
            vsepotify.getlNext().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iNext.png")));
        }else if(source.equals(vsepotify.getlStop())){
           vsepotify.getlStop().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iStop.png")));
        }else if(source.equals(vsepotify.getlPause())){
            vsepotify.getlPause().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iPause.png")));
        }else if(source.equals(vsepotify.getlPlay())){
            vsepotify.getlPlay().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/iPlay.png")));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    
}
