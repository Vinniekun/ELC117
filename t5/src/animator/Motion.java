/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animator;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author vinnie
 */

public class Motion {
    
    private Dimension dim;
    private Point centro;
    private int raio;
    private boolean volta;
    private int vel;
    
    public Motion(Dimension dim){
        this.dim = dim;
        this.raio = 50;
        this.volta = false;
        this.vel = 5;
    }
    
    public Point line(Point p){
        p.setLocation(p.getX()+5, p.getY());
        if(p.getX() > dim.height){
            p.setLocation(-100, p.getY());
        }
        return p;
    }
    
    public Point rotation(Point p, Point origem, double angulo){
        
    double angleRad = (angulo/180)*Math.PI;
    double cosAngle = Math.cos(angleRad );
    double sinAngle = Math.sin(angleRad );
    double dx = (p.x);
    double dy = (p.y);
    
    p.x = (int) (origem.x + 60 * Math.cos(angulo));
    p.y = (int) (origem.y + 60 * Math.sin(angulo));
    
    //System.out.println("anglerad: "+ angleRad +" cosAngle: " +cosAngle+ " sinAngle:" +sinAngle+ " dx: " +dx+ " dy: " +dy);
    
    return p;
        
    
    }
    
    public Point spiral(Point p, Point origem, double angulo){
        
    double angleRad = (angulo/180)*Math.PI;
    double cosAngle = Math.cos(angleRad );
    double sinAngle = Math.sin(angleRad );
    double dx = (p.x-origem.x);
    double dy = (p.y-origem.y);
    
    //System.out.println("anglerad: "+ angleRad +" cosAngle: " +cosAngle+ " sinAngle:" +sinAngle+ " dx: " +dx+ " dy: " +dy);
    
    p.x = origem.x + (int) (dx*cosAngle-dy*sinAngle);
    p.y = origem.y + (int) (dx*sinAngle+dy*cosAngle);
    
    return p;
    }
    

    
}
