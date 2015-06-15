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
public class Star {
    
    private String path;
    private Point p;
    private int radius1;
    private int radius2;
    private int[] x1;
    private int[] x2;
    private int[] y1;
    private int[] y2;
    
    public Star(Point p, String path, int radius1, int radius2){
        this.p = p;
        this.path = path;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.x1 = new int[3];
        this.x2 = new int[10];
        this.y1 = new int[3];
        this.y2 = new int[10];
        this.p = new Point(p.x,p.y);
    }
    
    public void desenha(Graphics g){
        double angulo = Math.PI;
        int a = 0;
        for(int i=0; i<5; i++){
            x1[0] = (int) ((radius1 * Math.cos(angulo)) + p.x);
            y1[0] = (int) ((radius1 * Math.sin(angulo)) + p.y);
            x2[a] = x1[0];
            y2[a] = y1[0];
            a++;
            
            angulo = angulo + Math.PI/5;
            x1[1] = (int) ((radius2 * Math.cos(angulo)) + p.x);
            y1[1] = (int) ((radius2 * Math.sin(angulo)) + p.y);
            angulo= angulo + Math.PI/5;
            
            x1[2] = (int) ((radius1 * Math.cos(angulo)) + p.x);
            y1[2] = (int) ((radius1 * Math.sin(angulo)) + p.y);
            x2[a] = x1[2];
            y2[a] = y1[2];
            
            g.setColor(Color.YELLOW);
            g.fillPolygon(x1, y1, 3);
        }
        g.fillPolygon(x2, y2, 5);
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
