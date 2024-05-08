package at.mat.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    private Shape shape;
    private String name ="";

    public Obstacle(int x, int y, Image image, String name) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.shape = new Rectangle(this.getX(), this.getY(),this.getWidth(), this.getHeight());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void draw(Graphics g){
        this.getImage().drawCentered(this.getX(),this.getY());
    }
    public Shape getShape(){
        return shape;
    }
    public void update(int delta){

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void draw() {
    }
}
