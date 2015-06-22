package animator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

// Conjunto de objetos da animacao.
class ObjectSet {
    
    private double angulo = 60.0;
    public double t = 1.2;
    private Random rnd = new Random();
    private Motion motion;
    public ObjectSet(Dimension dim){
        motion = new Motion(dim);          
    }
    private Image[] images;
    private ArrayList<Rectangle> ret = new ArrayList<Rectangle>();
    private ArrayList<Star> stars = new ArrayList<Star>();
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    
    // Adiciona objetos da classe Image ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addImages(int n, Dimension dim, BufferedImage image, String path) {
        System.out.printf("Test: adding %d images\n", n);
        System.out.printf("Test: motion path %s\n", path);
        images = new Image[n];
        for (int i = 0; i < images.length; i++) {
            Point p = new Point(rnd.nextInt(dim.height-image.getHeight()), rnd.nextInt(dim.width-image.getWidth()));
            images[i] = new Image(p, image,path);
        }
    }
    
    // Adiciona objetos da classe Star ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addStars(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d stars\n", n);
        System.out.printf("Test: motion path %s\n", path);
        
        for (int i = 0; i < n; i++) {
            Point p = new Point(rnd.nextInt(dim.height - 100), rnd.nextInt(dim.width - 100));
            Star star = new Star(p,path,50,100);
            stars.add(star);
        }
    }
    
    // Adiciona objetos da classe Rectangle ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addRectangles(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d rectangles\n", n);
        System.out.printf("Test: motion path %s\n", path);
        for (int i = 0; i < n; i++) {
            Point p = new Point(rnd.nextInt(dim.height - 50), rnd.nextInt(dim.width - 50));
            Rectangle retangulo = new Rectangle(p, path, 150, 100);
            ret.add(retangulo);
        }
    }
    
    // Adiciona objetos da classe Circles ao ObjectSet.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void addCircles(int n, Dimension dim, String path) {
        System.out.printf("Test: adding %d circles\n", n);
        System.out.printf("Test: motion path %s\n", path);
        for (int i = 0; i < n; i++) {
            Point p = new Point(rnd.nextInt(dim.height - 50), rnd.nextInt(dim.width - 50));
            Circle circle = new Circle(p, path, 50, 50);
            circles.add(circle);
        }
        
    }
    
    // Desenha cada um dos objetos da animacao.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void drawAll(Graphics g) {
        System.out.println("drawAll");
        
        if(images != null){
            for (int i = 0; i < images.length; i++) {
                images[i].draw(g);
            }
        }
        
        if(ret != null){
            for (int i = 0; i < ret.size(); i++) {
                ret.get(i).desenha(g);
            }
        }
        
        if(stars != null){
            for (int i = 0; i < stars.size(); i++) {
                stars.get(i).desenha(g);
            }
        }
        
        if(circles != null){
            for (int i = 0; i < circles.size(); i++) {
                circles.get(i).desenha(g);
            }
        }
        
    }

    // Move cada um dos objetos da animacao.
    // O codigo abaixo eh somente um teste e precisa ser substituido.
    void moveAll() {
                
        //Mover a imagem
        if(images != null){
            for(int i=0; i<images.length; i++){
                if(images[i].Path().equalsIgnoreCase("Line")){
                    images[i].setPoint(motion.line(images[i].getPoint()));                    
                }
                if(images[i].Path().equalsIgnoreCase("Circle")){
                    images[i].setPoint(motion.rotation(images[i].getPoint(), images[i].getLimite(), angulo));
                    angulo+= 0.1;
                }
                if(images[i].Path().equalsIgnoreCase("Spiral")){
                    images[i].setPoint(motion.spiral(images[i].getPoint(), images[i].getLimite(), angulo*0.25));
                }
            }
        }
        
        //Mover o retangulo
        if(ret != null){
            for(int i=0; i<ret.size(); i++){
                if(ret.get(i).Path().equalsIgnoreCase("Line")){
                    ret.get(i).setPoint(motion.line(ret.get(i).getPoint()));
                    //System.out.println("Ponto x:" + ret.get(0).getPoint().x);
                    //System.out.println("Centro x: " + ret.get(0).getCentro().x);
                } 
                if(ret.get(i).Path().equalsIgnoreCase("Circle")){
                    ret.get(i).setPoint(motion.rotation(ret.get(i).getPoint(), ret.get(i).getLimite(), angulo));
                    angulo+= 0.1;
                }
                if(ret.get(i).Path().equalsIgnoreCase("Spiral")){
                    ret.get(i).setPoint(motion.spiral(ret.get(i).getPoint(), ret.get(i).getLimite(), angulo*0.25));
                }
                if(ret.get(i).Path().equalsIgnoreCase("Zoom")){
                    ret.get(i).zoom();
                    if(ret.get(i).getBool() == true)
                        ret.get(i).raise();
                    if(ret.get(i).getBool() == false)
                        ret.get(i).drop();
                }
            }
            
        }
        
        //Mover a estrela
        if(stars != null){
            for(int i=0; i<stars.size(); i++){
                if(stars.get(i).Path().equalsIgnoreCase("Line")){
                    stars.get(i).setPoint(motion.line(stars.get(i).getPoint()));
                }
                if(stars.get(i).Path().equalsIgnoreCase("Circle")){
                    stars.get(i).setPoint(motion.rotation(stars.get(i).getPoint(), stars.get(i).getLimite(), angulo));
                    angulo+= 0.1;
                }
                if(stars.get(i).Path().equalsIgnoreCase("Spiral")){
                    stars.get(i).setPoint(motion.spiral(stars.get(i).getPoint(), stars.get(i).getLimite(), angulo*0.25));
                }
                if(stars.get(i).Path().equalsIgnoreCase("Zoom")){
                    stars.get(i).zoom();
                    if(stars.get(i).getBool() == true)
                        stars.get(i).raise();
                    if(stars.get(i).getBool() == false)
                        stars.get(i).drop();
                }
            }
        }
        
        //Mover o circulo
        for(int i=0; i<circles.size(); i++){
            if(circles.get(i).Path().equalsIgnoreCase("Line")){
                circles.get(i).setPoint(motion.line(circles.get(i).getPoint()));
            }
            if(circles.get(i).Path().equalsIgnoreCase("Circle")){
                    circles.get(i).setPoint(motion.rotation(circles.get(i).getPoint(), circles.get(i).getLimite(), angulo));
                    angulo+= 0.1;
                }
            if(circles.get(i).Path().equalsIgnoreCase("Spiral")){
                    circles.get(i).setPoint(motion.spiral(circles.get(i).getPoint(), circles.get(i).getLimite(), angulo*0.25));
                }
            if(circles.get(i).Path().equalsIgnoreCase("Zoom")){
                    circles.get(i).zoom();
                    if(circles.get(i).getBool() == true)
                        circles.get(i).raise();
                    if(circles.get(i).getBool() == false)
                        circles.get(i).drop();
                }
        }
    }
}
