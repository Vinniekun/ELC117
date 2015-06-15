package animator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

// Conjunto de objetos da animacao.
class ObjectSet {

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
            Point p = new Point(rnd.nextInt(dim.height - 50), rnd.nextInt(dim.width - 50));
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
            Rectangle retangulo = new Rectangle(p, path, 100, 50);
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
        System.out.println("moveAll");
        
        //Mover a imagem
        for(int i=0; i<images.length; i++){
            if(images[i].Path().equalsIgnoreCase("Line")){
                images[i].setPoint(motion.line(images[i].getPoint()));
            }
        }
        
        
        //Mover o retangulo
        for(int i=0; i<ret.size(); i++){
            if(ret.get(i).Path().equalsIgnoreCase("Line")){
                ret.get(i).setPoint(motion.line(ret.get(i).getPoint()));
            }
        
            if(ret.get(i).Path().equalsIgnoreCase("Circle")){
                
            }
            
        }
        
        //Mover a estrela
        for(int i=0; i<stars.size(); i++){
            if(stars.get(i).Path().equalsIgnoreCase("Line")){
                stars.get(i).setPoint(motion.line(stars.get(i).getPoint()));
            }
                
            
        }
        
        //Mover o circulo
        for(int i=0; i<circles.size(); i++){
            if(circles.get(i).Path().equalsIgnoreCase("Line")){
                circles.get(i).setPoint(motion.line(circles.get(i).getPoint()));
            }
                
            
        }
        
        
    }
}
