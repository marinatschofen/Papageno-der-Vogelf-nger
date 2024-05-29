package at.mat.game.objects;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
public class Arrow {

        private int x, y;
        private Image image;
        private int shooterX;
        private int targetX;
        private boolean shooting;
        private Rectangle shape;
        private int rotation;
        private int speed;

        public Arrow(int x, int y, Image arrow) {
            this.x = x;
            this.y = y;
            this.image = arrow;
            this.image.rotate(90);
            this.shape = new Rectangle(this.x, this.y, this.image.getWidth(), this.image.getHeight());
            //shooterX = 400;
            //shooterY = 550;
            shooting = false;
            this.rotation = 0;
            shooting = false;
            this.speed = 15;
        }

        public Rectangle getBounds() {
            // Rückgabe eines Rechtecks mit der Größe des Pfeils und seiner aktuellen Position
            return new Rectangle(x, y, image.getWidth(), image.getHeight());
        }

    public void draw(Graphics g) {
        this.image.drawCentered(this.x,this.y);
    }

    public boolean isShooting() {
        return shooting;
    }
    public void rotate(int direction) {
            switch (direction) {
                case 0:
                    rotation++;
                    if (rotation> 1) {
                        rotation = 1;
                    } else {
                        this.image.rotate(30);
                    }
                    break;
                case 1:
                    rotation--;
                    if (rotation< -1){
                        rotation=-1;
                    } else {
                        this.image.rotate(-30);
                    }
                    break;
                default:
                    break;
            }
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public void update(float delta) {
            if (shooting) {
                switch (rotation) {
                    case -1:
                        this.x = this.x - (int) (this.speed * 0.5);
                        break;
                    case 0:
                        break;
                    case 1:
                        this.x = this.x + (int) (this.speed * 0.5);
                        break;
                    default:
                        break;
                }
                this.y = this.y - this.speed;
                // überprüf ob PFeil ausserhalb ist!!
                if (this.y <  (0-this.image.getHeight()/2)) {
                    this.shooting = false;
                    this.x = 400;
                    this.y = 600;
                }
            }
        }
}

