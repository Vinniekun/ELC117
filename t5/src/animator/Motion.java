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
    public double rot = 1.2;
    
    public Motion(Dimension dim){
        this.dim = dim;
    }
    
    public Point line(Point p){
        p.setLocation(p.getX()+5, p.getY());
        if(p.getX() > dim.height){
            p.setLocation(-100, p.getY());
        }
        return p;
    }
    
    /*public Point orbita(Point p, int radius){
        
        return p;
    }*/
    

    
}
