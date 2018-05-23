/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author karol
 */
public class Thread1 extends Character {

    Thread thread = new Thread();
    private UnsynchronizedBuffer sharedLocation; // reference to shared object
    int velocidad;
    int veces;
    //private ArrayList<Image> sprite;

    public Thread1(int x, int y, int imagaNu) throws FileNotFoundException {
        super(x, y, imagaNu);
       // this.sharedLocation = sharedLocation;
        //this.velocidad = velocidad;
        //this.veces = veces;
        setSprite();

    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image>  sprite = super.getSprite();
        for (int i = 1; i < 2; i++) {
            sprite.add(new Image(new FileInputStream("src/assets/fast.png")));//Return
        }

        super.setSprite(sprite);
    }

    

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }
    
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int x=0;
        int y=0;
        while (true) {
            try {
                super.setX(x);
                Thread.sleep(5);
                
                y=y%1;
                super.setImage(sprite.get(y));
                y++;
                x++;
                if(x==700){
                x=0;
                }

            } 
            catch (InterruptedException ex) {}
        }
    } 

    
}
