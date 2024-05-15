package at.mat.game.objects;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
public class Arrow {

        private int x, y;
        private Image image;

        public Arrow(int x, int y, Image arrow) {
            this.x = x;
            this.y = y;
            this.image = arrow;
        }

        public Rectangle getBounds() {
            // Rückgabe eines Rechtecks mit der Größe des Pfeils und seiner aktuellen Position
            return new Rectangle(x, y, image.getWidth(), image.getHeight());
        }

    public void draw(Graphics g) {
        this.image.drawCentered(this.x,this.y);
    }
}

