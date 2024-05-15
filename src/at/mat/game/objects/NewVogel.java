package at.mat.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class NewVogel extends Vogel {

    public NewVogel(int x, int y, Image image, String spritesheet, String aniname) {
        super(x, y, image,spritesheet, aniname);
        this.shape = new Rectangle(this.getX(), this.getY(),this.getWidth(), this.getHeight());

    }

    @Override
    public void draw(Graphics g) {
        this.getImage().drawCentered(this.getX(),this.getY());
        this.getAnimation().draw(this.getX(),this.getY());
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void update(int delta) {
        if (this.getY() > 768 + this.getHeight()) {
            this.setY(0-this.getHeight());

        }
        this.setY(this.getY()+4);

    }

    public boolean intersects(Shape shape) {
        // Berechne die Begrenzungsrahmen für den Vogel und den Pfeil

        // Überprüfe, ob sich die Begrenzungsrahmen überschneiden
        if (this.shape.intersects(shape)) {
            // Punktestand erhöhen oder andere Logik für das Treffen implementieren
            return true;
        }
        return false;
    }

}
