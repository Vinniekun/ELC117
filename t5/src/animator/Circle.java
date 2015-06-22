/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author vinnie
 */
public class Circle {
    
    private String path;
    private int radius1;
    private int radius2;
    private Point p;
    private Point limite;
    private boolean increasing;
    
    
    
    public Circle(Point p, String path, int radius1, int radius2){
        this.p = p;
        this.path = path;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.limite = (Point) p.clone();
        this.limite.x += 100;
        this.limite.y += 100;
        this.increasing = false;
    }
    
    public void desenha(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(p.x, p.y, radius1, radius2);
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
    
    public Point getLimite(){
        return limite;
    }
       
    public void raise(){
        this.radius1 += 1;
        this.radius2 += 1;
    }
    
    public void drop(){
        this.radius1 -= 1;
        this.radius2 -= 1;
    }
    
    public void zoom(){
        if(this.radius1 == 40)
            this.increasing = true;
        if(this.radius1 == 100)
            this.increasing = false;
    }
    
    public boolean getBool(){
        return this.increasing;
    }
    
}
