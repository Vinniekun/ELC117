package animator;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

// Uma imagem na animacao.
class Image {

    BufferedImage img;
    Point pos;
    String path;

    public Image(Point pos, BufferedImage img, String path) {
        this.pos = pos;
        this.img = img;
        this.path = path;
    }

    public Point getPos() {
        return pos;
    }
    
    public void draw(Graphics g) {
        g.drawImage(img, (int) pos.getX(), (int) pos.getY(), null);
    }
    
    // Move a imagem de acordo segundo a trajetoria selecionada.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    public void move() {
       
    }
    
    public String Path(){
        return path;
    }
    
    public void setPoint(Point p){
        this.pos = p;
    }
    
    public Point getPoint(){
        return pos;
    }
    
}
