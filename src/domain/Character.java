/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author karol
 */
public class Character  extends Thread{

    int x;
    int y;
    int imgNum;

    private Image image;
    private ArrayList<Image> sprite, sprite2;
    private UnsynchronizedBuffer sharedLocation;

    public Character(int x, int y, int imgNum) {
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
       // this.sharedLocation = sharedLocation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Image> getSprite() {
        return sprite;
    }

    public void setSprite(ArrayList<Image> sprite) {
        this.sprite = sprite;
    }
    
    
    
}
