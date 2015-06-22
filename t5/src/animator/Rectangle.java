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
    private int x; //tamanho
    private int y; //tamanho
    private Point p;
    private Point centro;
    private Point limite;
    private boolean increasing;
    
    
    public Rectangle(Point p, String path, int x, int y){
        this.p = p;
        this.centro = new Point(p.x, p.y); //(Point) p.clone();
        this.path = path;
        this.x = x;
        this.y = y;
        this.limite = (Point) p.clone();
        this.limite.x += 100;
        this.limite.y += 100;
        this.increasing = false;
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
    
    public Point getCentro(){
        return centro;
    }
    
    public Point getLimite(){
        return limite;
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void raise(){
        this.x += 1;
        this.y += 1;
    }
    
    public void drop(){
        this.x -= 1;
        this.y -= 1;
    }
    
    public void zoom(){
        if(this.x == 100)
            this.increasing = true;
        if(this.x == 200)
            this.increasing = false;
    }
    
    public boolean getBool(){
        return this.increasing;
    }
    
}
