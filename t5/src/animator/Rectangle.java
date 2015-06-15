/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author vinnie
 */
public class Rectangle {
    private String path;
    private int x;
    private int y;
    private Point p;
    
    
    public Rectangle(Point p, String path, int x, int y){
        this.p = p;
        this.path = path;
        this.x = x;
        this.y = y;
    }
    
    public void desenha(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(p.x,p.y,x,y);
    }

    void add(ArrayList<Rectangle> ret) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String Path(){
        return path;
    }
    
    public void setPoint(Point p){
        this.p = p;
    }
    
    public Point getPoint(){
        return p;
    }
    

    
}
